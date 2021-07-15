package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 员工管理对象 staff_table
 * 
 * @author ruoyi
 * @date 2021-07-09
 */
public class StaffTable extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 员工号 */
    @Excel(name = "员工号")
    private Long staffId;

    /** 姓名 */
    @Excel(name = "姓名")
    private String staffName;

    /** 性别 */
    @Excel(name = "性别")
    private String staffSex;

    /** 职位 */
    @Excel(name = "职位")
    private String staffJob;

    /** 工资 */
    @Excel(name = "工资")
    private Long staffSlr;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setStaffId(Long staffId) 
    {
        this.staffId = staffId;
    }

    public Long getStaffId() 
    {
        return staffId;
    }
    public void setStaffName(String staffName) 
    {
        this.staffName = staffName;
    }

    public String getStaffName() 
    {
        return staffName;
    }
    public void setStaffSex(String staffSex) 
    {
        this.staffSex = staffSex;
    }

    public String getStaffSex() 
    {
        return staffSex;
    }
    public void setStaffJob(String staffJob) 
    {
        this.staffJob = staffJob;
    }

    public String getStaffJob() 
    {
        return staffJob;
    }
    public void setStaffSlr(Long staffSlr) 
    {
        this.staffSlr = staffSlr;
    }

    public Long getStaffSlr() 
    {
        return staffSlr;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("staffId", getStaffId())
            .append("staffName", getStaffName())
            .append("staffSex", getStaffSex())
            .append("staffJob", getStaffJob())
            .append("staffSlr", getStaffSlr())
            .toString();
    }
}
