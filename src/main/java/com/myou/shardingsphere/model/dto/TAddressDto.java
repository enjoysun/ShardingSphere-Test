package com.myou.shardingsphere.model.dto;

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
public class TAddressDto implements Serializable {

    private static final long serialVersionUID = 997893469979545546L;
    
    private Long id;
    
    private String addressName;
    
    private String createTime;
    
    private String modifyTime;
    
}