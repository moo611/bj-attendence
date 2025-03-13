package com.example.attendance.domain;

import java.util.Date;

import com.example.attendance.domain.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * 记录对象 dk_record
 *
 * @author ruoyi
 * @date 2025-03-13
 */
public class DkRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    
    private String username;

    /** $column.columnComment */
    
    private Date checkInTime;

    /** $column.columnComment */
    
    private Date checkOutTime;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String type;

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    private String createName;

    /** 删除标识 */
    private String delFlag;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getUsername()
    {
        return username;
    }
    public void setCheckInTime(Date checkInTime)
    {
        this.checkInTime = checkInTime;
    }

    public Date getCheckInTime()
    {
        return checkInTime;
    }
    public void setCheckOutTime(Date checkOutTime)
    {
        this.checkOutTime = checkOutTime;
    }

    public Date getCheckOutTime()
    {
        return checkOutTime;
    }
    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag()
    {
        return delFlag;
    }

}
