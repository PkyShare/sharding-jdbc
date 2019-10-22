package com.pky.shardingjdbc;

import com.pky.shardingjdbc.domain.Order;
import com.pky.shardingjdbc.mapper.OrderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ShardingJDBCApplication.class})
public class OrderTest {

    @Autowired
    OrderMapper orderMapper;

    @Test
    public void testInsert() {
        for(int i = 0; i < 20; i++) {
            orderMapper.insert(new BigDecimal(i), 1L, "yes");
        }
    }

    @Test
    public void testSelect() {
        List<Long> orderIds = new ArrayList<>();
        orderIds.add(393345721874513920l);
        orderIds.add(393345722830815232l);
        orderIds.add(393345721346031617l);
        List<Map> orders = orderMapper.selectOrderByIds(orderIds);
    }
}