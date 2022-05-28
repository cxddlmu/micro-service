package com.lovnx.config;


import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class SpringAsyncConfig implements AsyncConfigurer {

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.initialize();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(25);
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new AsyncUncaughtExceptionHandler() {
            @Override
            public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {
                    System.out.println("Exception message - " + throwable.getMessage());
                    System.out.println("Method name - " + method.getName());
                    for (Object param : objects) {
                        System.out.println("Parameter value - " + param);
                    }
            }
        };
    }

    @Async("threadPoolTaskExecutor")
    public void asyncMethodWithConfiguredExecutor() throws InterruptedException {
        System.out.println("Execute method with configured executor - "
                                   + Thread.currentThread().getName());
        Thread.currentThread().wait(6000);
    }

}




