package com.myou.shardingsphere.model.dto;

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
public class GlobalDictionaryDto implements Serializable {

    private static final long serialVersionUID = -73096502679417732L;
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