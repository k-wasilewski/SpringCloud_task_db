package com.springcloud.task_db.db.controllers;

import com.springcloud.task_db.db.entities.BookMessage;
import com.springcloud.task_db.db.entities.RatingMessage;
import com.springcloud.task_db.db.repositories.BookMessageRepository;
import com.springcloud.task_db.db.repositories.RatingMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class TaskController {
    @Autowired
    private BookMessageRepository bookMessageRepository;
    @Autowired
    private RatingMessageRepository ratingMessageRepository;

    @GetMapping("/books")
    public List<BookMessage> bookMessages() {
        return bookMessageRepository.findAll();
    }

    @GetMapping("/ratings")
    public List<RatingMessage> ratingMessages() {
        return ratingMessageRepository.findAll();
    }
}