package com.example.todo.controllers;

import com.example.todo.models.TodoItem;
import com.example.todo.requests.TodoItemRequest;
import com.example.todo.services.TodoItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TodoItemController {
    private final TodoItemService todoItemService;

    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    @GetMapping
    public List<TodoItem> getTodos(){
        return todoItemService.getItems();
    }

    @PostMapping
    public String addTodo(@RequestBody TodoItemRequest todoItemRequest){
        todoItemService.addItem(todoItemRequest);
        return "You added new task to the list successfully";
    }

    @PutMapping("/{id}")
    public String updateTodo(@PathVariable("id") Integer id, @RequestBody TodoItemRequest todoItemRequest){
        todoItemService.updateItem(id, todoItemRequest);
        return "You updated task successfully";
    }

    @DeleteMapping("/{todoID}")
    public String deleteTodo(@PathVariable("todoID") Integer id){
        todoItemService.deleteItem(id);
        return "You deleted task from the list successfully";
    }
}
