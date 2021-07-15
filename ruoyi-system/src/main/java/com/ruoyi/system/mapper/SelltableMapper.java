package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Selltable;

/**
 * 售货记录Mapper接口
 * 
 * @author ruoyi
 * @date 2021-07-14
 */
public interface SelltableMapper 
{
    /**
     * 查询售货记录
     * 
     * @param id 售货记录ID
     * @return 售货记录
     */
    public Selltable selectSelltableById(Long id);

    /**
     * 查询售货记录列表
     * 
     * @param selltable 售货记录
     * @return 售货记录集合
     */
    public List<Selltable> selectSelltableList(Selltable selltable);

    /**
     * 新增售货记录
     * 
     * @param selltable 售货记录
     * @return 结果
     */
    public int insertSelltable(Selltable selltable);

    /**
     * 修改售货记录
     * 
     * @param selltable 售货记录
     * @return 结果
     */
    public int updateSelltable(Selltable selltable);

    /**
     * 删除售货记录
     * 
     * @param id 售货记录ID
     * @return 结果
     */
    public int deleteSelltableById(Long id);

    /**
     * 批量删除售货记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSelltableByIds(String[] ids);
}
