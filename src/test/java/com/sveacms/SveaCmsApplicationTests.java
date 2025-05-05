package com.sveacms;

import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

@SpringBootTest
class sveaCMSApplicationTests {

    @DynamicPropertySource
    static void overrideProps(DynamicPropertyRegistry registry) {
        Dotenv dotenv = Dotenv.load();

        registry.add("spring.datasource.url", () -> dotenv.get("DB_URL"));
        registry.add("spring.datasource.username", () -> dotenv.get("DB_USERNAME"));
        registry.add("spring.datasource.password", () -> dotenv.get("DB_PASSWORD"));
    }

    @Test
    void contextLoads() {
    }
}
