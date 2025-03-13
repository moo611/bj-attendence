package com.example.attendance.controller;

import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.example.attendance.domain.base.AjaxResult;
import com.example.attendance.domain.base.R;
import com.example.attendance.domain.req.DkRecordListReq;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.attendance.domain.DkRecord;
import com.example.attendance.service.IDkRecordService;

/**
 * 记录Controller
 *
 * @author ruoyi
 * @date 2025-03-13
 */
@RestController
@RequestMapping("/record")
public class DkRecordController extends BaseController
{
    @Autowired
    private IDkRecordService dkRecordService;

    /**
     * 查询记录列表
     */
    
    @GetMapping("/list")
    public R list(DkRecordListReq dkRecordListReq)
    {
        PageHelper.startPage(dkRecordListReq.getPageNum(), dkRecordListReq.getPageSize());
        DkRecord dkRecord = new DkRecord();
        BeanUtils.copyProperties(dkRecordListReq, dkRecord);

        List<DkRecord> dkRecords = dkRecordService.selectDkRecordList(dkRecord);
        if (dkRecords.size() > 0) {
            PageInfo<DkRecord> pageInfo = new PageInfo<>(dkRecords);
            return R.ok(pageInfo);
        }
        return R.ok(new PageInfo<DkRecord>(Collections.emptyList()));
    }

 
    /**
     * 获取记录详细信息
     */
    
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(dkRecordService.selectDkRecordById(id));
    }

    /**
     * 新增记录
     */
    
    
    @PostMapping
    public AjaxResult add(@RequestBody DkRecord dkRecord)
    {
        return toAjax(dkRecordService.insertDkRecord(dkRecord));
    }

    /**
     * 修改记录
     */
    
    
    @PutMapping
    public AjaxResult edit(@RequestBody DkRecord dkRecord)
    {
        return toAjax(dkRecordService.updateDkRecord(dkRecord));
    }

    /**
     * 删除记录
     */
    
    
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dkRecordService.deleteDkRecordByIds(ids));
    }
}
