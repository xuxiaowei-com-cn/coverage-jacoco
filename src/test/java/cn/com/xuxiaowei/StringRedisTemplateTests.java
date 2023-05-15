package cn.com.xuxiaowei;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.UUID;

/**
 * {@link StringRedisTemplate} 测试类
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Slf4j
@SpringBootTest
class StringRedisTemplateTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void string() {
        String key = "string:key";
        String value = UUID.randomUUID().toString();
        log.info("key：{}，value：{}", key, value);
        stringRedisTemplate.opsForValue().set(key, value);
        String str = stringRedisTemplate.opsForValue().get(key);
        log.info("从Redis中获取 key：{} 的值是：{}", key, str);
    }

}
