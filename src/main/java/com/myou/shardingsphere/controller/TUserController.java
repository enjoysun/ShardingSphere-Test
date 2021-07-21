package com.myou.shardingsphere.controller;

import com.myou.shardingsphere.model.dto.TUserDto;
import com.myou.shardingsphere.model.vo.TUserVo;
import com.myou.shardingsphere.service.TUserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.*;

import javax.annotation.Resource;

/**
 * 用户(TUser)表控制层
 *
 * @author makejava
 * @since 2021-07-21 15:35:00
 */
@RestController
@RequestMapping("/tUser")
public class TUserController {
    
    @Resource
    private TUserService tUserService;

    @GetMapping("/findById/{id}")
    public TUserVo findById( @PathVariable(value = "id") Long id) {
        return this.tUserService.findById(id);
    }
    

    @PostMapping(value = "/findPageList/{pageNum}/{pageSize}")
    public PageInfo<TUserVo> findPageList(@RequestBody TUserDto tUserDto, @PathVariable(value = "pageNum") int pageNum, @PathVariable(value = "pageSize") int pageSize) {
        return this.tUserService.findPageList(tUserDto, pageNum, pageSize);
    }
    
    @PostMapping("/add")
    public TUserVo add( @RequestBody TUserDto tUserDto) {
        return this.tUserService.add(tUserDto);
    }
    
    @PatchMapping("/modify")
    public TUserVo modify( @RequestBody TUserDto tUserDto) {
        return this.tUserService.modify(tUserDto);
    }
    
    @DeleteMapping("/remove/{id}")
    public boolean remove( @PathVariable(value = "id") Long id) {
        return this.tUserService.remove(id);
    }

}