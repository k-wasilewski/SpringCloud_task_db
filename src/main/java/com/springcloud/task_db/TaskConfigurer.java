package com.springcloud.task_db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.DefaultTaskConfigurer;
import org.springframework.cloud.task.configuration.EnableTask;

import javax.sql.DataSource;

public class TaskConfigurer extends DefaultTaskConfigurer {

    public TaskConfigurer(DataSource dataSource){
        super(dataSource);
    }

}
