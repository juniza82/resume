package com.juniza82.resume;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDateTime;
import java.util.TimeZone;

@Slf4j
@EnableJpaAuditing
@SpringBootApplication
public class ResumeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResumeApplication.class, args);
    }

    @PostConstruct
    public void started() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> log.info("Started at {}", LocalDateTime.now());
    }
}
