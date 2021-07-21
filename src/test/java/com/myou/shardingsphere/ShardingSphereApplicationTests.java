package com.myou.shardingsphere;

import com.myou.shardingsphere.model.dto.GlobalDictionaryDto;
import com.myou.shardingsphere.model.vo.GlobalDictionaryVo;
import com.myou.shardingsphere.service.GlobalDictionaryService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class ShardingSphereApplicationTests {

    @Autowired
    private GlobalDictionaryService dictionaryService;

    /*
    * 分库案例测试
    */
    @Test
    void caseBoastTest() {
        GlobalDictionaryDto globalDictionaryDto = new GlobalDictionaryDto();
        globalDictionaryDto.setId(1L);
        globalDictionaryDto.setDicCode("JX");
        globalDictionaryDto.setDicName("机械");
        globalDictionaryDto.setDicType("DEVICE");
        globalDictionaryDto.setRemark("机械分类");
        globalDictionaryDto.setSort(1);
        globalDictionaryDto.setStatus(0);
        GlobalDictionaryVo vo = dictionaryService.add(globalDictionaryDto);
        System.out.println("ok");
    }


}
