package com.springcloud.task_db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@SpringBootApplication
@EnableTask
public class TaskDbApplication {
    @Autowired
    private DataSource dataSource;

    public static void main(String[] args) {SpringApplication.run(TaskDbApplication.class, args);}

    @Bean
    public TaskConfigurer getTaskConfigurer() {
        return new TaskConfigurer(dataSource);
    }

    @Bean
    public TaskListener taskListener() {
        return new TaskListener();
    }

    @Component
    public static class TaskDbApplicationRunner
            implements ApplicationRunner {

        @Override
        public void run(ApplicationArguments arg0) throws Exception {
            System.out.println("Hello World from Spring Cloud Task!");
        }
    }

}
