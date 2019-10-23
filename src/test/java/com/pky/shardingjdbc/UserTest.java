package com.pky.shardingjdbc;

import com.pky.shardingjdbc.mapper.UserMapper;
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
public class UserTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void testInsert() {
        for(long i = 0; i < 20; i++) {
            userMapper.insert(i, "姓名" + i , '1');
        }
    }

    @Test
    public void testSelectByOrderIds() {
        List<Long> userIds = new ArrayList<>();
        userIds.add(1L);
        userIds.add(11L);
        List<Map> orders = userMapper.selectUserByUserIds(userIds);
    }

    @Test
    public void testSelectByUserIds() {
        List<Long> userIds = new ArrayList<>();
        userIds.add(1L);
        userIds.add(11L);
        List<Map> users = userMapper.selectUserByUserInfo(userIds);
        for (Map user: users) {
            System.out.println(user.toString());
        }
    }
}
