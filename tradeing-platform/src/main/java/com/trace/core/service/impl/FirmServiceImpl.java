package com.trace.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trace.core.entity.Firm;
import com.trace.core.entity.FirmAttach;
import com.trace.core.entity.Firmworker;
import com.trace.core.exception.Assert;
import com.trace.core.mapper.FirmAttachMapper;
import com.trace.core.mapper.FirmMapper;
import com.trace.core.mapper.FirmworkerMapper;
import com.trace.core.service.FirmService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trace.core.utils.R;
import com.trace.core.utils.ResponseEnum;
import com.trace.core.vo.FirmInfoSaveVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 四人组
 * @since 2022-09-15
 */
@Service
public class FirmServiceImpl extends ServiceImpl<FirmMapper, Firm> implements FirmService {
    @Resource
    private FirmAttachMapper firmAttachMapper;

    @Resource
    private FirmworkerMapper firmworkerMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveFirmInfoSaveVO(FirmInfoSaveVO firmInfoSaveVO) {
        //判断Firm认证是否存在
        String firmname = firmInfoSaveVO.getFirmname();
        Integer count = baseMapper.selectCount(new QueryWrapper<Firm>().eq("firmname", firmname));
        Assert.isTrue(count == 0, ResponseEnum.USERNAME_EXIST_ERROR);//同名企业已经注册提交认证
        //保存firm认证信息
        Firm firm=new Firm();
        BeanUtils.copyProperties(firmInfoSaveVO, firm);
        baseMapper.insert(firm);
        //保存企业认证证照
        List<FirmAttach> firmAttachList=firmInfoSaveVO.getFirmAttachList();
        firmAttachList.forEach(firmAttach -> {
            firmAttach.setFirmId(firm.getId());
            firmAttachMapper.insert(firmAttach);
        });
        //个人firmworker
        //使用自定义Mapper  只要拿着fwid对fmid修改
        Firmworker firmworker =new Firmworker();
        firmworker.setId(firmInfoSaveVO.getFirmworkerId());
        firmworker.setFirmId(firm.getId());
        firmworkerMapper.updateFirmIdById(firmworker);

        return true;
    }
}
