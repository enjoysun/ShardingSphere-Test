package com.myou.shardingsphere.service;

import com.myou.shardingsphere.model.dto.GlobalDictionaryDto;
import com.myou.shardingsphere.model.vo.GlobalDictionaryVo;
import com.github.pagehelper.*;

/**
 * 字典表(GlobalDictionary)表服务接口
 *
 * @author makejava
 * @since 2021-07-21 15:36:07
 */
public interface GlobalDictionaryService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    GlobalDictionaryVo findById(Long id);

    /**
     * 查询多条数据
     *
     * @param globalDictionaryDto 实例对象
     * @param pageNum 页数
     * @param pageSize 每页条数
     * @return 对象列表
     */
    PageInfo<GlobalDictionaryVo> findPageList(GlobalDictionaryDto globalDictionaryDto, int pageNum, int pageSize);

    /**
     * 新增数据
     *
     * @param globalDictionaryDto 实例对象
     * @return 实例对象
     */
    GlobalDictionaryVo add(GlobalDictionaryDto globalDictionaryDto);

    /**
     * 修改数据
     *
     * @param globalDictionaryDto 实例对象
     * @return 实例对象
     */
    GlobalDictionaryVo modify(GlobalDictionaryDto globalDictionaryDto);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean remove(Long id);

}