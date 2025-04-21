package com.example.attendance.domain;

import java.util.Date;

import com.example.attendance.domain.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * 请假申请对象 dk_apply
 *
 * @author ruoyi
 * @date 2025-04-20
 */
public class DkApply extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 请假人 */
   
    private String username;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    String nickname;

    /** 开始日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
   
    private Date startTime;

    /** 结束日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
   
    private Date endTime;

    /** 缘由 */
   
    private String reason;

    /** 0待审核1已审核2拒绝 */
   
    private String status;

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
    public void setStartTime(Date startTime)
    {
        this.startTime = startTime;
    }

    public Date getStartTime()
    {
        return startTime;
    }
    public void setEndTime(Date endTime)
    {
        this.endTime = endTime;
    }

    public Date getEndTime()
    {
        return endTime;
    }
    public void setReason(String reason)
    {
        this.reason = reason;
    }

    public String getReason()
    {
        return reason;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
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
