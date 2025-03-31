package com.example.attendance.domain.req;

import lombok.Data;

@Data
public class FaceAddRequest {
    private String image;
    private String image_type;
    private String user_id;
    private String group_id;
    // 可以添加其他可选参数
    private String group_id_list;
}