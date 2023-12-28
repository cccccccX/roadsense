package com.roadsense;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@MapperScan(basePackages = "com.roadsense.mapper")
@SpringBootApplication
@EnableTransactionManagement
public class Application{
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
