package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品管理对象 goods_table
 *
 * @author ruoyi
 * @date 2021-07-07
 */
public class GoodsTable extends BaseEntity
{
   // 测试
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 商品编号 */
    @Excel(name = "商品编号")
    private Long goodsId;

    /** 商品名 */
    @Excel(name = "商品名")
    private String goodsName;

    /** 库存 */
    @Excel(name = "库存")
    private String goodsNum;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setGoodsId(Long goodsId)
    {
        this.goodsId = goodsId;
    }

    public Long getGoodsId()
    {
        return goodsId;
    }
    public void setGoodsName(String goodsName)
    {
        this.goodsName = goodsName;
    }

    public String getGoodsName()
    {
        return goodsName;
    }
    public void setGoodsNum(String goodsNum)
    {
        this.goodsNum = goodsNum;
    }

    public String getGoodsNum()
    {
        return goodsNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("goodsId", getGoodsId())
                .append("goodsName", getGoodsName())
                .append("goodsNum", getGoodsNum())
                .toString();
    }
}