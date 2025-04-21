package com.example.attendance.service;

import java.util.List;
import com.example.attendance.domain.DkApply;

/**
 * 请假申请Service接口
 *
 * @author ruoyi
 * @date 2025-04-20
 */
public interface IDkApplyService
{
    /**
     * 查询请假申请
     *
     * @param id 请假申请主键
     * @return 请假申请
     */
    public DkApply selectDkApplyById(Long id);

    /**
     * 查询请假申请列表
     *
     * @param dkApply 请假申请
     * @return 请假申请集合
     */
    public List<DkApply> selectDkApplyList(DkApply dkApply);

    /**
     * 新增请假申请
     *
     * @param dkApply 请假申请
     * @return 结果
     */
    public int insertDkApply(DkApply dkApply);

    /**
     * 修改请假申请
     *
     * @param dkApply 请假申请
     * @return 结果
     */
    public int updateDkApply(DkApply dkApply);

    /**
     * 批量删除请假申请
     *
     * @param ids 需要删除的请假申请主键集合
     * @return 结果
     */
    public int deleteDkApplyByIds(Long[] ids);

    /**
     * 删除请假申请信息
     *
     * @param id 请假申请主键
     * @return 结果
     */
    public int deleteDkApplyById(Long id);
}
