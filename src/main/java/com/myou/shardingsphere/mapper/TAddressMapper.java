package com.myou.shardingsphere.mapper;

import com.myou.shardingsphere.model.entity.TAddress;
import java.util.List;

/**
 * 收货地址(TAddress)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-21 15:36:07
 */
public interface TAddressMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TAddress selectById(Long id);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param tAddress 实例对象
     * @return 对象列表
     */
    List<TAddress> selectList(TAddress tAddress);

    /**
     * 新增数据
     *
     * @param tAddress 实例对象
     * @return 影响行数
     */
    int insert(TAddress tAddress);

    /**
     * 修改数据
     *
     * @param tAddress 实例对象
     * @return 影响行数
     */
    int update(TAddress tAddress);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}