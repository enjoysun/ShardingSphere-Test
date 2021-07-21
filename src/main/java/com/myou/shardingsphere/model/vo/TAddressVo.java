package com.myou.shardingsphere.model.vo;

import java.util.Date;
import lombok.Data;
import java.io.Serializable;

/**
 * 收货地址(TAddress)实体类
 *
 * @author makejava
 * @since 2021-07-21 15:34:01
 */
@Data
public class TAddressVo implements Serializable {

    private static final long serialVersionUID = 180879696292458597L;
    
    private Long id;
    
    private String addressName;
    
    private String createTime;
    
    private String modifyTime;
    
}