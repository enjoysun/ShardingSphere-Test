package com.myou.shardingsphere.controller;

import com.myou.shardingsphere.model.dto.GlobalDictionaryDto;
import com.myou.shardingsphere.model.vo.GlobalDictionaryVo;
import com.myou.shardingsphere.service.GlobalDictionaryService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.*;

import javax.annotation.Resource;

/**
 * 字典表(GlobalDictionary)表控制层
 *
 * @author makejava
 * @since 2021-07-21 15:36:07
 */
@RestController
@RequestMapping("/globalDictionary")
public class GlobalDictionaryController {
    
    @Resource
    private GlobalDictionaryService globalDictionaryService;

    @GetMapping("/findById/{id}")
    public GlobalDictionaryVo findById( @PathVariable(value = "id") Long id) {
        return this.globalDictionaryService.findById(id);
    }

    @PostMapping(value = "/findPageList/{pageNum}/{pageSize}")
    public PageInfo<GlobalDictionaryVo> findPageList(@RequestBody GlobalDictionaryDto globalDictionaryDto, @PathVariable(value = "pageNum") int pageNum, @PathVariable(value = "pageSize") int pageSize) {
        return this.globalDictionaryService.findPageList(globalDictionaryDto, pageNum, pageSize);
    }
    
    @PostMapping("/add")
    public GlobalDictionaryVo add( @RequestBody GlobalDictionaryDto globalDictionaryDto) {
        return this.globalDictionaryService.add(globalDictionaryDto);
    }
    
    @PatchMapping("/modify")
    public GlobalDictionaryVo modify( @RequestBody GlobalDictionaryDto globalDictionaryDto) {
        return this.globalDictionaryService.modify(globalDictionaryDto);
    }
    
    @DeleteMapping("/remove/{id}")
    public boolean remove(@PathVariable(value = "id") Long id) {
        return this.globalDictionaryService.remove(id);
    }

}