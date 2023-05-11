package cn.com.xuxiaowei.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * 测试 数据源
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Slf4j
@TestConfiguration
public class MySQLDataSourceTestConfiguration {

    /**
     * 使用 MySQL 来创建用于测试的 {@link DataSource}
     */
    @Bean
    public DataSource dataSource() {

        String driverClassName = "com.p6spy.engine.spy.P6SpyDriver";
        String url = "jdbc:p6spy:mysql://mysql:3306/coverage_jacoco?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=GMT%2B8";
        String username = "runner";
        String password = "xuxiaowei.com.cn";

        // 创建测试数据源
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }

}
