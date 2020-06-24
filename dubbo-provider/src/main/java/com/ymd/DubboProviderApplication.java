package com.ymd;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.CountDownLatch;

@Slf4j
@SpringBootApplication
@MapperScan("com.ymd.mybatis.mapper")
public class DubboProviderApplication implements CommandLineRunner {


    @Bean
    public CountDownLatch countDownLatch() {
        return new CountDownLatch(1);
    }

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext ctx = new SpringApplicationBuilder(DubboProviderApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CountDownLatch countDownLatch = ctx.getBean(CountDownLatch.class);
        countDownLatch.await();
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Dubbo Provider start now.................");
    }
}
