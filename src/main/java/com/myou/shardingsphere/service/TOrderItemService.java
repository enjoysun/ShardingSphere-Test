package com.myou.shardingsphere.service;

import com.myou.shardingsphere.model.dto.TOrderItemDto;
import com.myou.shardingsphere.model.vo.TOrderItemVo;
import com.github.pagehelper.*;

/**
 * 订单详情(TOrderItem)表服务接口
 *
 * @author makejava
 * @since 2021-07-21 15:36:06
 */
public interface TOrderItemService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TOrderItemVo findById(Long id);

    /**
     * 查询多条数据
     *
     * @param tOrderItemDto 实例对象
     * @param pageNum 页数
     * @param pageSize 每页条数
     * @return 对象列表
     */
    PageInfo<TOrderItemVo> findPageList(TOrderItemDto tOrderItemDto, int pageNum, int pageSize);

    /**
     * 新增数据
     *
     * @param tOrderItemDto 实例对象
     * @return 实例对象
     */
    TOrderItemVo add(TOrderItemDto tOrderItemDto);

    /**
     * 修改数据
     *
     * @param tOrderItemDto 实例对象
     * @return 实例对象
     */
    TOrderItemVo modify(TOrderItemDto tOrderItemDto);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean remove(Long id);

}