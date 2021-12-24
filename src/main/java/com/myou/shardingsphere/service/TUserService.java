package com.myou.shardingsphere.service;

import com.myou.shardingsphere.model.dto.TUserDto;
import com.myou.shardingsphere.model.vo.TUserVo;
import com.github.pagehelper.*;

import java.util.List;

/**
 * 用户(TUser)表服务接口
 *
 * @author makejava
 * @since 2021-07-21 15:34:52
 */
public interface TUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TUserVo findById(Long id);

    /**
     * 查询多条数据
     *
     * @param tUserDto 实例对象
     * @param pageNum 页数
     * @param pageSize 每页条数
     * @return 对象列表
     */
    PageInfo<TUserVo> findPageList(TUserDto tUserDto, int pageNum, int pageSize);

    /**
     * 新增数据
     *
     * @param tUserDto 实例对象
     * @return 实例对象
     */
    TUserVo add(TUserDto tUserDto);

    /**
     * 修改数据
     *
     * @param tUserDto 实例对象
     * @return 实例对象
     */
    TUserVo modify(TUserDto tUserDto);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean remove(Long id);

    List<TUserVo> findByName(String begin, String end);

}