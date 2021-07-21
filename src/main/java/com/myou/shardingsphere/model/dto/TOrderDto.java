package com.myou.shardingsphere.model.dto;

import lombok.Data;
import java.io.Serializable;

/**
 * 订单(TOrder)实体类
 *
 * @author makejava
 * @since 2021-07-21 15:33:24
 */
@Data
public class TOrderDto implements Serializable {

    private static final long serialVersionUID = 345600390667573923L;
    
    private Long id;
    
    private Long userId;
    
    private Long addressId;
    
    private Integer status;
    
    private String createTime;
    
    private String modifyTime;
    
}