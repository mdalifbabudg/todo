package com.example.todo;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    
    @Autowired private TodoRepository todoRepository;

    //Create Todo
    public TodoModel createTodo(TodoModel todo){
        todo.setDate(Instant.now());
        return todoRepository.save(todo);
    }

    //Retrive data
    public TodoModel findTodo(Long id){
        return todoRepository.findById(id).orElse(null);
    }

    public List<TodoModel> findTodos(){
        return todoRepository.findAll();
    }

    //Update data
    public TodoModel updateTodo(Long id, TodoModel todo){
        TodoModel exTodo = todoRepository.findById(id).orElse(null);

        if(exTodo == null)return null;

        if(exTodo.getWork() != todo.getWork()){
            exTodo.setWork(todo.getWork());
        }
        if(exTodo.getFood() != todo.getFood()){
            exTodo.setFood(todo.getFood());
        }
        if(exTodo.getTravel() != todo.getTravel()){
            exTodo.setTravel(todo.getTravel());
        }

        exTodo.setDate(Instant.now());

        return todoRepository.save(exTodo);
    }

    //Delete data
    public String deleteTodo(Long id){
        todoRepository.deleteById(id);
        return "Deleted!";
    }

    public String deleteTodos(){
        todoRepository.deleteAll();
        return "Deleted All!";
    }
}
