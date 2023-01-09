package com.trace.core.service;

import com.trace.core.entity.Buymesg;
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
public interface BuymesgService extends IService<Buymesg> {

    Integer registerSave(Buymesg buymesg);

    Integer updateSubmit(Buymesg buymesg);

    PageUtils publicBuyList(Map<String, Object> params);

    PageUtils queryPage(Map<String, Object> params);
    PageUtils queryPage2(Map<String, Object> params);
    Integer sellDelist(Buymesg buymesg);

    Buymesg getBuymesgById(Integer id);


    Buymesg getDetailById(Integer id);

    void approval(AuditVO auditVO);

    PageUtils queryPage4(Map<String, Object> params);
}