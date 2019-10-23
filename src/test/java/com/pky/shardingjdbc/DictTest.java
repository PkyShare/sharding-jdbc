package com.pky.shardingjdbc;

import com.pky.shardingjdbc.mapper.DictMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ShardingJDBCApplication.class})
public class DictTest {

    @Autowired
    DictMapper dictMapper;

    @Test
    public void testInsert() {
        dictMapper.insertDict(1L, "user_type", "0", "超级管理员");
        dictMapper.insertDict(3L, "user_type", "1", "普通管理员");
    }

    @Test
    public void testDelete() {
        dictMapper.deleteDict(1L);
    }

}
