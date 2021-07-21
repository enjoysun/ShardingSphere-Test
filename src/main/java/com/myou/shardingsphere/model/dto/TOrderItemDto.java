package com.myou.shardingsphere.model.dto;

import lombok.Data;
import java.io.Serializable;

/**
 * 订单详情(TOrderItem)实体类
 *
 * @author makejava
 * @since 2021-07-21 15:31:59
 */
@Data
public class TOrderItemDto implements Serializable {

    private static final long serialVersionUID = 364325036903485721L;
    
    private Long id;
    
    private Long userId;
    
    private Long orderId;
    
    private Integer status;
    
    private String itemName;
    
    private String createTime;
    
    private String modifyTime;
    
}