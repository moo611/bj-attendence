package com.example.attendance.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.attendance.mapper.DkApplyMapper;
import com.example.attendance.domain.DkApply;
import com.example.attendance.service.IDkApplyService;

/**
 * 请假申请Service业务层处理
 *
 * @author ruoyi
 * @date 2025-04-20
 */
@Service
public class DkApplyServiceImpl implements IDkApplyService
{
    @Autowired
    private DkApplyMapper dkApplyMapper;

    /**
     * 查询请假申请
     *
     * @param id 请假申请主键
     * @return 请假申请
     */
    @Override
    public DkApply selectDkApplyById(Long id)
    {
        return dkApplyMapper.selectDkApplyById(id);
    }

    /**
     * 查询请假申请列表
     *
     * @param dkApply 请假申请
     * @return 请假申请
     */
    @Override
    public List<DkApply> selectDkApplyList(DkApply dkApply)
    {
        return dkApplyMapper.selectDkApplyList(dkApply);
    }

    /**
     * 新增请假申请
     *
     * @param dkApply 请假申请
     * @return 结果
     */
    @Override
    public int insertDkApply(DkApply dkApply)
    {
        dkApply.setCreateTime(new Date());
        return dkApplyMapper.insertDkApply(dkApply);
    }

    /**
     * 修改请假申请
     *
     * @param dkApply 请假申请
     * @return 结果
     */
    @Override
    public int updateDkApply(DkApply dkApply)
    {
        dkApply.setUpdateTime(new Date());
        return dkApplyMapper.updateDkApply(dkApply);
    }

    /**
     * 批量删除请假申请
     *
     * @param ids 需要删除的请假申请主键
     * @return 结果
     */
    @Override
    public int deleteDkApplyByIds(Long[] ids)
    {
        return dkApplyMapper.deleteDkApplyByIds(ids);
    }

    /**
     * 删除请假申请信息
     *
     * @param id 请假申请主键
     * @return 结果
     */
    @Override
    public int deleteDkApplyById(Long id)
    {
        return dkApplyMapper.deleteDkApplyById(id);
    }
}
