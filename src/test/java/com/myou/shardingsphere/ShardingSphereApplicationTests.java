package com.myou.shardingsphere;

import com.github.pagehelper.PageInfo;
import com.myou.shardingsphere.model.dto.*;
import com.myou.shardingsphere.model.vo.*;
import com.myou.shardingsphere.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = ShardingSphereApplication.class)
class ShardingSphereApplicationTests {

    @Autowired
    private GlobalDictionaryService dictionaryService;

    @Autowired
    private TUserService userService;

    @Autowired
    private TAddressService addressService;

    @Autowired
    private TOrderService orderService;

    @Autowired
    private TOrderItemService orderItemService;

    /*
     * 分库案例测试
     */
    @Test
    void caseBoastTest() {
        GlobalDictionaryDto globalDictionaryDto = new GlobalDictionaryDto();
        globalDictionaryDto.setId(1L);
        globalDictionaryDto.setDicCode("JX");
        globalDictionaryDto.setDicName("机械");
        globalDictionaryDto.setDicType("DEVICE0");
        globalDictionaryDto.setRemark("机械分类");
        globalDictionaryDto.setSort(1);
        globalDictionaryDto.setStatus(0);
        GlobalDictionaryVo vo = dictionaryService.add(globalDictionaryDto);
//        GlobalDictionaryVo vo1 = dictionaryService.add(globalDictionaryDto);
        System.out.println("ok");
    }

    /*
     * 未分库的数据源默认路由测试
     * */
    @Test
    void caseSingleTest() {
        TAddressDto tAddressDto = new TAddressDto();
        tAddressDto.setAddressName("ds0测试");
        TAddressVo addressVo = addressService.add(tAddressDto);
        System.out.println("ok");
    }

    /*单数据源水平分表测试*/
    @Test
    void caseTablesTest() {
        TOrderDto tOrderDto = new TOrderDto();
        tOrderDto.setAddressId(1L);
        tOrderDto.setUserId(7L);
        tOrderDto.setStatus(1);
        TOrderVo orderVo = orderService.add(tOrderDto);
        TOrderItemDto tOrderItemDto = new TOrderItemDto();
        tOrderItemDto.setOrderId(orderVo.getId());
        tOrderItemDto.setItemName("测试7");
        TOrderItemVo orderItemVo = orderItemService.add(tOrderItemDto);
        System.out.println("ok");
    }

    /*分片表联合查询单数据源测试*/
    @Test
    void caseTablesQueryTest() {
        TOrderVo tOrderVo = orderService.selectDescById(631095231017652224L);
        System.out.println("ok");
    }

    /*单表默认数据源查询测试*/
    @Test
    void caseTablesSingleQueryTest() {
        TAddressVo addressVo = addressService.findById(1L);
        System.out.println("ok");
    }

    /*分片表笛卡尔乘积查询测试*/
    @Test
    void caseTablesInQueryTest() {
        List<Long> ids = new ArrayList<>();
        ids.add(630434580024791040L);
        ids.add(630434350269206528L);
        ids.add(631095231017652224L);
        List<TOrderVo> orderVos = orderService.selectInId(ids);
        System.out.println("ok");
    }

    /*测试范围多表结果合并查询*/
    @Test
    void caseTablesLtQueryTest(){
        List<TOrderVo> orderVos = orderService.selectLtById(630434259244421120L);
        System.out.println("ok");
    }

    /*测试排序多表结果合并查询*/
    @Test
    void caseTablesOrderByQueryTest(){
        PageInfo<TOrderVo> pageList = orderService.selectListLimit();
        System.out.println("ok");
    }

    /*测试按照时间水平分表数据落入*/
    @Test
    void tUserTableTest(){
        TUserDto tUserDto = new TUserDto();
        tUserDto.setId(1L);
        tUserDto.setUserName("2021-05-08");
        tUserDto.setPwd("123");
        TUserVo add = userService.add(tUserDto);
        System.out.println("ok");
    }
}
