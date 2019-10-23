package com.pky.shardingjdbc.mapper;

import com.alibaba.druid.sql.visitor.functions.Char;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {

    /**
     * 插入用户
     * @param userId 用户
     * @param username 用户名
     * @param userType 用户类型
     */
    @Insert("insert into t_user(user_id, username, user_type) values (#{userId}, #{username}, #{userType})")
    void insert(@Param("userId") Long userId, @Param("username") String username, @Param("userType") Character userType);

    /**
     * 根据id查询用户
     * @param userIds id集合
     * @return
     */
    @Select("<script>" +
            "select * from t_user u " +
            "where u.user_id in " +
            "<foreach collection = 'userIds' open = '(' separator = ',' close = ')' item = 'id'> " +
            "#{id}" +
            "</foreach>" +
            "</script>")
    List<Map> selectUserByUserIds(@Param("userIds") List<Long> userIds);

    /**
     * 根据id和字典信息查询用户
     * @param userIds id集合
     * @return
     */
    @Select("<script>" +
            "select * from t_user u, t_dict d " +
            "where u.user_type = d.code and u.user_id in " +
            "<foreach collection = 'userIds' open = '(' separator = ',' close = ')' item = 'id'> " +
            "#{id}" +
            "</foreach>" +
            "</script>")
    List<Map> selectUserByUserInfo(@Param("userIds") List<Long> userIds );

}
