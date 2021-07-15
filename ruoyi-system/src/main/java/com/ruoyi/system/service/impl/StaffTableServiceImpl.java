package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.StaffTableMapper;
import com.ruoyi.system.domain.StaffTable;
import com.ruoyi.system.service.IStaffTableService;
import com.ruoyi.common.core.text.Convert;

/**
 * 员工管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-07-09
 */
@Service
public class StaffTableServiceImpl implements IStaffTableService 
{
    @Autowired
    private StaffTableMapper staffTableMapper;

    /**
     * 查询员工管理
     * 
     * @param id 员工管理ID
     * @return 员工管理
     */
    @Override
    public StaffTable selectStaffTableById(Long id)
    {
        return staffTableMapper.selectStaffTableById(id);
    }

    /**
     * 查询员工管理列表
     * 
     * @param staffTable 员工管理
     * @return 员工管理
     */
    @Override
    public List<StaffTable> selectStaffTableList(StaffTable staffTable)
    {
        return staffTableMapper.selectStaffTableList(staffTable);
    }

    /**
     * 新增员工管理
     * 
     * @param staffTable 员工管理
     * @return 结果
     */
    @Override
    public int insertStaffTable(StaffTable staffTable)
    {
        return staffTableMapper.insertStaffTable(staffTable);
    }

    /**
     * 修改员工管理
     * 
     * @param staffTable 员工管理
     * @return 结果
     */
    @Override
    public int updateStaffTable(StaffTable staffTable)
    {
        return staffTableMapper.updateStaffTable(staffTable);
    }

    /**
     * 删除员工管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteStaffTableByIds(String ids)
    {
        return staffTableMapper.deleteStaffTableByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除员工管理信息
     * 
     * @param id 员工管理ID
     * @return 结果
     */
    @Override
    public int deleteStaffTableById(Long id)
    {
        return staffTableMapper.deleteStaffTableById(id);
    }
}
