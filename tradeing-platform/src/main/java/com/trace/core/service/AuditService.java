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
     * @datetime  2023/5/22 22:56
     * @param params
     * @return {@link com.trace.core.utils.PageUtils}
     **/
    PageUtils queryPage(Map<String, Object> params);


    /**
     * description
     * @author monkey
     * @datetime  2023/5/29 14:29
     * @param id
     * @return {@link FirmInfoVo}
     **/
    FirmInfoVo getDetailById(Integer id);

    /**
     * description
     * @author monkey
     * @datetime  2023/5/29 14:29
     * @param auditVO
     * @return
     **/
    void approval(AuditVO auditVO);

    /**
     * description
     * @author monkey
     * @datetime  2023/5/29 14:30
     * @param to
     * @param password
     * @return
     **/
    void sendMail(String to,String password);
}
