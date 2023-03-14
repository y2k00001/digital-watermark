package com.trace.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trace.core.entity.Buymesg;
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

    /**
     * description  
     * @author monkey
     * @datetime  2023/3/8 13:56
     * @param buymesg
     * @return {@link Integer}
     **/
    Integer registerSave(Buymesg buymesg);

    /**
     * description  
     * @author monkey
     * @datetime  2023/3/8 13:56
     * @param buymesg
     * @return {@link Integer}
     **/
    Integer updateSubmit(Buymesg buymesg);

    /**
     * description  
     * @author monkey
     * @datetime  2023/3/8 13:57
     * @param params
     * @return {@link PageUtils}
     **/
    PageUtils publicBuyList(Map<String, Object> params);

    /**
     * description  
     * @author monkey
     * @datetime  2023/3/8 13:57
     * @param params
     * @return {@link PageUtils}
     **/
    PageUtils queryPage(Map<String, Object> params);
    
    /**
     * description  
     * @author monkey
     * @datetime  2023/3/8 13:57
     * @param params
     * @return {@link PageUtils}
     **/
    PageUtils queryPage2(Map<String, Object> params);
    
    /**
     * description  
     * @author monkey
     * @datetime  2023/3/8 13:57
     * @param buymesg
     * @return {@link Integer}
     **/
    Integer sellDelist(Buymesg buymesg);

    /**
     * description  
     * @author monkey
     * @datetime  2023/3/8 13:59
     * @param id
     * @return {@link com.trace.core.entity.Buymesg}
     **/
    Buymesg getBuymesgById(Integer id);


    Buymesg getDetailById(Integer id);

    void approval(AuditVO auditVO);

    PageUtils queryPage4(Map<String, Object> params);
}
