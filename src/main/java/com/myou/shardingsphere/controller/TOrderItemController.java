package com.myou.shardingsphere.controller;

import com.myou.shardingsphere.model.dto.TOrderItemDto;
import com.myou.shardingsphere.model.vo.TOrderItemVo;
import com.myou.shardingsphere.service.TOrderItemService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.*;

import javax.annotation.Resource;

/**
 * 订单详情(TOrderItem)表控制层
 *
 * @author makejava
 * @since 2021-07-21 15:36:07
 */
@RestController
@RequestMapping("/tOrderItem")
public class TOrderItemController {
    
    @Resource
    private TOrderItemService tOrderItemService;

    @GetMapping("/findById/{id}")
    public TOrderItemVo findById( @PathVariable(value = "id") Long id) {
        return this.tOrderItemService.findById(id);
    }
    

    @PostMapping(value = "/findPageList/{pageNum}/{pageSize}")
    public PageInfo<TOrderItemVo> findPageList(@RequestBody TOrderItemDto tOrderItemDto, @PathVariable(value = "pageNum") int pageNum, @PathVariable(value = "pageSize") int pageSize) {
        return this.tOrderItemService.findPageList(tOrderItemDto, pageNum, pageSize);
    }
    
    @PostMapping("/add")
    public TOrderItemVo add( @RequestBody TOrderItemDto tOrderItemDto) {
        return this.tOrderItemService.add(tOrderItemDto);
    }
    
    @PatchMapping("/modify")
    public TOrderItemVo modify( @RequestBody TOrderItemDto tOrderItemDto) {
        return this.tOrderItemService.modify(tOrderItemDto);
    }
    
    @DeleteMapping("/remove/{id}")
    public boolean remove( @PathVariable(value = "id") Long id) {
        return this.tOrderItemService.remove(id);
    }

}