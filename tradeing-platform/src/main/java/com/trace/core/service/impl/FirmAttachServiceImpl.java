package com.trace.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trace.core.entity.Audit;
import com.trace.core.entity.FirmAttach;
import com.trace.core.mapper.AuditMapper;
import com.trace.core.mapper.FirmAttachMapper;
import com.trace.core.service.AuditService;
import com.trace.core.service.FirmAttachService;
import com.trace.core.utils.PageUtils;
import com.trace.core.utils.Query;
import com.trace.core.vo.AuditRegisterVo;
import com.trace.core.vo.FirmAttachVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 四人组
 * @since 2022-09-15
 */
@Slf4j
@Service
public class FirmAttachServiceImpl extends ServiceImpl<FirmAttachMapper, FirmAttach> implements FirmAttachService {

    @Override
    public List<FirmAttachVO> selectFirmAttachVOList(Integer firmId) {
        QueryWrapper<FirmAttach> wrapper = new QueryWrapper<>();
        wrapper.eq("firm_id",firmId);
        List<FirmAttach> firmAttachList = baseMapper.selectList(wrapper);
        ArrayList<FirmAttachVO> firmAttachVOList = new ArrayList<>();
        firmAttachList.forEach(firmAttach -> {
            FirmAttachVO firmAttachVO = new FirmAttachVO();
            firmAttachVO.setImageUrl(firmAttach.getImageUrl());
            firmAttachVO.setImageType(firmAttach.getImageType());
            firmAttachVOList.add(firmAttachVO);
        });
        return firmAttachVOList;
    }


}
