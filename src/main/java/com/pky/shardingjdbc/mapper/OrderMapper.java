package com.pky.shardingjdbc.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Repository
public interface OrderMapper {

    /**
     * 插入订单
     * @param price 价格
     * @param userId 用户id
     * @param status 状态
     */
    @Insert("insert into t_order(price, user_id, status) values (#{price}, #{userId}, #{status})")
    void insert(@Param("price") BigDecimal price, @Param("userId") Long userId, @Param("status") String status);

    /**
     * 根据id查询订单
     * @param orderIds id集合
     * @return
     */
    @Select("<script>" +
            "select * from t_order o " +
            "where o.order_id in " +
            "<foreach collection = 'orderIds' open = '(' separator = ',' close = ')' item = 'id'> " +
            "#{id}" +
            "</foreach>" +
            "</script>")
    List<Map> selectOrderByIds(@Param("orderIds") List<Long> orderIds);

}
