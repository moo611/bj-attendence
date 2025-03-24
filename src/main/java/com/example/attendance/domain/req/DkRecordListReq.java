package com.example.attendance.domain.req;

import com.example.attendance.domain.base.BaseReq;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class DkRecordListReq extends BaseReq {

    String createBy;

    @JsonFormat(pattern = "yyyy-MM-dd")
    Date checkOutTime;
}
