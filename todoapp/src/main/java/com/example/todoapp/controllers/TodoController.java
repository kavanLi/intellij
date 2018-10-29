/******************************************************************************
 *                         Libra FRAMEWORK
 *            Libra framework, (2018). All rights reserved.
 *
 *  All rights are reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright owner.
 *****************************************************************************/
package com.example.todoapp.controllers;

import javax.validation.Valid;

import com.example.todoapp.models.Todo;
import com.example.todoapp.repositories.TodoRepository;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * class description goes here.
 */

/**
 * The @CrossOrigin annotation in the above controller is used to enable Cross-Origin requests.
 * This is required because we’ll be accessing the apis from angular’s frontend server.
 */
@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class TodoController {

    /* fields -------------------------------------------------------------- */

    @Autowired
    TodoRepository todoRepository;

    /* constructors -------------------------------------------------------- */

    /* public methods ------------------------------------------------------ */

    @ApiOperation(value = "获取所有备忘录", notes = "可以获取所有备忘录")
    @GetMapping("/todos")
    public List <Todo> getAllTodos() {
        Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "createdAt");
        return todoRepository.findAll(sortByCreatedAtDesc);
    }

    @ApiOperation(value = "创建备忘录", notes = "根据todo对象创建备忘录")
    @ApiImplicitParam(name = "todo", value = "备忘录详细实体todo", required = true, dataType = "Todo")
    @PostMapping("/todos")
    public Todo createTodo(@Valid @RequestBody Todo todo) {
        todo.setCompleted(false);
        return todoRepository.save(todo);
    }

    @ApiOperation(value = "获取指定备忘录", notes = "可以获取指定备忘录")
    @GetMapping(value = "/todos/{id}")
    public ResponseEntity <Todo> getTodoById(@PathVariable("id") String id) {
        Todo todo = todoRepository.findOne(id);
        if (todo == null) {
            return new ResponseEntity <>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity <>(todo, HttpStatus.OK);
        }
    }

    @ApiOperation(value = "更新指定备忘录详细信息", notes = "根据url的id来指定更新对象，并根据传过来的todo信息来更新备忘录详细信息")
    @PutMapping(value = "/todos/{id}")
    public ResponseEntity <Todo> updateTodo(@PathVariable("id") String id,
                                            @Valid @RequestBody Todo todo) {
        Todo todoData = todoRepository.findOne(id);
        if (todoData == null) {
            return new ResponseEntity <>(HttpStatus.NOT_FOUND);
        }
        todoData.setTitle(todo.getTitle());
        todoData.setCompleted(todo.getCompleted());
        Todo updatedTodo = todoRepository.save(todoData);
        return new ResponseEntity <>(updatedTodo, HttpStatus.OK);
    }

    @ApiOperation(value = "删除指定备忘录", notes = "根据url的id来指定删除备忘录")
    @DeleteMapping(value = "/todos/{id}")
    public void deleteTodo(@PathVariable("id") String id) {
        todoRepository.delete(id);
    }

    /* private methods ----------------------------------------------------- */

    /* getters/setters ----------------------------------------------------- */

}