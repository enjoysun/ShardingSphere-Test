package com.myou.shardingsphere.model.entity;

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
public class TAddress implements Serializable {

    private static final long serialVersionUID = -21710943819914669L;
    
    //主键
    private Long id;
    //地址
    private String addressName;
    //创建时间
    private String createTime;
    //最后修改时间
    private String modifyTime;
}