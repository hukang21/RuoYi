package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 员工管理对象 staff_table
 * 
 * @author ruoyi
 * @date 2021-07-06
 */
public class StaffTable extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 员工号 */
    @Excel(name = "员工号")
    private Long 员工号;

    /** 姓名 */
    @Excel(name = "姓名")
    private String 姓名;

    /** 性别 */
    @Excel(name = "性别")
    private String 性别;

    /** 职位 */
    @Excel(name = "职位")
    private String 职位;

    /** 工资 */
    @Excel(name = "工资")
    private Long 工资;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void set员工号(Long 员工号) 
    {
        this.员工号 = 员工号;
    }

    public Long get员工号() 
    {
        return 员工号;
    }
    public void set姓名(String 姓名) 
    {
        this.姓名 = 姓名;
    }

    public String get姓名() 
    {
        return 姓名;
    }
    public void set性别(String 性别) 
    {
        this.性别 = 性别;
    }

    public String get性别() 
    {
        return 性别;
    }
    public void set职位(String 职位) 
    {
        this.职位 = 职位;
    }

    public String get职位() 
    {
        return 职位;
    }
    public void set工资(Long 工资) 
    {
        this.工资 = 工资;
    }

    public Long get工资() 
    {
        return 工资;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("员工号", get员工号())
            .append("姓名", get姓名())
            .append("性别", get性别())
            .append("职位", get职位())
            .append("工资", get工资())
            .toString();
    }
}
