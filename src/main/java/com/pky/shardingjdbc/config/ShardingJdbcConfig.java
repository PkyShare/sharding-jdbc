package com.pky.shardingjdbc.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shardingsphere.api.config.sharding.KeyGeneratorConfiguration;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.TableRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.InlineShardingStrategyConfiguration;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Sharding-JDBC 配置类
 */
//@Configuration
public class ShardingJdbcConfig {

    /**
     * 配置分片策略（定义数据源）
     * @return
     */
    public Map<String, DataSource> createDataSourceMap() {
        DruidDataSource dataSource1 = new DruidDataSource();
        dataSource1.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource1.setUrl("jdbc:mysql://192.168.6.101:3306/order_db?useSSL=false&useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=Asia/Shanghai");
        dataSource1.setUsername("root");
        dataSource1.setPassword("host");
        Map<String, DataSource> result = new HashMap<>();
        result.put("m1", dataSource1);
        return result;
    }

    /**
     * 定义主键生成策略
     * @return
     */
    private static KeyGeneratorConfiguration getKeyGeneratorConfiguration() {
        KeyGeneratorConfiguration result = new KeyGeneratorConfiguration("SNOWFLAKE", "order_id");
        return result;
    }

    /**
     * 定义 t_order 表分片策略
     * @return
     */
    public TableRuleConfiguration getOrderTableRuleConfiguration() {
        TableRuleConfiguration result = new TableRuleConfiguration("t_order", "m1.t_order_$->{1..2}");
        result.setTableShardingStrategyConfig(new InlineShardingStrategyConfiguration("order_id","t_order_$->{order_id % 2 + 1}"));
        result.setKeyGeneratorConfig(getKeyGeneratorConfiguration());
        return result;
    }

    /**
     * 定义sharding-JDBC 数据源
     * @return
     * @throws SQLException
     */
    @Bean
    public DataSource getShardingDataSource() throws SQLException {
        ShardingRuleConfiguration shardingRuleConfiguration = new ShardingRuleConfiguration();
        shardingRuleConfiguration.getTableRuleConfigs().add(getOrderTableRuleConfiguration());
        // spring.shardingsphere.props.sql.show = true
        Properties properties = new Properties();
        properties.put("sql.show", "true");
        return ShardingDataSourceFactory.createDataSource(createDataSourceMap(), shardingRuleConfiguration, properties);
    }
}
