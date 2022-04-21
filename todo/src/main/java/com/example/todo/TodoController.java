package com.example.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/todo")
public class TodoController {
    
    @Autowired TodoService todoService;


    //Data save in database
    @PostMapping("/")
    public @ResponseBody ResponseEntity<TodoModel> saveTodo(@RequestBody TodoModel todo){
        try {
            return new ResponseEntity<>(todoService.createTodo(todo), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    //Data get from database
    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<TodoModel> getTodo(@PathVariable Long id){
        try {
            return new ResponseEntity<>(todoService.findTodo(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/")
    public @ResponseBody ResponseEntity<List<TodoModel>> getTodos(){
        try {
            return new ResponseEntity<>(todoService.findTodos(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Update data on database
    @PutMapping("/{id}")
    public @ResponseBody ResponseEntity<TodoModel> changeTodo(@PathVariable Long id, @RequestBody TodoModel todo){
        try {
            return new ResponseEntity<>(todoService.updateTodo(id, todo), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Delete data from database
    @DeleteMapping("/{id}")
    public @ResponseBody ResponseEntity<String> removeTodo(@PathVariable Long id){
        try {
            return new ResponseEntity<>(todoService.deleteTodo(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/")
    public @ResponseBody ResponseEntity<String> removeTodos(){
        try {
            return new ResponseEntity<>(todoService.deleteTodos(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
