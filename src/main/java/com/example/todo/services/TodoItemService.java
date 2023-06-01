package com.example.todo.services;

import com.example.todo.models.TodoItem;
import com.example.todo.repositories.TodoItemRepository;
import com.example.todo.requests.TodoItemRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoItemService {
    private final TodoItemRepository todoItemRepository;

    public TodoItemService(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    public List<TodoItem> getItems(){
        return todoItemRepository.findAll();
    }

    public TodoItem getItem(int id){
        return todoItemRepository.findById(id).orElseThrow();
    }

    public void addItem(TodoItemRequest todoItemRequest){
        TodoItem todoItem = new TodoItem();

        todoItem.setTitle(todoItemRequest.getTitle());
        todoItem.setDescription(todoItemRequest.getDescription());
        todoItem.setCreatedAt(todoItemRequest.getCreatedAt());

        todoItemRepository.save(todoItem);
    }

    public void updateItem(int id, TodoItemRequest todoItemRequest){
        TodoItem itemToUpdate = getItem(id);

        itemToUpdate.setTitle(todoItemRequest.getTitle());
        itemToUpdate.setDescription(todoItemRequest.getDescription());
        itemToUpdate.setCreatedAt(todoItemRequest.getCreatedAt());

        todoItemRepository.save(itemToUpdate);
    }

    public void deleteItem(int id){
        todoItemRepository.deleteById(id);
    }
}
