package com.trace.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trace.core.entity.Audit;
import com.trace.core.entity.FirmAttach;
import com.trace.core.utils.PageUtils;
import com.trace.core.vo.FirmAttachVO;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 四人组
 * @since 2022-09-15
 */
public interface FirmAttachService extends IService<FirmAttach> {

    List<FirmAttachVO> selectFirmAttachVOList(Integer firmId);
}
