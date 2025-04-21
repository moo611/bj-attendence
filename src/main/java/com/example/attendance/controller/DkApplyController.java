package com.example.attendance.controller;

import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.example.attendance.domain.DkApply;
import com.example.attendance.domain.base.AjaxResult;
import com.example.attendance.domain.base.R;
import com.example.attendance.domain.req.DkApplyListReq;
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

import com.example.attendance.domain.DkApply;
import com.example.attendance.service.IDkApplyService;


/**
 * 请假申请Controller
 *
 * @author ruoyi
 * @date 2025-04-20
 */
@RestController
@RequestMapping("/apply")
public class DkApplyController extends BaseController
{
    @Autowired
    private IDkApplyService dkApplyService;

    /**
     * 查询请假申请列表
     */
    
    @GetMapping("/list")
    public R list(DkApplyListReq dkApplyListReq)
    {
        PageHelper.startPage(dkApplyListReq.getPageNum(), dkApplyListReq.getPageSize());
        DkApply dkApply = new DkApply();
        BeanUtils.copyProperties(dkApplyListReq, dkApply);

        List<DkApply> dkApplys = dkApplyService.selectDkApplyList(dkApply);
        if (dkApplys.size() > 0) {
            PageInfo<DkApply> pageInfo = new PageInfo<>(dkApplys);
            return R.ok(pageInfo);
        }
        return R.ok(new PageInfo<DkApply>(Collections.emptyList()));
    }

    

    /**
     * 获取请假申请详细信息
     */
    
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(dkApplyService.selectDkApplyById(id));
    }

    /**
     * 新增请假申请
     */
    
    
    @PostMapping
    public AjaxResult add(@RequestBody DkApply dkApply)
    {
        return toAjax(dkApplyService.insertDkApply(dkApply));
    }

    /**
     * 修改请假申请
     */
    
    
    @PutMapping
    public AjaxResult edit(@RequestBody DkApply dkApply)
    {
        return toAjax(dkApplyService.updateDkApply(dkApply));
    }

    /**
     * 删除请假申请
     */
    
    
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dkApplyService.deleteDkApplyByIds(ids));
    }
}
