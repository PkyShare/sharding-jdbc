package com.pky.shardingjdbc;

import org.apache.shardingsphere.shardingjdbc.spring.boot.SpringBootConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@SpringBootApplication(exclude = SpringBootConfiguration.class) // 排除 SpringBoot 默认读取 properties 或 yml 配置文件
@MapperScan(basePackages = "com.pky.shardingjdbc.mapper")  // 扫描该路径下的 mapper
public class ShardingJDBCApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShardingJDBCApplication.class, args);
    }
}
