package com.example.attendance.service.impl;

import com.example.attendance.domain.DkUser;
import com.example.attendance.mapper.DkUserMapper;
import com.example.attendance.service.IDkUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 用户Service业务层处理
 *
 * 
 * @date 2024-10-19
 */
@Service
public class DkUserServiceImpl implements IDkUserService
{
    @Autowired
    private DkUserMapper sptUserMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;  // 注入 PasswordEncode
    /**
     * 查询用户
     *
     * @param id 用户主键
     * @return 用户
     */
    @Override
    public DkUser selectDkUserById(Long id)
    {
        return sptUserMapper.selectDkUserById(id);
    }

    /**
     * 查询用户列表
     *
     * @param sptUser 用户
     * @return 用户
     */
    @Override
    public List<DkUser> selectDkUserList(DkUser sptUser)
    {
        return sptUserMapper.selectDkUserList(sptUser);
    }

    /**
     * 新增用户
     *
     * @param sptUser 用户
     * @return 结果
     */
    @Override
    public int insertDkUser(DkUser sptUser)
    {
        DkUser old = sptUserMapper.selectDkUserByUsername(sptUser.getUsername());
        if (old != null){
            return -32001;
        }
        String encodedPassword = passwordEncoder.encode(sptUser.getPassword());
        sptUser.setPassword(encodedPassword);
        sptUser.setCreateTime(new Date());
        
        return sptUserMapper.insertDkUser(sptUser);
    }

    /**
     * 修改用户
     *
     * @param sptUser 用户
     * @return 结果
     */
    @Override
    public int updateDkUser(DkUser sptUser)
    {

        DkUser old = sptUserMapper.selectDkUserByUsername(sptUser.getUsername());
        if (!old.getId().equals(sptUser.getId())){
            return -32001;
        }

        sptUser.setUpdateTime(new Date());
        return sptUserMapper.updateDkUser(sptUser);
    }

    /**
     * 批量删除用户
     *
     * @param ids 需要删除的用户主键
     * @return 结果
     */
    @Override
    public int deleteDkUserByIds(Long[] ids)
    {
        return sptUserMapper.deleteDkUserByIds(ids);
    }

    /**
     * 删除用户信息
     *
     * @param id 用户主键
     * @return 结果
     */
    @Override
    public int deleteDkUserById(Long id)
    {
        return sptUserMapper.deleteDkUserById(id);
    }

    @Override
    public DkUser selectRtUserByUsername(String username) {
        return sptUserMapper.selectDkUserByUsername(username);
    }
}
