package com.myou.shardingsphere.mapper;

import com.myou.shardingsphere.model.entity.GlobalDictionary;
import java.util.List;

/**
 * 字典表(GlobalDictionary)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-21 15:36:07
 */
public interface GlobalDictionaryMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    GlobalDictionary selectById(Long id);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param globalDictionary 实例对象
     * @return 对象列表
     */
    List<GlobalDictionary> selectList(GlobalDictionary globalDictionary);

    /**
     * 新增数据
     *
     * @param globalDictionary 实例对象
     * @return 影响行数
     */
    int insert(GlobalDictionary globalDictionary);

    /**
     * 修改数据
     *
     * @param globalDictionary 实例对象
     * @return 影响行数
     */
    int update(GlobalDictionary globalDictionary);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}