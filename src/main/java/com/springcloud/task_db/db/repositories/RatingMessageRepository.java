package com.springcloud.task_db.db.repositories;

import com.springcloud.task_db.db.entities.RatingMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingMessageRepository extends JpaRepository<RatingMessage, Long> {
}