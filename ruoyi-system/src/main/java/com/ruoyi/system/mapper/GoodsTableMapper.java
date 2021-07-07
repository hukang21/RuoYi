package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.GoodsTable;

/**
 * 商品管理Mapper接口
 * 
 * @author ruoyi
 * @date 2021-07-06
 */
public interface GoodsTableMapper 
{
    /**
     * 查询商品管理
     * 
     * @param id 商品管理ID
     * @return 商品管理
     */
    public GoodsTable selectGoodsTableById(Long id);

    /**
     * 查询商品管理列表
     * 
     * @param goodsTable 商品管理
     * @return 商品管理集合
     */
    public List<GoodsTable> selectGoodsTableList(GoodsTable goodsTable);

    /**
     * 新增商品管理
     * 
     * @param goodsTable 商品管理
     * @return 结果
     */
    public int insertGoodsTable(GoodsTable goodsTable);

    /**
     * 修改商品管理
     * 
     * @param goodsTable 商品管理
     * @return 结果
     */
    public int updateGoodsTable(GoodsTable goodsTable);

    /**
     * 删除商品管理
     * 
     * @param id 商品管理ID
     * @return 结果
     */
    public int deleteGoodsTableById(Long id);

    /**
     * 批量删除商品管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteGoodsTableByIds(String[] ids);
}
