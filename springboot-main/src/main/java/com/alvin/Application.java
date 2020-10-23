package com.alvin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.alvin.dao.mapper")
public class Application implements CommandLineRunner {
    public static void main(String[] args) {
        //日志异步
        System.setProperty("Log4jContextSelector", "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
        SpringApplication.run(Application.class, args);
    }



    @Override
    public void run(String... args) throws Exception {
        System.out.println("启动成功");
    }
}
