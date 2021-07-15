package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SelltableMapper;
import com.ruoyi.system.domain.Selltable;
import com.ruoyi.system.service.ISelltableService;
import com.ruoyi.common.core.text.Convert;

/**
 * 售货记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-07-14
 */
@Service
public class SelltableServiceImpl implements ISelltableService 
{
    @Autowired
    private SelltableMapper selltableMapper;

    /**
     * 查询售货记录
     * 
     * @param id 售货记录ID
     * @return 售货记录
     */
    @Override
    public Selltable selectSelltableById(Long id)
    {
        return selltableMapper.selectSelltableById(id);
    }

    /**
     * 查询售货记录列表
     * 
     * @param selltable 售货记录
     * @return 售货记录
     */
    @Override
    public List<Selltable> selectSelltableList(Selltable selltable)
    {
        return selltableMapper.selectSelltableList(selltable);
    }

    /**
     * 新增售货记录
     * 
     * @param selltable 售货记录
     * @return 结果
     */
    @Override
    public int insertSelltable(Selltable selltable)
    {
        return selltableMapper.insertSelltable(selltable);
    }

    /**
     * 修改售货记录
     * 
     * @param selltable 售货记录
     * @return 结果
     */
    @Override
    public int updateSelltable(Selltable selltable)
    {
        return selltableMapper.updateSelltable(selltable);
    }

    /**
     * 删除售货记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSelltableByIds(String ids)
    {
        return selltableMapper.deleteSelltableByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除售货记录信息
     * 
     * @param id 售货记录ID
     * @return 结果
     */
    @Override
    public int deleteSelltableById(Long id)
    {
        return selltableMapper.deleteSelltableById(id);
    }
}
