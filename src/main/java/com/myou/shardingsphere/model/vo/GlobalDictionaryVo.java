package com.myou.shardingsphere.model.vo;

import java.util.Date;
import lombok.Data;
import java.io.Serializable;

/**
 * 字典表(GlobalDictionary)实体类
 *
 * @author makejava
 * @since 2021-07-21 15:34:16
 */
@Data
public class GlobalDictionaryVo implements Serializable {

    private static final long serialVersionUID = -35938429197515550L;
    
    private Long id;
    
    private String dicType;
    
    private String dicCode;
    
    private String dicName;
    
    private String remark;
    
    private Integer sort;
    
    private Integer status;
    
    private String ctime;
    
    private String utime;
    
}