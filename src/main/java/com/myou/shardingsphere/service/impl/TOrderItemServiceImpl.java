package com.myou.shardingsphere.service.impl;

import com.myou.shardingsphere.model.entity.TOrderItem;
import com.myou.shardingsphere.model.dto.TOrderItemDto;
import com.myou.shardingsphere.model.vo.TOrderItemVo;
import com.myou.shardingsphere.mapper.TOrderItemMapper;
import com.myou.shardingsphere.service.TOrderItemService;
import org.springframework.stereotype.Service;
import com.github.pagehelper.*;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.annotation.Resource;

/**
 * 订单详情(TOrderItem)表服务实现类
 *
 * @author makejava
 * @since 2021-07-21 15:36:06
 */
@Service("tOrderItemService")
public class TOrderItemServiceImpl implements TOrderItemService {

    @Resource
    private TOrderItemMapper tOrderItemMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TOrderItemVo findById(Long id) {
        TOrderItem tOrderItem = this.tOrderItemMapper.selectById(id);
        
        //将TOrderItem转成TOrderItemVo
        TOrderItemVo tOrderItemVo = null;
        if (tOrderItem != null){
            tOrderItemVo = new TOrderItemVo();
            BeanUtils.copyProperties(tOrderItem, tOrderItemVo);
        }
        
        return tOrderItemVo;
    }

    /**
     * 查询多条数据
     *
     * @param tOrderItemDto 实例对象
     * @param pageNum 页数
     * @param pageSize 每页条数
     * @return 对象列表
     */
    @Override
    public PageInfo<TOrderItemVo> findPageList(TOrderItemDto tOrderItemDto, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        
        //将TOrderItem转成TOrderItemVo
        TOrderItem tOrderItem = new TOrderItem();
        BeanUtils.copyProperties(tOrderItemDto, tOrderItem);
        List<TOrderItem> tOrderItemList = this.tOrderItemMapper.selectList(tOrderItem);
        
        PageInfo<TOrderItemVo> pageInfo = new PageInfo<>();
        BeanUtils.copyProperties(new PageInfo<>(tOrderItemList), pageInfo);
        return pageInfo;
    }

    /**
     * 新增数据
     *
     * @param tOrderItemDto 实例对象
     * @return 实例对象
     */
    @Override
    public TOrderItemVo add(TOrderItemDto tOrderItemDto) {
        //将TOrderItemDto转成TOrderItem
        TOrderItem tOrderItem = new TOrderItem();
        BeanUtils.copyProperties(tOrderItemDto, tOrderItem);
        this.tOrderItemMapper.insert(tOrderItem);
        
        return this.findById(tOrderItem.getId());
    }

    /**
     * 修改数据
     *
     * @param tOrderItemDto 实例对象
     * @return 实例对象
     */
    @Override
    public TOrderItemVo modify(TOrderItemDto tOrderItemDto) {
        //将TOrderItemDto转成TOrderItem
        TOrderItem tOrderItem = new TOrderItem();
        BeanUtils.copyProperties(tOrderItemDto, tOrderItem);
        this.tOrderItemMapper.update(tOrderItem);
        
        return this.findById(tOrderItem.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean remove(Long id) {
        return this.tOrderItemMapper.deleteById(id) > 0;
    }
}