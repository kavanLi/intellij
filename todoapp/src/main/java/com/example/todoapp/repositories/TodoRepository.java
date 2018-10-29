package com.example.todoapp.repositories;

/**
 * class description goes here.
 */

import com.example.todoapp.models.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends MongoRepository <Todo, String> {

}
