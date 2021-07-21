package com.myou.shardingsphere.service.impl;

import com.myou.shardingsphere.model.entity.TOrder;
import com.myou.shardingsphere.model.dto.TOrderDto;
import com.myou.shardingsphere.model.vo.TOrderVo;
import com.myou.shardingsphere.mapper.TOrderMapper;
import com.myou.shardingsphere.service.TOrderService;
import org.springframework.stereotype.Service;
import com.github.pagehelper.*;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.annotation.Resource;

/**
 * 订单(TOrder)表服务实现类
 *
 * @author makejava
 * @since 2021-07-21 15:36:07
 */
@Service("tOrderService")
public class TOrderServiceImpl implements TOrderService {

    @Resource
    private TOrderMapper tOrderMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TOrderVo findById(Long id) {
        TOrder tOrder = this.tOrderMapper.selectById(id);
        
        //将TOrder转成TOrderVo
        TOrderVo tOrderVo = null;
        if (tOrder != null){
            tOrderVo = new TOrderVo();
            BeanUtils.copyProperties(tOrder, tOrderVo);
        }
        
        return tOrderVo;
    }

    /**
     * 查询多条数据
     *
     * @param tOrderDto 实例对象
     * @param pageNum 页数
     * @param pageSize 每页条数
     * @return 对象列表
     */
    @Override
    public PageInfo<TOrderVo> findPageList(TOrderDto tOrderDto, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        
        //将TOrder转成TOrderVo
        TOrder tOrder = new TOrder();
        BeanUtils.copyProperties(tOrderDto, tOrder);
        List<TOrder> tOrderList = this.tOrderMapper.selectList(tOrder);
        
        PageInfo<TOrderVo> pageInfo = new PageInfo<>();
        BeanUtils.copyProperties(new PageInfo<>(tOrderList), pageInfo);
        return pageInfo;
    }

    /**
     * 新增数据
     *
     * @param tOrderDto 实例对象
     * @return 实例对象
     */
    @Override
    public TOrderVo add(TOrderDto tOrderDto) {
        //将TOrderDto转成TOrder
        TOrder tOrder = new TOrder();
        BeanUtils.copyProperties(tOrderDto, tOrder);
        this.tOrderMapper.insert(tOrder);
        
        return this.findById(tOrder.getId());
    }

    /**
     * 修改数据
     *
     * @param tOrderDto 实例对象
     * @return 实例对象
     */
    @Override
    public TOrderVo modify(TOrderDto tOrderDto) {
        //将TOrderDto转成TOrder
        TOrder tOrder = new TOrder();
        BeanUtils.copyProperties(tOrderDto, tOrder);
        this.tOrderMapper.update(tOrder);
        
        return this.findById(tOrder.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean remove(Long id) {
        return this.tOrderMapper.deleteById(id) > 0;
    }
}