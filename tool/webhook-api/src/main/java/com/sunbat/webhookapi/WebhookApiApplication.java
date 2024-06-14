package com.sunbat.webhookapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * webhook模拟器
 *
 * @author: SunYb
 * @date: 2024/6/5 17:39
 * @version: 1.0
 */
@SpringBootApplication
@EnableScheduling
public class WebhookApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebhookApiApplication.class, args);
    }

}
