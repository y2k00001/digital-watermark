package com.trace.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trace.core.entity.FirmAttach;
import com.trace.core.vo.FirmAttachVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 四人组
 * @since 2022-09-15
 */
public interface FirmAttachService extends IService<FirmAttach> {

    /**
     * description  
     * @author monkey
     * @datetime  2023/3/14 11:54
     * @param firmId
     * @return {@link List< FirmAttachVO>}
     **/
    List<FirmAttachVO> selectFirmAttachVOList(Integer firmId);
}
