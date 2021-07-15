package com.ruoyi.system.controller;

import java.util.List;
import java.util.Date;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.system.domain.GoodsTable;
import com.ruoyi.system.mapper.GoodsTableMapper;
import com.ruoyi.system.service.IGoodsTableService;
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
import com.ruoyi.system.domain.Selltable;
import com.ruoyi.system.service.ISelltableService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 售货记录Controller
 * 
 * @author ruoyi
 * @date 2021-07-14
 */
@Controller
@RequestMapping("/sellSystem/selltable")
public class SelltableController extends BaseController
{
    private String prefix = "sellSystem/selltable";

    @Autowired
    private IGoodsTableService goodsTableService;

    @Autowired
    private ISelltableService selltableService;

    @RequiresPermissions("sellSystem:selltable:view")
    @GetMapping()
    public String selltable()
    {
        return prefix + "/selltable";
    }

    @RequiresPermissions("sellSystem:selltable:list")
    @PostMapping("/tht")
    @ResponseBody
    public AjaxResult get1(String goodsTable)
    {
        JSONArray parse = (JSONArray)JSONObject.parse(goodsTable);
        // 根据goodsId找到唯一的一条数据
        for(int i=0;i<parse.size();i++) {
            JSONObject id = (JSONObject) parse.get(i);
            Selltable table=new Selltable();
            GoodsTable table1 = goodsTableService.selectGoodsTableById(Long.parseLong(id.get("Id").toString()));
            table.setId(table1.getId());
            table.setGsId(table1.getId());
            table.setGsName(table1.getGoodsName());
            table.setGsNum(Long.parseLong(id.get("goodsNum").toString()));
            Date data1=new Date();
            table.setSlTime(data1);
            selltableService.insertSelltable(table);
        }
        return AjaxResult.success("记录成功！");
    }
    /**
     * 查询售货记录列表
     */
    @RequiresPermissions("sellSystem:selltable:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Selltable selltable)
    {
        startPage();
        List<Selltable> list = selltableService.selectSelltableList(selltable);
        return getDataTable(list);
    }

    /**
     * 导出售货记录列表
     */
    @RequiresPermissions("sellSystem:selltable:export")
    @Log(title = "售货记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Selltable selltable)
    {
        List<Selltable> list = selltableService.selectSelltableList(selltable);
        ExcelUtil<Selltable> util = new ExcelUtil<Selltable>(Selltable.class);
        return util.exportExcel(list, "售货记录数据");
    }

    /**
     * 新增售货记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存售货记录
     */
    @RequiresPermissions("sellSystem:selltable:add")
    @Log(title = "售货记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Selltable selltable)
    {
        return toAjax(selltableService.insertSelltable(selltable));
    }

    /**
     * 修改售货记录
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Selltable selltable = selltableService.selectSelltableById(id);
        mmap.put("selltable", selltable);
        return prefix + "/edit";
    }

    /**
     * 修改保存售货记录
     */
    @RequiresPermissions("sellSystem:selltable:edit")
    @Log(title = "售货记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Selltable selltable)
    {
        return toAjax(selltableService.updateSelltable(selltable));
    }

    /**
     * 删除售货记录
     */
    @RequiresPermissions("sellSystem:selltable:remove")
    @Log(title = "售货记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(selltableService.deleteSelltableByIds(ids));
    }
}
