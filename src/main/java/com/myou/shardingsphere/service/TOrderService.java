package com.myou.shardingsphere.service;

import com.myou.shardingsphere.model.dto.TOrderDto;
import com.myou.shardingsphere.model.vo.TOrderVo;
import com.github.pagehelper.*;

/**
 * 订单(TOrder)表服务接口
 *
 * @author makejava
 * @since 2021-07-21 15:36:07
 */
public interface TOrderService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TOrderVo findById(Long id);

    /**
     * 查询多条数据
     *
     * @param tOrderDto 实例对象
     * @param pageNum 页数
     * @param pageSize 每页条数
     * @return 对象列表
     */
    PageInfo<TOrderVo> findPageList(TOrderDto tOrderDto, int pageNum, int pageSize);

    /**
     * 新增数据
     *
     * @param tOrderDto 实例对象
     * @return 实例对象
     */
    TOrderVo add(TOrderDto tOrderDto);

    /**
     * 修改数据
     *
     * @param tOrderDto 实例对象
     * @return 实例对象
     */
    TOrderVo modify(TOrderDto tOrderDto);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean remove(Long id);

}