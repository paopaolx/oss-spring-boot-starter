package com.example.testoss;

import com.kyrielx.oss.service.OssTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 测试项目：测试对自定义oss-spring-boot-starter的使用
 * @author kyrielx
 * @date 2023/4/7 11:53
 */
@SpringBootTest(classes = Application.class)
public class TestOssApplication {

    // 注入ossTemplate的bean
    @Autowired
    private OssTemplate ossTemplate;

    @Test
    void test1(){
        ossTemplate.createBucket("oss02");
    }
}
