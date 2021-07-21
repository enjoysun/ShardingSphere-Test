package com.myou.shardingsphere.mapper;

import com.myou.shardingsphere.model.entity.TOrderItem;
import java.util.List;

/**
 * 订单详情(TOrderItem)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-21 15:36:07
 */
public interface TOrderItemMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TOrderItem selectById(Long id);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param tOrderItem 实例对象
     * @return 对象列表
     */
    List<TOrderItem> selectList(TOrderItem tOrderItem);

    /**
     * 新增数据
     *
     * @param tOrderItem 实例对象
     * @return 影响行数
     */
    int insert(TOrderItem tOrderItem);

    /**
     * 修改数据
     *
     * @param tOrderItem 实例对象
     * @return 影响行数
     */
    int update(TOrderItem tOrderItem);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}