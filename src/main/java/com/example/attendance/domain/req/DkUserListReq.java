package com.example.attendance.domain.req;

import com.example.attendance.domain.base.BaseReq;
import lombok.Data;

@Data
public class DkUserListReq extends BaseReq {

    String role;
}
