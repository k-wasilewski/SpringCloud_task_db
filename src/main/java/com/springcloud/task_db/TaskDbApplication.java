package com.springcloud.task_db;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.configuration.annotation.BatchConfigurer;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.BatchAutoConfiguration;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@SpringBootApplication(exclude = BatchAutoConfiguration.class)
@EnableTask
@EnableBatchProcessing
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
