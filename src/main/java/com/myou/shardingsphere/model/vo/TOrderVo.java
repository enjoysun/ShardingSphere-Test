package com.myou.shardingsphere.model.vo;

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
public class TOrderVo implements Serializable {

    private static final long serialVersionUID = 333548406442827528L;

    private Long id;

    private Long userId;

    private Long addressId;

    private Integer status;

    private String createTime;

    private String modifyTime;

    private TOrderItemVo orderItemVo;

}