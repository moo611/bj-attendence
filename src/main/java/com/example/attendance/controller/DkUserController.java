package com.example.attendance.controller;

import com.example.attendance.config.auth.JwtUtil;
import com.example.attendance.config.auth.MyUserDetailsService;
import com.example.attendance.config.auth.UserUtil;
import com.example.attendance.domain.DkUser;
import com.example.attendance.domain.base.AjaxResult;
import com.example.attendance.domain.base.R;
import com.example.attendance.domain.req.FaceAddReq;
import com.example.attendance.domain.req.LoginReq;
import com.example.attendance.domain.req.DkUserListReq;
import com.example.attendance.service.IDkUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


/**
 * 用户Controller
 *
 * 
 * @date 2024-10-19
 */
@RestController
@RequestMapping("/user")
public class DkUserController extends BaseController {
    @Autowired
    private IDkUserService dkUserService;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService myUserDetailsService;
    @Autowired
    private JwtUtil jwtUtil;
    @PostMapping("/login")
    @ApiOperation("登录")
    public AjaxResult login(@RequestBody LoginReq loginReq) {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginReq.getUsername(), loginReq.getPassword())
            );
        }catch (Exception e){
            return AjaxResult.error("用户名或密码错误");
        }

        final UserDetails userDetails = myUserDetailsService.loadUserByUsername(loginReq.getUsername());
        return AjaxResult.success("ok",jwtUtil.generateToken(userDetails.getUsername()));

    }


    /**
     * 查询用户列表
     */

    @GetMapping("/list")
    public R list(DkUserListReq dkUserListReq) {
        PageHelper.startPage(dkUserListReq.getPageNum(), dkUserListReq.getPageSize());
        DkUser dkUser = new DkUser();
        BeanUtils.copyProperties(dkUserListReq, dkUser);

        List<DkUser> dkUsers = dkUserService.selectDkUserList(dkUser);
        if (dkUsers.size() > 0) {
            PageInfo<DkUser> pageInfo = new PageInfo<>(dkUsers);
            return R.ok(pageInfo);
        }
        return R.ok(new PageInfo<DkUser>(Collections.emptyList()));
    }


    /**
     * 获取用户详细信息
     */

    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(dkUserService.selectDkUserById(id));
    }

    /**
     * 获取用户详细信息
     */

    @GetMapping(value = "/info")
    @ApiOperation("获取用户详细信息")
    public AjaxResult getInfo()
    {
        String username = UserUtil.getCurrentUsername();
        return success(dkUserService.selectRtUserByUsername(username));
    }

    /**
     * 新增用户
     */


    @PostMapping
    public AjaxResult add(@RequestBody DkUser dkUser) {

        int res = dkUserService.insertDkUser(dkUser);
        if (res == -32001){
            return AjaxResult.error("用户名已存在");
        }
        return toAjax(res);


    }

    /**
     * 修改用户
     */


    @PutMapping
    public AjaxResult edit(@RequestBody DkUser dkUser) {
        int res = dkUserService.updateDkUser(dkUser);
        if (res == -32001){
            return AjaxResult.error("用户名已存在");
        }
        return toAjax(res);
    }

    /**
     * 删除用户
     */


    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(dkUserService.deleteDkUserByIds(ids));
    }


    @PostMapping(value = "/face")
    public AjaxResult face(@RequestBody FaceAddReq faceAddReq) {

        return toAjax(dkUserService.faceAdd(faceAddReq));


    }

    @PostMapping("/faceCheck")
    public AjaxResult faceCheck(@RequestBody FaceAddReq faceAddReq) {

        String userId = dkUserService.faceCheck(faceAddReq);

        if (userId != null) {
            return AjaxResult.success(Long.valueOf(userId));
        }
        return AjaxResult.error("未识别人脸");
    }
}
