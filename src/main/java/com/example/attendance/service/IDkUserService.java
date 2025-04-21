package com.example.attendance.service;

import com.example.attendance.domain.CountVO;
import com.example.attendance.domain.DkUser;
import com.example.attendance.domain.DkUserVO;
import com.example.attendance.domain.req.DkUserRecordReq;
import com.example.attendance.domain.req.FaceAddReq;

import java.util.List;

/**
 * 用户Service接口
 *
 * 
 * @date 2024-10-19
 */
public interface IDkUserService
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
     * 批量删除用户
     *
     * @param ids 需要删除的用户主键集合
     * @return 结果
     */
    public int deleteDkUserByIds(Long[] ids);

    /**
     * 删除用户信息
     *
     * @param id 用户主键
     * @return 结果
     */
    public int deleteDkUserById(Long id);

    DkUser selectRtUserByUsername(String username);

    int faceAdd(FaceAddReq faceAddReq);

    String faceCheck(FaceAddReq faceAddReq);

    List<DkUserVO> selectDkUserRecord(DkUserRecordReq dkUserRecordReq);

    CountVO getStatics();
}
