package com.example.attendance.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.attendance.mapper.DkNoticeMapper;
import com.example.attendance.domain.DkNotice;
import com.example.attendance.service.IDkNoticeService;

/**
 * 通知Service业务层处理
 *
 * @author ruoyi
 * @date 2025-03-13
 */
@Service
public class DkNoticeServiceImpl implements IDkNoticeService
{
    @Autowired
    private DkNoticeMapper dkNoticeMapper;

    /**
     * 查询通知
     *
     * @param id 通知主键
     * @return 通知
     */
    @Override
    public DkNotice selectDkNoticeById(Long id)
    {
        return dkNoticeMapper.selectDkNoticeById(id);
    }

    /**
     * 查询通知列表
     *
     * @param dkNotice 通知
     * @return 通知
     */
    @Override
    public List<DkNotice> selectDkNoticeList(DkNotice dkNotice)
    {
        return dkNoticeMapper.selectDkNoticeList(dkNotice);
    }

    /**
     * 新增通知
     *
     * @param dkNotice 通知
     * @return 结果
     */
    @Override
    public int insertDkNotice(DkNotice dkNotice)
    {
        dkNotice.setCreateTime(new Date());
        return dkNoticeMapper.insertDkNotice(dkNotice);
    }

    /**
     * 修改通知
     *
     * @param dkNotice 通知
     * @return 结果
     */
    @Override
    public int updateDkNotice(DkNotice dkNotice)
    {
        dkNotice.setUpdateTime(new Date());
        return dkNoticeMapper.updateDkNotice(dkNotice);
    }

    /**
     * 批量删除通知
     *
     * @param ids 需要删除的通知主键
     * @return 结果
     */
    @Override
    public int deleteDkNoticeByIds(Long[] ids)
    {
        return dkNoticeMapper.deleteDkNoticeByIds(ids);
    }

    /**
     * 删除通知信息
     *
     * @param id 通知主键
     * @return 结果
     */
    @Override
    public int deleteDkNoticeById(Long id)
    {
        return dkNoticeMapper.deleteDkNoticeById(id);
    }
}
