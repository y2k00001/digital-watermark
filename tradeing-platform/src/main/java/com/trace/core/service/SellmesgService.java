package com.trace.core.service;

import com.trace.core.entity.Sellmesg;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trace.core.utils.PageUtils;
import com.trace.core.vo.AuditVO;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 四人组
 * @since 2022-09-15
 */
public interface SellmesgService extends IService<Sellmesg> {

    Integer registerSave(Sellmesg sellmesg);
    Integer updateSubmit(Sellmesg sellmesg);

    Integer buyDelist(Sellmesg sellmesg);

    PageUtils queryPage(Map<String, Object> params);
    PageUtils queryPage2(Map<String, Object> params);
    PageUtils publicSellList(Map<String, Object> params);

    Sellmesg getBuymesgById(Integer id);


    Sellmesg getDetailById(Integer id);

    void approval(AuditVO auditVO);
}
