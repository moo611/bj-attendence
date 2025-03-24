package com.example.attendance.mapper;

import com.example.attendance.domain.DkUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户Mapper接口
 *
 * 
 * @date 2024-10-19
 */
@Mapper
public interface DkUserMapper
{
    /**
     * 查询用户
     *
     * @param id 用户主键
     * @return 用户
     */
    public DkUser selectDkUserById(Long id);

    /**
     * 查询用户列表
     *
     * @param dkUser 用户
     * @return 用户集合
     */
    public List<DkUser> selectDkUserList(DkUser dkUser);

    /**
     * 新增用户
     *
     * @param dkUser 用户
     * @return 结果
     */
    public int insertDkUser(DkUser dkUser);

    /**
     * 修改用户
     *
     * @param dkUser 用户
     * @return 结果
     */
    public int updateDkUser(DkUser dkUser);

    /**
     * 删除用户
     *
     * @param id 用户主键
     * @return 结果
     */
    public int deleteDkUserById(Long id);

    /**
     * 批量删除用户
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDkUserByIds(Long[] ids);

    DkUser selectDkUserByUsername(String username);

}
