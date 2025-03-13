package com.example.attendance.controller;

import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.example.attendance.domain.DkNotice;
import com.example.attendance.domain.base.AjaxResult;
import com.example.attendance.domain.base.R;
import com.example.attendance.domain.req.DkNoticeListReq;
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

import com.example.attendance.domain.DkNotice;
import com.example.attendance.service.IDkNoticeService;


/**
 * 通知Controller
 *
 * @author ruoyi
 * @date 2025-03-13
 */
@RestController
@RequestMapping("/notice")
public class DkNoticeController extends BaseController
{
    @Autowired
    private IDkNoticeService dkNoticeService;

    /**
     * 查询通知列表
     */
    
    @GetMapping("/list")
    public R list(DkNoticeListReq dkNoticeListReq)
    {
        PageHelper.startPage(dkNoticeListReq.getPageNum(), dkNoticeListReq.getPageSize());
        DkNotice dkNotice = new DkNotice();
        BeanUtils.copyProperties(dkNoticeListReq, dkNotice);

        List<DkNotice> dkNotices = dkNoticeService.selectDkNoticeList(dkNotice);
        if (dkNotices.size() > 0) {
            PageInfo<DkNotice> pageInfo = new PageInfo<>(dkNotices);
            return R.ok(pageInfo);
        }
        return R.ok(new PageInfo<DkNotice>(Collections.emptyList()));
    }



    /**
     * 获取通知详细信息
     */
    
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(dkNoticeService.selectDkNoticeById(id));
    }

    /**
     * 新增通知
     */
    
    
    @PostMapping
    public AjaxResult add(@RequestBody DkNotice dkNotice)
    {
        return toAjax(dkNoticeService.insertDkNotice(dkNotice));
    }

    /**
     * 修改通知
     */
    
    
    @PutMapping
    public AjaxResult edit(@RequestBody DkNotice dkNotice)
    {
        return toAjax(dkNoticeService.updateDkNotice(dkNotice));
    }

    /**
     * 删除通知
     */
    
    
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dkNoticeService.deleteDkNoticeByIds(ids));
    }
}
