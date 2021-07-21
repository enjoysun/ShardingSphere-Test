package com.myou.shardingsphere.service.impl;

import com.myou.shardingsphere.model.entity.TAddress;
import com.myou.shardingsphere.model.dto.TAddressDto;
import com.myou.shardingsphere.model.vo.TAddressVo;
import com.myou.shardingsphere.mapper.TAddressMapper;
import com.myou.shardingsphere.service.TAddressService;
import org.springframework.stereotype.Service;
import com.github.pagehelper.*;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.annotation.Resource;

/**
 * 收货地址(TAddress)表服务实现类
 *
 * @author makejava
 * @since 2021-07-21 15:36:07
 */
@Service("tAddressService")
public class TAddressServiceImpl implements TAddressService {

    @Resource
    private TAddressMapper tAddressMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TAddressVo findById(Long id) {
        TAddress tAddress = this.tAddressMapper.selectById(id);
        
        //将TAddress转成TAddressVo
        TAddressVo tAddressVo = null;
        if (tAddress != null){
            tAddressVo = new TAddressVo();
            BeanUtils.copyProperties(tAddress, tAddressVo);
        }
        
        return tAddressVo;
    }

    /**
     * 查询多条数据
     *
     * @param tAddressDto 实例对象
     * @param pageNum 页数
     * @param pageSize 每页条数
     * @return 对象列表
     */
    @Override
    public PageInfo<TAddressVo> findPageList(TAddressDto tAddressDto, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        
        //将TAddress转成TAddressVo
        TAddress tAddress = new TAddress();
        BeanUtils.copyProperties(tAddressDto, tAddress);
        List<TAddress> tAddressList = this.tAddressMapper.selectList(tAddress);
        
        PageInfo<TAddressVo> pageInfo = new PageInfo<>();
        BeanUtils.copyProperties(new PageInfo<>(tAddressList), pageInfo);
        return pageInfo;
    }

    /**
     * 新增数据
     *
     * @param tAddressDto 实例对象
     * @return 实例对象
     */
    @Override
    public TAddressVo add(TAddressDto tAddressDto) {
        //将TAddressDto转成TAddress
        TAddress tAddress = new TAddress();
        BeanUtils.copyProperties(tAddressDto, tAddress);
        this.tAddressMapper.insert(tAddress);
        
        return this.findById(tAddress.getId());
    }

    /**
     * 修改数据
     *
     * @param tAddressDto 实例对象
     * @return 实例对象
     */
    @Override
    public TAddressVo modify(TAddressDto tAddressDto) {
        //将TAddressDto转成TAddress
        TAddress tAddress = new TAddress();
        BeanUtils.copyProperties(tAddressDto, tAddress);
        this.tAddressMapper.update(tAddress);
        
        return this.findById(tAddress.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean remove(Long id) {
        return this.tAddressMapper.deleteById(id) > 0;
    }
}