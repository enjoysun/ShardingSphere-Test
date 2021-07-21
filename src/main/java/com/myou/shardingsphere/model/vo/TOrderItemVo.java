package com.myou.shardingsphere.model.vo;

import java.util.Date;
import lombok.Data;
import java.io.Serializable;

/**
 * 订单详情(TOrderItem)实体类
 *
 * @author makejava
 * @since 2021-07-21 15:32:00
 */
@Data
public class TOrderItemVo implements Serializable {

    private static final long serialVersionUID = 911852628998105063L;
    
    private Long id;
    
    private Long userId;
    
    private Long orderId;
    
    private Integer status;
    
    private String itemName;
    
    private String createTime;
    
    private String modifyTime;
    
}