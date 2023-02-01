package com.trace.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trace.core.entity.Firm;
import com.trace.core.vo.FirmInfoSaveVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 四人组
 * @since 2022-09-15
 */
public interface FirmService extends IService<Firm> {

    boolean saveFirmInfoSaveVO(FirmInfoSaveVO firmInfoSaveVO);
}
