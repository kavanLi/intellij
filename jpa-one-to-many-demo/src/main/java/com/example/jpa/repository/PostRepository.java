package com.example.jpa.repository;

import com.example.jpa.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * class description goes here.
 */
@Repository
public interface PostRepository extends JpaRepository <Post, Long> {
}
