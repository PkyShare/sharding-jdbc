package com.pky.shardingjdbc.order;

import com.pky.shardingjdbc.ShardingJDBCApplication;
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
        orderMapper.insert(new BigDecimal(11), 1l, "yes");
    }
}
