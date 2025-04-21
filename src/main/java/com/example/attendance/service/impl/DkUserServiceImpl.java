package com.example.attendance.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.attendance.domain.CountVO;
import com.example.attendance.domain.DkRecord;
import com.example.attendance.domain.DkUser;
import com.example.attendance.domain.DkUserVO;
import com.example.attendance.domain.req.DkUserRecordReq;
import com.example.attendance.domain.req.FaceAddReq;
import com.example.attendance.domain.req.FaceAddRequest;
import com.example.attendance.mapper.DkRecordMapper;
import com.example.attendance.mapper.DkUserMapper;
import com.example.attendance.service.IDkUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
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
    RestTemplate restTemplate;
    @Autowired
    private DkUserMapper dkUserMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;  // 注入 PasswordEncode
    @Autowired
    private DkRecordMapper dkRecordMapper;

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

    @Override
    public int faceAdd(FaceAddReq faceAddReq) {

        String userId = faceCheck(faceAddReq);
        if (userId != null){
            return -32001;
        }

        String token = getAccessToken();

        FaceAddRequest faceAddRequest = new FaceAddRequest();
        faceAddRequest.setImage(faceAddReq.getImage().split(",")[1]);
        faceAddRequest.setImage_type("BASE64");
        faceAddRequest.setGroup_id("002");
        faceAddRequest.setUser_id(String.valueOf(faceAddReq.getUserId()));
        String faceToken = addFace(faceAddRequest, token);
        if (faceToken != null){

            DkUser dkUser = dkUserMapper.selectDkUserById(faceAddReq.getUserId());
            dkUser.setFaceToken(faceToken);
            return dkUserMapper.updateDkUser(dkUser);
        }

        return 0;
    }

    @Override
    public String faceCheck(FaceAddReq faceAddReq) {
        String token = getAccessToken();

        FaceAddRequest faceAddRequest = new FaceAddRequest();
        faceAddRequest.setImage(faceAddReq.getImage().split(",")[1]);
        faceAddRequest.setImage_type("BASE64");
        faceAddRequest.setGroup_id_list("002");

        return check(faceAddRequest, token);
    }

    @Override
    public List<DkUserVO> selectDkUserRecord(DkUserRecordReq dkUserRecordReq) {

        List<DkUserVO>userVOS = dkUserMapper.selectDkUserList2();

        for (DkUserVO dkUserVO : userVOS){

            DkRecord dkRecord = dkRecordMapper.selectUserToday(dkUserVO.getUsername());
            if (dkRecord != null){
                dkUserVO.setCheckInTime(dkRecord.getCheckInTime());
                dkUserVO.setCheckOutTime(dkRecord.getCheckOutTime());
            }

        }

        return userVOS;
    }

    @Override
    public CountVO getStatics() {

        CountVO countVO = new CountVO();

        Integer total = dkUserMapper.selectCount();
        Integer registered = dkRecordMapper.selectCountToday();
        Integer unregistered = total-registered;

        countVO.setTotal(total);
        countVO.setRegistered(registered);
        countVO.setUnregistered(unregistered);

        return countVO;
    }

    String clientId = "WmARO855SfOoTEbSB7BEW2aH";
    String clientSecret = "oKf6qZ3392hgmm1FJocwsWhIYBKUdfIg";

    private String TOKEN_URL = "https://aip.baidubce.com/oauth/2.0/token?grant_type=client_credentials&client_id="+clientId+"&client_secret="+clientSecret;

    public String getAccessToken() {

        // 设置请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        // 创建请求实体
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        try {
            // 发送POST请求
            ResponseEntity<String> response = restTemplate.exchange(
                    TOKEN_URL,
                    HttpMethod.POST,
                    requestEntity,
                    String.class);

            // 使用FastJSON解析响应体
            JSONObject jsonObject = JSONObject.parseObject(response.getBody());

            // 获取access_token字段
            return jsonObject.getString("access_token");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("获取百度Access Token失败", e);
        }
    }

    private static final String FACE_ADD_URL = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/user/add?access_token={accessToken}";

    public String addFace(FaceAddRequest request,String accessToken) {
        String faceToken = null;
        // 1. 准备请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // 2. 创建请求实体
        HttpEntity<FaceAddRequest> requestEntity = new HttpEntity<>(request, headers);

        try {
            // 3. 发送POST请求
            ResponseEntity<String> response = restTemplate.exchange(
                    FACE_ADD_URL,
                    HttpMethod.POST,
                    requestEntity,
                    String.class,
                    accessToken  // URI变量替换{accessToken}
            );

            // 使用FastJSON解析响应体
            JSONObject jsonObject = JSONObject.parseObject(response.getBody());

            int errCode = jsonObject.getInteger("error_code");
            if (errCode == 0 && jsonObject.getJSONObject("result")!=null){
                faceToken = jsonObject.getJSONObject("result").getString("face_token");
            }
            return faceToken;
        } catch (Exception e) {
            System.out.println(e.getMessage());

            return faceToken;
        }
    }
    
    private static final String FACE_SEARCH_URL = "https://aip.baidubce.com/rest/2.0/face/v3/search?access_token={accessToken}";

    private String check(FaceAddRequest request, String accessToken){
        String userId = null;
        // 1. 准备请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // 2. 创建请求实体
        HttpEntity<FaceAddRequest> requestEntity = new HttpEntity<>(request, headers);

        try {
            // 3. 发送POST请求
            ResponseEntity<String> response = restTemplate.exchange(
                    FACE_SEARCH_URL,
                    HttpMethod.POST,
                    requestEntity,
                    String.class,
                    accessToken  // URI变量替换{accessToken}
            );

            // 使用FastJSON解析响应体
            JSONObject jsonObject = JSONObject.parseObject(response.getBody());

            int errCode = jsonObject.getInteger("error_code");
            if (errCode == 0 ){
                JSONArray userList = jsonObject.getJSONObject("result").getJSONArray("user_list");
                if (userList.size()>0){
                    JSONObject user = userList.getJSONObject(0);
                    int score = user.getInteger("score");
                    if (score>=80){
                        return user.getString("user_id");
                    }
                }

            }
            return userId;
        } catch (Exception e) {
            System.out.println(e.getMessage());

            return userId;
        }

    }
    
}
