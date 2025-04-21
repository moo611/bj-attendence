package com.example.attendance.domain.req;

import com.example.attendance.domain.base.BaseReq;
import lombok.Data;

@Data
public class DkUserRecordReq extends BaseReq {
    String checkOutTime;
}
