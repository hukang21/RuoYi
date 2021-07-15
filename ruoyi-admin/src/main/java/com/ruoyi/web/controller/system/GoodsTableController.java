package com.ruoyi.system.controller;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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
import com.ruoyi.system.domain.GoodsTable;
import com.ruoyi.system.service.IGoodsTableService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品管理Controller
 * 
 * @author ruoyi
 * @date 2021-07-09
 */
@Controller
@RequestMapping("/goods_system/goods_management")
public class GoodsTableController extends BaseController
{
    private String prefix = "goods_system/goods_management";

    @Autowired
    private IGoodsTableService goodsTableService;

    @RequiresPermissions("goods_system:goods_management:view")
    @GetMapping()
    public String goods_management()
    {
        return prefix + "/goods_management";
    }

    @RequiresPermissions("goods_system:goods_management:view")
    @GetMapping("/syt")
    public String syt()
    {
        return prefix + "/syt";
    }

    /**
     * 查询商品管理列表
     */
    @RequiresPermissions("goods_system:goods_management:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(GoodsTable goodsTable)
    {
        startPage();
        List<GoodsTable> list = goodsTableService.selectGoodsTableList(goodsTable);
        return getDataTable(list);
    }

    /**
     * 查询商品管理列表
     */
    @RequiresPermissions("goods_system:goods_management:list")
    @PostMapping("/get")
    @ResponseBody
    public AjaxResult get(GoodsTable goodsTable)
    {
        // 根据goodsId找到唯一的一条数据
        GoodsTable table = goodsTableService.selectGoodsTableByGoodsId(goodsTable);
        // 对数据进行处理
        if (table == null){
            return AjaxResult.error("不存在该商品，请重新输入！");
        }
        // 1. 根据前端传过来的库存判断是否合理
        Integer viewNum = Integer.parseInt(goodsTable.getGoodsNum());
        if (viewNum > Integer.parseInt(table.getGoodsNum()) || viewNum <= 0){
            return AjaxResult.error("库存不合理，请重新输入！");
        }
        return AjaxResult.success(table);
    }

    @RequiresPermissions("goods_system:goods_management:list")
    @PostMapping("/hhh")
    @ResponseBody
    public AjaxResult getl(String goodsTable)
    {
        JSONArray parse = (JSONArray)JSONObject.parse(goodsTable);
        // 根据goodsId找到唯一的一条数据
        for(int i=0;i<parse.size();i++) {
            JSONObject id = (JSONObject) parse.get(i);
            GoodsTable table = goodsTableService.selectGoodsTableById(Long.parseLong(id.get("goodsId").toString()));
            // 对数据进行处理
            Integer viewNum = Integer.parseInt( table.getGoodsNum());
            viewNum=Integer.parseInt(table.getGoodsNum())-Integer.parseInt(id.get("goodsNum").toString());
            table.setGoodsNum(""+ viewNum);
            goodsTableService.updateGoodsTable(table);
        }
        return AjaxResult.success("购买成功！");
    }
    /**
     * 导出商品管理列表
     */
    @RequiresPermissions("goods_system:goods_management:export")
    @Log(title = "商品管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(GoodsTable goodsTable)
    {
        List<GoodsTable> list = goodsTableService.selectGoodsTableList(goodsTable);
        ExcelUtil<GoodsTable> util = new ExcelUtil<GoodsTable>(GoodsTable.class);
        return util.exportExcel(list, "商品管理数据");
    }

    /**
     * 新增商品管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存商品管理
     */
    @RequiresPermissions("goods_system:goods_management:add")
    @Log(title = "商品管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(GoodsTable goodsTable)
    {
        return toAjax(goodsTableService.insertGoodsTable(goodsTable));
    }

    /**
     * 修改商品管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        GoodsTable goodsTable = goodsTableService.selectGoodsTableById(id);
        mmap.put("goodsTable", goodsTable);
        return prefix + "/edit";
    }

    /**
     * 修改保存商品管理
     */
    @RequiresPermissions("goods_system:goods_management:edit")
    @Log(title = "商品管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(GoodsTable goodsTable)
    {
        return toAjax(goodsTableService.updateGoodsTable(goodsTable));
    }

    /**
     * 删除商品管理
     */
    @RequiresPermissions("goods_system:goods_management:remove")
    @Log(title = "商品管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(goodsTableService.deleteGoodsTableByIds(ids));
    }
}
