package com.myou.shardingsphere.model.vo;

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
public class TUserVo implements Serializable {

    private static final long serialVersionUID = 531733923622769580L;
    
    private Long id;
    
    private String userName;
    
    private String pwd;
    
    private String createTime;
    
    private String modifyTime;
    
}