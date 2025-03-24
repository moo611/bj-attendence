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
    private DkUserMapper dkUserMapper;
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
        return dkUserMapper.selectDkUserById(id);
    }

    /**
     * 查询用户列表
     *
     * @param dkUser 用户
     * @return 用户
     */
    @Override
    public List<DkUser> selectDkUserList(DkUser dkUser)
    {
        return dkUserMapper.selectDkUserList(dkUser);
    }

    /**
     * 新增用户
     *
     * @param dkUser 用户
     * @return 结果
     */
    @Override
    public int insertDkUser(DkUser dkUser)
    {
        DkUser old = dkUserMapper.selectDkUserByUsername(dkUser.getUsername());
        if (old != null){
            return -32001;
        }
        String encodedPassword = passwordEncoder.encode(dkUser.getPassword());
        dkUser.setPassword(encodedPassword);
        dkUser.setCreateTime(new Date());
        
        return dkUserMapper.insertDkUser(dkUser);
    }

    /**
     * 修改用户
     *
     * @param dkUser 用户
     * @return 结果
     */
    @Override
    public int updateDkUser(DkUser dkUser)
    {

        DkUser old = dkUserMapper.selectDkUserByUsername(dkUser.getUsername());
        if (!old.getId().equals(dkUser.getId())){
            return -32001;
        }

        dkUser.setUpdateTime(new Date());
        return dkUserMapper.updateDkUser(dkUser);
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
        return dkUserMapper.deleteDkUserByIds(ids);
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
        return dkUserMapper.deleteDkUserById(id);
    }

    @Override
    public DkUser selectRtUserByUsername(String username) {
        return dkUserMapper.selectDkUserByUsername(username);
    }
}
