package com.myou.shardingsphere.model.entity;

import java.util.Date;
import lombok.Data;
import java.io.Serializable;

/**
 * 订单(TOrder)实体类
 *
 * @author makejava
 * @since 2021-07-21 15:33:24
 */
@Data
public class TOrder implements Serializable {

    private static final long serialVersionUID = 145338139917378496L;
    
    //主键
    private Long id;
    //用户ID
    private Long userId;
    //地址ID
    private Long addressId;
    //订单状态
    private Integer status;
    //创建时间
    private String createTime;
    //最后修改时间
    private String modifyTime;

    private TOrderItem orderItem;
}