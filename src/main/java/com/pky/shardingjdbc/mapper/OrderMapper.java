package com.pky.shardingjdbc.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface OrderMapper {

    @Insert("insert inot t_order(price, user_id, status) values (#{price},#{userId}, #{status})")
    void insert(@Param("price") BigDecimal price, @Param("userId") Long userId, @Param("status") String status);

}
