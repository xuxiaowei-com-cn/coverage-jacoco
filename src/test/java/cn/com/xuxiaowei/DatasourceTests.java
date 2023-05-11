package cn.com.xuxiaowei;

import cn.com.xuxiaowei.configuration.H2DataSourceTestConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 数据库 测试类
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Slf4j
@Import(H2DataSourceTestConfiguration.class)
@SpringBootTest
class DatasourceTests {

    @Resource
    private DataSource dataSource;

    @Test
    void test() {
        try (Connection connection = dataSource.getConnection()) {
            log.info(String.valueOf(connection));
            PreparedStatement preparedStatement = connection.prepareStatement("select 3 * 4 as a");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int a = resultSet.getInt("a");
                log.info(String.valueOf(a));
            }
        } catch (SQLException e) {
            log.error("数据库测试异常", e);
        }
    }

}
