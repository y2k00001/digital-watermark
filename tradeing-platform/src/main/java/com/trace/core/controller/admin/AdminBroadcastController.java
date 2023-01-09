package com.trace.core.controller.admin;


import com.trace.core.entity.Broadcast;
import com.trace.core.entity.Broadcastread;
import com.trace.core.exception.Assert;
import com.trace.core.service.BroadcastService;
import com.trace.core.service.BroadcastreadService;
import com.trace.core.utils.JwtUtils;
import com.trace.core.utils.PageUtils;
import com.trace.core.utils.R;
import com.trace.core.utils.ResponseEnum;
import com.trace.core.vo.AuditVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 四人组
 * @since 2022-09-15
 */
@RestController
@RequestMapping("/admin/broadcast")
@Api(tags = "资讯表")
public class AdminBroadcastController {

    @Resource
    private BroadcastService broadcastService;

    @ApiOperation("资讯列表")
    @PostMapping("/list")
    public R listAll(@ApiParam("分页参数") @RequestBody Map<String, Object> params, HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader("token");
        Integer userId = JwtUtils.getUserId(token);
        PageUtils page = broadcastService.queryPageById(params, userId);
        return R.ok().put("page", page);
    }

    //@ApiOperation("资讯列表")
    //@PostMapping("/list")
    //public R listAll(@ApiParam("分页参数") @RequestBody Map<String, Object> params) {
    //    PageUtils page = broadcastService.queryPage(params);
    //    return R.ok().put("page", page);
    //}

    @ApiOperation("管理员资讯列表")
    @PostMapping("/AdminList")
    public R listAllByAdmin(@ApiParam("分页参数") @RequestBody Map<String, Object> params) {
        PageUtils page = broadcastService.queryPageByAdmin(params);
        return R.ok().put("page", page);
    }

    @ApiOperation("新增资讯")
    @PostMapping("/save")
    public R save(@RequestBody Broadcast broadcast, HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader("token");
        Integer userId = JwtUtils.getUserId(token);
        Assert.notEmpty(broadcast.getTitle(), ResponseEnum.TITLE_NOT_NULL_ERROR);
        Assert.notEmpty(broadcast.getInfo(), ResponseEnum.INFO_NOT_NULL_ERROR);
        Assert.notEmpty(userId,ResponseEnum.USER_NOT_NULL_ERROR);
        broadcast.setUserId(userId);
        broadcastService.save(broadcast);
        return R.ok("操作成功");
    }

    @ApiOperation("根据id获取资讯")
    @GetMapping("/info/{id}")
    public R getById(@ApiParam("资讯表id") @PathVariable("id") Integer id) {
        Broadcast broadcast = broadcastService.getById(id);
        return R.ok().put("page", broadcast);
    }

    @ApiOperation("更新资讯")
    @PutMapping("/update")
    public R update(@RequestBody Broadcast broadcast) {
        Assert.notEmpty(broadcast.getTitle(), ResponseEnum.TITLE_NOT_NULL_ERROR);
        Assert.notEmpty(broadcast.getInfo(), ResponseEnum.INFO_NOT_NULL_ERROR);
        //Assert.notEmpty(broadcast.getUserId(),ResponseEnum.USER_NOT_NULL_ERROR);
        broadcastService.updateById(broadcast);
        return R.ok("操作成功");
    }

    @ApiOperation("资讯审核")
    @PostMapping("/approval")
    public R approval(@ApiParam("审核返回体") @RequestBody Broadcast broadcast) {
        broadcastService.updateById(broadcast);
        return R.ok();
    }


}

