package com.example.jpa.repository;

import com.example.jpa.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * class description goes here.
 */
@Repository
public interface CommentRepository extends JpaRepository <Comment, Long> {
}
