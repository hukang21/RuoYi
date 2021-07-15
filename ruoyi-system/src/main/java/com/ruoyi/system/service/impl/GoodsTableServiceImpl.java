package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.GoodsTableMapper;
import com.ruoyi.system.domain.GoodsTable;
import com.ruoyi.system.service.IGoodsTableService;
import com.ruoyi.common.core.text.Convert;

/**
 * 商品管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-07-09
 */
@Service
public class GoodsTableServiceImpl implements IGoodsTableService 
{
    @Autowired
    private GoodsTableMapper goodsTableMapper;

    /**
     * 查询商品管理
     * 
     * @param id 商品管理ID
     * @return 商品管理
     */
    @Override
    public GoodsTable selectGoodsTableById(Long id)
    {
        return goodsTableMapper.selectGoodsTableById(id);
    }

    @Override
    public GoodsTable selectGoodsTableByGoodsId(GoodsTable goodsTable) {
        return goodsTableMapper.selectGoodsTableByGoodsId(goodsTable);
    }

    /**
     * 查询商品管理列表
     * 
     * @param goodsTable 商品管理
     * @return 商品管理
     */
    @Override
    public List<GoodsTable> selectGoodsTableList(GoodsTable goodsTable)
    {
        return goodsTableMapper.selectGoodsTableList(goodsTable);
    }

    /**
     * 新增商品管理
     * 
     * @param goodsTable 商品管理
     * @return 结果
     */
    @Override
    public int insertGoodsTable(GoodsTable goodsTable)
    {
        return goodsTableMapper.insertGoodsTable(goodsTable);
    }

    /**
     * 修改商品管理
     * 
     * @param goodsTable 商品管理
     * @return 结果
     */
    @Override
    public int updateGoodsTable(GoodsTable goodsTable)
    {
        return goodsTableMapper.updateGoodsTable(goodsTable);
    }

    /**
     * 删除商品管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteGoodsTableByIds(String ids)
    {
        return goodsTableMapper.deleteGoodsTableByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商品管理信息
     * 
     * @param id 商品管理ID
     * @return 结果
     */
    @Override
    public int deleteGoodsTableById(Long id)
    {
        return goodsTableMapper.deleteGoodsTableById(id);
    }
}
