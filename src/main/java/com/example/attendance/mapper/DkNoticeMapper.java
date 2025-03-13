package com.example.attendance.mapper;

import java.util.List;
import com.example.attendance.domain.DkNotice;
import org.apache.ibatis.annotations.Mapper;

/**
 * 通知Mapper接口
 *
 * @author ruoyi
 * @date 2025-03-13
 */
@Mapper
public interface DkNoticeMapper
{
    /**
     * 查询通知
     *
     * @param id 通知主键
     * @return 通知
     */
    public DkNotice selectDkNoticeById(Long id);

    /**
     * 查询通知列表
     *
     * @param dkNotice 通知
     * @return 通知集合
     */
    public List<DkNotice> selectDkNoticeList(DkNotice dkNotice);

    /**
     * 新增通知
     *
     * @param dkNotice 通知
     * @return 结果
     */
    public int insertDkNotice(DkNotice dkNotice);

    /**
     * 修改通知
     *
     * @param dkNotice 通知
     * @return 结果
     */
    public int updateDkNotice(DkNotice dkNotice);

    /**
     * 删除通知
     *
     * @param id 通知主键
     * @return 结果
     */
    public int deleteDkNoticeById(Long id);

    /**
     * 批量删除通知
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDkNoticeByIds(Long[] ids);
}
