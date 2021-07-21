package com.myou.shardingsphere.service.impl;

import com.myou.shardingsphere.model.entity.GlobalDictionary;
import com.myou.shardingsphere.model.dto.GlobalDictionaryDto;
import com.myou.shardingsphere.model.vo.GlobalDictionaryVo;
import com.myou.shardingsphere.mapper.GlobalDictionaryMapper;
import com.myou.shardingsphere.service.GlobalDictionaryService;
import org.springframework.stereotype.Service;
import com.github.pagehelper.*;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.annotation.Resource;

/**
 * 字典表(GlobalDictionary)表服务实现类
 *
 * @author makejava
 * @since 2021-07-21 15:36:07
 */
@Service("globalDictionaryService")
public class GlobalDictionaryServiceImpl implements GlobalDictionaryService {

    @Resource
    private GlobalDictionaryMapper globalDictionaryMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public GlobalDictionaryVo findById(Long id) {
        GlobalDictionary globalDictionary = this.globalDictionaryMapper.selectById(id);
        
        //将GlobalDictionary转成GlobalDictionaryVo
        GlobalDictionaryVo globalDictionaryVo = null;
        if (globalDictionary != null){
            globalDictionaryVo = new GlobalDictionaryVo();
            BeanUtils.copyProperties(globalDictionary, globalDictionaryVo);
        }
        
        return globalDictionaryVo;
    }

    /**
     * 查询多条数据
     *
     * @param globalDictionaryDto 实例对象
     * @param pageNum 页数
     * @param pageSize 每页条数
     * @return 对象列表
     */
    @Override
    public PageInfo<GlobalDictionaryVo> findPageList(GlobalDictionaryDto globalDictionaryDto, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        
        //将GlobalDictionary转成GlobalDictionaryVo
        GlobalDictionary globalDictionary = new GlobalDictionary();
        BeanUtils.copyProperties(globalDictionaryDto, globalDictionary);
        List<GlobalDictionary> globalDictionaryList = this.globalDictionaryMapper.selectList(globalDictionary);
        
        PageInfo<GlobalDictionaryVo> pageInfo = new PageInfo<>();
        BeanUtils.copyProperties(new PageInfo<>(globalDictionaryList), pageInfo);
        return pageInfo;
    }

    /**
     * 新增数据
     *
     * @param globalDictionaryDto 实例对象
     * @return 实例对象
     */
    @Override
    public GlobalDictionaryVo add(GlobalDictionaryDto globalDictionaryDto) {
        //将GlobalDictionaryDto转成GlobalDictionary
        GlobalDictionary globalDictionary = new GlobalDictionary();
        BeanUtils.copyProperties(globalDictionaryDto, globalDictionary);
        this.globalDictionaryMapper.insert(globalDictionary);
        
        return this.findById(globalDictionary.getId());
    }

    /**
     * 修改数据
     *
     * @param globalDictionaryDto 实例对象
     * @return 实例对象
     */
    @Override
    public GlobalDictionaryVo modify(GlobalDictionaryDto globalDictionaryDto) {
        //将GlobalDictionaryDto转成GlobalDictionary
        GlobalDictionary globalDictionary = new GlobalDictionary();
        BeanUtils.copyProperties(globalDictionaryDto, globalDictionary);
        this.globalDictionaryMapper.update(globalDictionary);
        
        return this.findById(globalDictionary.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean remove(Long id) {
        return this.globalDictionaryMapper.deleteById(id) > 0;
    }
}