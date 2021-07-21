package com.myou.shardingsphere.model.entity;

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
public class GlobalDictionary implements Serializable {

    private static final long serialVersionUID = 817430562724657542L;
    
    //主键id
    private Long id;
    //字典类型
    private String dicType;
    //字典编码
    private String dicCode;
    //字典名称
    private String dicName;
    //解释说明
    private String remark;
    //排序
    private Integer sort;
    //是否有效 1有效，0无效
    private Integer status;
    //创建时间
    private String ctime;
    //最后修改时间
    private String utime;
}