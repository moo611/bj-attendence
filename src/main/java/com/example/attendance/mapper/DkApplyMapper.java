package com.example.attendance.mapper;

import java.util.List;
import com.example.attendance.domain.DkApply;
import org.apache.ibatis.annotations.Mapper;

import javax.annotation.ManagedBean;

/**
 * 请假申请Mapper接口
 *
 * @author ruoyi
 * @date 2025-04-20
 */
@Mapper
public interface DkApplyMapper
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
     * 删除请假申请
     *
     * @param id 请假申请主键
     * @return 结果
     */
    public int deleteDkApplyById(Long id);

    /**
     * 批量删除请假申请
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDkApplyByIds(Long[] ids);
}
