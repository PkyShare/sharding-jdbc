package com.pky.shardingjdbc;

import com.pky.shardingjdbc.mapper.OrderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ShardingJDBCApplication.class})
public class OrderTest {

    @Autowired
    OrderMapper orderMapper;

    @Test
    public void testOrder() {
        for(int i = 0; i < 20; i++) {
            orderMapper.insert(new BigDecimal(i), 1L, "yes");
        }
    }
}