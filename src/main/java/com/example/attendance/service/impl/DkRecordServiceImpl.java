package com.example.attendance.service.impl;

import java.util.Date;
import java.util.List;

import com.example.attendance.config.auth.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.attendance.mapper.DkRecordMapper;
import com.example.attendance.domain.DkRecord;
import com.example.attendance.service.IDkRecordService;

/**
 * 记录Service业务层处理
 *
 * @author ruoyi
 * @date 2025-03-13
 */
@Service
public class DkRecordServiceImpl implements IDkRecordService
{
    @Autowired
    private DkRecordMapper dkRecordMapper;

    /**
     * 查询记录
     *
     * @param id 记录主键
     * @return 记录
     */
    @Override
    public DkRecord selectDkRecordById(Long id)
    {
        return dkRecordMapper.selectDkRecordById(id);
    }

    /**
     * 查询记录列表
     *
     * @param dkRecord 记录
     * @return 记录
     */
    @Override
    public List<DkRecord> selectDkRecordList(DkRecord dkRecord)
    {
        return dkRecordMapper.selectDkRecordList(dkRecord);
    }



    /**
     * 新增记录
     *
     * @param dkRecord 记录
     * @return 结果
     */
    @Override
    public int insertDkRecord(DkRecord dkRecord)
    {
        dkRecord.setCreateTime(new Date());
        dkRecord.setCreateBy(UserUtil.getCurrentUsername());
        return dkRecordMapper.insertDkRecord(dkRecord);
    }

    /**
     * 修改记录
     *
     * @param dkRecord 记录
     * @return 结果
     */
    @Override
    public int updateDkRecord(DkRecord dkRecord)
    {
        dkRecord.setUpdateTime(new Date());
        dkRecord.setUpdateBy(UserUtil.getCurrentUsername());
        return dkRecordMapper.updateDkRecord(dkRecord);
    }

    /**
     * 批量删除记录
     *
     * @param ids 需要删除的记录主键
     * @return 结果
     */
    @Override
    public int deleteDkRecordByIds(Long[] ids)
    {
        return dkRecordMapper.deleteDkRecordByIds(ids);
    }

    /**
     * 删除记录信息
     *
     * @param id 记录主键
     * @return 结果
     */
    @Override
    public int deleteDkRecordById(Long id)
    {
        return dkRecordMapper.deleteDkRecordById(id);
    }

    @Override
    public int registry() {

        DkRecord old = dkRecordMapper.selectUserToday(UserUtil.getCurrentUsername());
        if (old == null) {
            DkRecord dkRecord = new DkRecord();
            dkRecord.setCheckInTime(new Date());
            return insertDkRecord(dkRecord);
        }else{
            if (old.getCheckOutTime() == null) {
                //下班打卡
                old.setCheckOutTime(new Date());
                return updateDkRecord(old);
            }else{
                return -32001;
            }
        }
    }
}
