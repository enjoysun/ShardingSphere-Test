package com.myou.shardingsphere.controller;

import com.myou.shardingsphere.model.dto.TOrderDto;
import com.myou.shardingsphere.model.vo.TOrderVo;
import com.myou.shardingsphere.service.TOrderService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.*;

import javax.annotation.Resource;

/**
 * 订单(TOrder)表控制层
 *
 * @author makejava
 * @since 2021-07-21 15:36:07
 */
@RestController
@RequestMapping("/tOrder")
public class TOrderController {
    
    @Resource
    private TOrderService tOrderService;

    @GetMapping("/findById/{id}")
    public TOrderVo findById( @PathVariable(value = "id") Long id) {
        return this.tOrderService.findById(id);
    }

    @PostMapping(value = "/findPageList/{pageNum}/{pageSize}")
    public PageInfo<TOrderVo> findPageList(@RequestBody TOrderDto tOrderDto, @PathVariable(value = "pageNum") int pageNum, @PathVariable(value = "pageSize") int pageSize) {
        return this.tOrderService.findPageList(tOrderDto, pageNum, pageSize);
    }
    
    @PostMapping("/add")
    public TOrderVo add( @RequestBody TOrderDto tOrderDto) {
        return this.tOrderService.add(tOrderDto);
    }
    
    @PatchMapping("/modify")
    public TOrderVo modify( @RequestBody TOrderDto tOrderDto) {
        return this.tOrderService.modify(tOrderDto);
    }
    
    @DeleteMapping("/remove/{id}")
    public boolean remove( @PathVariable(value = "id") Long id) {
        return this.tOrderService.remove(id);
    }

}