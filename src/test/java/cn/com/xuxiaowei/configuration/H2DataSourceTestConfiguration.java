package cn.com.xuxiaowei.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * 测试 数据源
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Slf4j
@TestConfiguration
public class H2DataSourceTestConfiguration {

    /**
     * 使用 H2 来创建用于测试的 {@link DataSource}
     */
    @Bean
    public DataSource dataSource() {

        // 创建测试数据源
        // @formatter:off
        EmbeddedDatabase dataSource = new EmbeddedDatabaseBuilder().generateUniqueName(true)
                .setType(EmbeddedDatabaseType.H2)
                .setScriptEncoding("UTF-8")
                .build();
        // @formatter:on

        return dataSource;
    }


}
