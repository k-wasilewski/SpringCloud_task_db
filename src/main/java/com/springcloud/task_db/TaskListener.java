package com.springcloud.task_db;

import org.springframework.cloud.task.configuration.DefaultTaskConfigurer;
import org.springframework.cloud.task.listener.TaskExecutionListener;
import org.springframework.cloud.task.repository.TaskExecution;

import javax.sql.DataSource;

public class TaskListener implements TaskExecutionListener {

    public void onTaskStartup(TaskExecution te) {
        System.out.println("Task startup");
    }

    public void onTaskEnd(TaskExecution te) {
        System.out.println("Task end");
    }

    public void onTaskFailed(TaskExecution te, Throwable t) {
        System.out.println("Task failed");
    }

}
