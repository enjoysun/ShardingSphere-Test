package com.myou.shardingsphere.service.impl;

import com.myou.shardingsphere.model.entity.TUser;
import com.myou.shardingsphere.model.dto.TUserDto;
import com.myou.shardingsphere.model.vo.TUserVo;
import com.myou.shardingsphere.mapper.TUserMapper;
import com.myou.shardingsphere.service.TUserService;
import org.springframework.stereotype.Service;
import com.github.pagehelper.*;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.annotation.Resource;

/**
 * 用户(TUser)表服务实现类
 *
 * @author makejava
 * @since 2021-07-21 15:34:52
 */
@Service("tUserService")
public class TUserServiceImpl implements TUserService {

    @Resource
    private TUserMapper tUserMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TUserVo findById(Long id) {
        TUser tUser = this.tUserMapper.selectById(id);
        
        //将TUser转成TUserVo
        TUserVo tUserVo = null;
        if (tUser != null){
            tUserVo = new TUserVo();
            BeanUtils.copyProperties(tUser, tUserVo);
        }
        
        return tUserVo;
    }

    /**
     * 查询多条数据
     *
     * @param tUserDto 实例对象
     * @param pageNum 页数
     * @param pageSize 每页条数
     * @return 对象列表
     */
    @Override
    public PageInfo<TUserVo> findPageList(TUserDto tUserDto, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        
        //将TUser转成TUserVo
        TUser tUser = new TUser();
        BeanUtils.copyProperties(tUserDto, tUser);
        List<TUser> tUserList = this.tUserMapper.selectList(tUser);
        
        PageInfo<TUserVo> pageInfo = new PageInfo<>();
        BeanUtils.copyProperties(new PageInfo<>(tUserList), pageInfo);
        return pageInfo;
    }

    /**
     * 新增数据
     *
     * @param tUserDto 实例对象
     * @return 实例对象
     */
    @Override
    public TUserVo add(TUserDto tUserDto) {
        //将TUserDto转成TUser
        TUser tUser = new TUser();
        BeanUtils.copyProperties(tUserDto, tUser);
        this.tUserMapper.insert(tUser);
        
        return this.findById(tUser.getId());
    }

    /**
     * 修改数据
     *
     * @param tUserDto 实例对象
     * @return 实例对象
     */
    @Override
    public TUserVo modify(TUserDto tUserDto) {
        //将TUserDto转成TUser
        TUser tUser = new TUser();
        BeanUtils.copyProperties(tUserDto, tUser);
        this.tUserMapper.update(tUser);
        
        return this.findById(tUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean remove(Long id) {
        return this.tUserMapper.deleteById(id) > 0;
    }
}