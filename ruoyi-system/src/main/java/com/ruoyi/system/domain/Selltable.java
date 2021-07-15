package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 售货记录对象 selltable
 * 
 * @author ruoyi
 * @date 2021-07-14
 */
public class Selltable extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 记录编号 */
    private Long id;

    /** 商品编号 */
    @Excel(name = "商品编号")
    private Long gsId;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String gsName;

    /** 商品数量 */
    @Excel(name = "商品数量")
    private Long gsNum;

    /** 售出时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "售出时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date slTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setGsId(Long gsId) 
    {
        this.gsId = gsId;
    }

    public Long getGsId() 
    {
        return gsId;
    }
    public void setGsName(String gsName) 
    {
        this.gsName = gsName;
    }

    public String getGsName() 
    {
        return gsName;
    }
    public void setGsNum(Long gsNum) 
    {
        this.gsNum = gsNum;
    }

    public Long getGsNum() 
    {
        return gsNum;
    }
    public void setSlTime(Date slTime) 
    {
        this.slTime = slTime;
    }

    public Date getSlTime() 
    {
        return slTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("gsId", getGsId())
            .append("gsName", getGsName())
            .append("gsNum", getGsNum())
            .append("slTime", getSlTime())
            .toString();
    }
}
