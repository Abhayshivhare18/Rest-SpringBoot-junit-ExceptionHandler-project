package com.thinkconstructive.restdemo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@EnableAsync
@Configuration
public class AsyncConfiguration {


    @Bean(name = "asyncTaskExecutor")
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor task =new ThreadPoolTaskExecutor();
        task.setCorePoolSize(10);
        task.setQueueCapacity(10);
        task.setMaxPoolSize(10);
        task.setThreadNamePrefix("AsyncTaskThread-");
        task.initialize();
        return  task;
    }
}
