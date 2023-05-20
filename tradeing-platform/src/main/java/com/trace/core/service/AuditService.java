package com.trace.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trace.core.entity.Audit;
import com.trace.core.utils.PageUtils;
import com.trace.core.vo.AuditVO;
import com.trace.core.vo.FirmInfoVo;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 四人组
 * @since 2022-09-15
 */
public interface AuditService extends IService<Audit> {

    /**
     * description  
     * @author monkey
     * @datetime  2023/5/21 00:16
     * @param params
     * @return {@link PageUtils}
     **/
    PageUtils queryPage(Map<String, Object> params);


    FirmInfoVo getDetailById(Integer id);

    void approval(AuditVO auditVO);

    void sendMail(String to,String password);
}
