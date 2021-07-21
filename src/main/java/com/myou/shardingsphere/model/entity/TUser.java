package com.myou.shardingsphere.model.entity;

import java.util.Date;
import lombok.Data;
import java.io.Serializable;

/**
 * 用户(TUser)实体类
 *
 * @author makejava
 * @since 2021-07-21 15:32:07
 */
@Data
public class TUser implements Serializable {

    private static final long serialVersionUID = -25723697720654196L;
    
    //主键
    private Long id;
    //用户名
    private String userName;
    //用户密码
    private String pwd;
    //创建时间
    private String createTime;
    //最后修改时间
    private String modifyTime;
}