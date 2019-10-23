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
            orderMapper.insert(new BigDecimal(i), 2L, "yes");
        }
    }

    @Test
    public void testSelectByOrderIds() {
        List<Long> orderIds = new ArrayList<>();
        orderIds.add(393345721874513920l);
        orderIds.add(393783366735888385L);
        List<Map> orders = orderMapper.selectOrderByOrderIds(orderIds);
    }

    /**
     * 通过订单id和用户id查询
     */
    @Test
    public void testSelectByOrderIdsAndUserId() {
        List<Long> orderIds = new ArrayList<>();
        orderIds.add(393345721874513920l);
        orderIds.add(393783366735888385L);
        List<Map> orders = orderMapper.selectOrderByOrderIdsAndUserId(orderIds, 2L);
    }

}