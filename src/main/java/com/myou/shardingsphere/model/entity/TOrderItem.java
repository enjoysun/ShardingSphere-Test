package com.myou.shardingsphere.model.entity;

import java.util.Date;
import lombok.Data;
import java.io.Serializable;

/**
 * 订单详情(TOrderItem)实体类
 *
 * @author makejava
 * @since 2021-07-21 15:31:57
 */
@Data
public class TOrderItem implements Serializable {

    private static final long serialVersionUID = -28473002952765373L;
    
    //主键
    private Long id;
    //用户ID
    private Long userId;
    //订单ID
    private Long orderId;
    //状态
    private Integer status;
    //商品名称
    private String itemName;
    //创建时间
    private String createTime;
    //最后修改时间
    private String modifyTime;
}