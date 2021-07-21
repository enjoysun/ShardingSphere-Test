package com.myou.shardingsphere.controller;

import com.myou.shardingsphere.model.dto.TAddressDto;
import com.myou.shardingsphere.model.vo.TAddressVo;
import com.myou.shardingsphere.service.TAddressService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.*;

import javax.annotation.Resource;

/**
 * 收货地址(TAddress)表控制层
 *
 * @author makejava
 * @since 2021-07-21 15:36:07
 */
@RestController
@RequestMapping("/tAddress")
public class TAddressController {
    
    @Resource
    private TAddressService tAddressService;

    @GetMapping("/findById/{id}")
    public TAddressVo findById( @PathVariable(value = "id") Long id) {
        return this.tAddressService.findById(id);
    }

    @PostMapping(value = "/findPageList/{pageNum}/{pageSize}")
    public PageInfo<TAddressVo> findPageList(@RequestBody TAddressDto tAddressDto, @PathVariable(value = "pageNum") int pageNum, @PathVariable(value = "pageSize") int pageSize) {
        return this.tAddressService.findPageList(tAddressDto, pageNum, pageSize);
    }
    
    @PostMapping("/add")
    public TAddressVo add( @RequestBody TAddressDto tAddressDto) {
        return this.tAddressService.add(tAddressDto);
    }
    
    @PatchMapping("/modify")
    public TAddressVo modify( @RequestBody TAddressDto tAddressDto) {
        return this.tAddressService.modify(tAddressDto);
    }
    
    @DeleteMapping("/remove/{id}")
    public boolean remove( @PathVariable(value = "id") Long id) {
        return this.tAddressService.remove(id);
    }

}