package com.springcloud.task_db;

import com.springcloud.task_db.db.entities.BookMessage;
import com.springcloud.task_db.db.repositories.BookMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.task.listener.TaskExecutionListener;
import org.springframework.cloud.task.repository.TaskExecution;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class TaskListener implements TaskExecutionListener {
    @Autowired
    private BookMessageRepository bookMessageRepository;
    Logger logger = Logger.getLogger("logger");
    FileHandler fh;

    public void onTaskStartup(TaskExecution te) {
        try {
            fh = new FileHandler("/home/kuba/Desktop/projects/SpringCloud/task_db.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<BookMessage> bookMessageList = bookMessageRepository.findAll();
        FileWriter writer = null;
        try {
             writer = new FileWriter("/home/kuba/Desktop/projects/SpringCloud/book-service_history.txt");
            for(BookMessage bm: bookMessageList) {
                writer.write(bm + System.lineSeparator());
            }
            writer.close();
            logger.info("History successfully written to file");
        } catch (IOException ioe) {
            logger.info("IOException: cannot write to file");
        }
    }

    public void onTaskEnd(TaskExecution te) {
        logger.info("task end");
    }

    public void onTaskFailed(TaskExecution te, Throwable t) {
        logger.info("task failed");
    }

}
