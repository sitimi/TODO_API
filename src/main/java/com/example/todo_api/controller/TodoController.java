package com.example.todo_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo_api.dto.TodoResponse;
import com.example.todo_api.dto.TodoWithoutId;
import com.example.todo_api.service.TodoService;


@RestController
@RequestMapping("/todos")
public class TodoController {

	@Autowired
	public TodoService todoService;

	//	一覧表示
	@GetMapping
	public List<TodoResponse> getTodos() {
		return todoService.getTodos();
	}

	//	一件登録
	@PostMapping
	public void addTodo(@RequestBody TodoWithoutId todoWithoutId) {
		todoService.addTodo(todoWithoutId);
	}

	//	個別詳細取得
	@GetMapping("/{id}")
	public TodoResponse getTodo(@PathVariable Integer id) {
		return todoService.getTodo(id);
	}
	
//	一件削除
	@DeleteMapping("/{id}")
	public void deleteTodo(@PathVariable Integer id) {
		todoService.deleteTodo(id);
	}

//	一件変更
	@PutMapping("/{id}")
	public  void putTodo(@PathVariable Integer id, @RequestBody TodoWithoutId todoWithoutId) {
		todoService.putTodo(id, todoWithoutId);
	}
}
