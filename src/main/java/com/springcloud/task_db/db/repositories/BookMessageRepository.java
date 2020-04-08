package com.springcloud.task_db.db.repositories;

import com.springcloud.task_db.db.entities.BookMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookMessageRepository extends JpaRepository<BookMessage, Long> {
}