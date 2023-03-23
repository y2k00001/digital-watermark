package com.trace.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trace.core.entity.Sellmesg;
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

    /**
     * description
     * @author monkey
     * @datetime  2023/3/23 09:38
     * @param sellmesg
     * @return {@link Integer}
     **/
    Integer registerSave(Sellmesg sellmesg);

    /**
     * description
     * @author monkey
     * @datetime  2023/3/23 09:38
     * @param sellmesg
     * @return {@link Integer}
     **/
    Integer updateSubmit(Sellmesg sellmesg);

    /**
     * description
     * @author monkey
     * @datetime  2023/3/23 09:38
     * @param sellmesg
     * @return {@link Integer}
     **/
    Integer buyDelist(Sellmesg sellmesg);


    /**
     * 查询
     * @author monkey
     * @datetime  2023/3/23 09:38
     * @param params
     * @return {@link PageUtils}
     **/
    PageUtils queryPage(Map<String, Object> params);
    PageUtils queryPage2(Map<String, Object> params);
    PageUtils publicSellList(Map<String, Object> params);

    Sellmesg getBuymesgById(Integer id);


    Sellmesg getDetailById(Integer id);

    void approval(AuditVO auditVO);
}
