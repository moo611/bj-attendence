package com.example.attendance.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class DkUserVO extends DkUser {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date checkInTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date checkOutTime;
}
