package com.springcloud.task_db;

import com.springcloud.task_db.db.entities.BookMessage;
import com.springcloud.task_db.db.repositories.BookMessageRepository;
import com.springcloud.task_db.db.repositories.RatingMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.task.configuration.DefaultTaskConfigurer;
import org.springframework.cloud.task.listener.TaskExecutionListener;
import org.springframework.cloud.task.repository.TaskExecution;

import javax.sql.DataSource;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TaskListener implements TaskExecutionListener {
    @Autowired
    private BookMessageRepository bookMessageRepository;

    public void onTaskStartup(TaskExecution te) {
        List<BookMessage> bookMessageList = bookMessageRepository.findAll();
        FileWriter writer = null;
        try {
             writer = new FileWriter("/home/kuba/Pulpit/projekty/SpringCloud/book-service_history.txt");
            for(BookMessage bm: bookMessageList) {
                writer.write(bm + System.lineSeparator());
            }
            writer.close();
        } catch (IOException ioe) {
            System.out.println("Cannot write to file");
        }
    }

    public void onTaskEnd(TaskExecution te) {
        System.out.println("Task end");
    }

    public void onTaskFailed(TaskExecution te, Throwable t) {
        System.out.println("Task failed");
    }

}
