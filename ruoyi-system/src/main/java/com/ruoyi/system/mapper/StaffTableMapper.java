package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.StaffTable;

/**
 * 员工管理Mapper接口
 * 
 * @author ruoyi
 * @date 2021-07-06
 */
public interface StaffTableMapper 
{
    /**
     * 查询员工管理
     * 
     * @param id 员工管理ID
     * @return 员工管理
     */
    public StaffTable selectStaffTableById(Long id);

    /**
     * 查询员工管理列表
     * 
     * @param staffTable 员工管理
     * @return 员工管理集合
     */
    public List<StaffTable> selectStaffTableList(StaffTable staffTable);

    /**
     * 新增员工管理
     * 
     * @param staffTable 员工管理
     * @return 结果
     */
    public int insertStaffTable(StaffTable staffTable);

    /**
     * 修改员工管理
     * 
     * @param staffTable 员工管理
     * @return 结果
     */
    public int updateStaffTable(StaffTable staffTable);

    /**
     * 删除员工管理
     * 
     * @param id 员工管理ID
     * @return 结果
     */
    public int deleteStaffTableById(Long id);

    /**
     * 批量删除员工管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteStaffTableByIds(String[] ids);
}
