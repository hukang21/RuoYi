package com.ruoyi.system.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.system.service.ISysRoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.StaffTable;
import com.ruoyi.system.service.IStaffTableService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 员工管理Controller
 * 
 * @author ruoyi
 * @date 2021-07-09
 */
@Controller
@RequestMapping("/staff_system/staff_management")
public class StaffTableController extends BaseController
{
    private String prefix = "staff_system/staff_management";

    @Autowired
    private IStaffTableService staffTableService;

    @Autowired
    private ISysRoleService roleService;

    @RequiresPermissions("staff_system:staff_management:view")
    @GetMapping()
    public String staff_management()
    {
        SysUser currentUser = ShiroUtils.getSysUser();
        String userName = currentUser.getUserName();
        if("客户经理1".equals(userName))
        {
            return  "test/mistake";
        }
        else {
            return prefix + "/staff_management";
        }
    }

    /**
     * 查询员工管理列表
     */
    @RequiresPermissions("staff_system:staff_management:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(StaffTable staffTable)
    {
        startPage();
        List<StaffTable> list = staffTableService.selectStaffTableList(staffTable);
        return getDataTable(list);
    }

    /**
     * 导出员工管理列表
     */
    @RequiresPermissions("staff_system:staff_management:export")
    @Log(title = "员工管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(StaffTable staffTable)
    {
        List<StaffTable> list = staffTableService.selectStaffTableList(staffTable);
        ExcelUtil<StaffTable> util = new ExcelUtil<StaffTable>(StaffTable.class);
        return util.exportExcel(list, "员工管理数据");
    }

    /**
     * 新增员工管理
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        mmap.put("roles", roleService.selectRoleAll().stream().filter(r -> !r.isAdmin()).collect(Collectors.toList()));
        return prefix + "/add";
    }

    /**
     * 新增保存员工管理
     */
    @RequiresPermissions("staff_system:staff_management:add")
    @Log(title = "员工管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(StaffTable staffTable)
    {
        return toAjax(staffTableService.insertStaffTable(staffTable));
    }

    /**
     * 修改员工管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        StaffTable staffTable = staffTableService.selectStaffTableById(id);
        mmap.put("staffTable", staffTable);
        return prefix + "/edit";
    }

    @GetMapping("/syt")
    public String Syt()
    {
        return  "goods_system/goods_management"+"/syt";
    }
    /**
     * 修改保存员工管理
     */
    @RequiresPermissions("staff_system:staff_management:edit")
    @Log(title = "员工管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(StaffTable staffTable)
    {
        return toAjax(staffTableService.updateStaffTable(staffTable));
    }

    /**
     * 删除员工管理
     */
    @RequiresPermissions("staff_system:staff_management:remove")
    @Log(title = "员工管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(staffTableService.deleteStaffTableByIds(ids));
    }
}
