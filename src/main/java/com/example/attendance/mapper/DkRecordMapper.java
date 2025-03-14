package com.example.attendance.mapper;

import java.util.List;
import com.example.attendance.domain.DkRecord;
import org.apache.ibatis.annotations.Mapper;

/**
 * 记录Mapper接口
 *
 * @author ruoyi
 * @date 2025-03-13
 */
@Mapper
public interface DkRecordMapper
{
    /**
     * 查询记录
     *
     * @param id 记录主键
     * @return 记录
     */
    public DkRecord selectDkRecordById(Long id);

    /**
     * 查询记录列表
     *
     * @param dkRecord 记录
     * @return 记录集合
     */
    public List<DkRecord> selectDkRecordList(DkRecord dkRecord);

    /**
     * 新增记录
     *
     * @param dkRecord 记录
     * @return 结果
     */
    public int insertDkRecord(DkRecord dkRecord);

    /**
     * 修改记录
     *
     * @param dkRecord 记录
     * @return 结果
     */
    public int updateDkRecord(DkRecord dkRecord);

    /**
     * 删除记录
     *
     * @param id 记录主键
     * @return 结果
     */
    public int deleteDkRecordById(Long id);

    /**
     * 批量删除记录
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDkRecordByIds(Long[] ids);

    DkRecord selectUserToday(String username);

}
