package com.example.todo_api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo_api.dto.TodoResponse;
import com.example.todo_api.dto.TodoWithoutId;
import com.example.todo_api.entity.Todo;
import com.example.todo_api.mapper.TodoMapper;

@Service
public class TodoService {
	
	@Autowired
	TodoMapper todoMapper;
	
//	entityで取得してきたリストをResponseへコピーしてリストで返却
	public List<TodoResponse> getTodos(){
		List<TodoResponse> todoResponseList = new ArrayList<>();
		List<Todo> todoList = todoMapper.findAll();
		
		todoList.forEach(todo -> {
			TodoResponse todoResponse = new TodoResponse();
			BeanUtils.copyProperties(todo, todoResponse);
			todoResponseList.add(todoResponse);
		});
		
		return todoResponseList;
	}
	
	public void addTodo(TodoWithoutId todoWithoutId) {
		Todo todo = new Todo();
		BeanUtils.copyProperties(todoWithoutId, todo);
		
		todoMapper.insert(todo);	
	
	}
	
	public TodoResponse getTodo(Integer id) {
		Todo todo = todoMapper.findById(id);
		
		TodoResponse todoResponse = new TodoResponse();
		
		BeanUtils.copyProperties(todo, todoResponse);
		
		return todoResponse;
	
	}
	
	public void deleteTodo(Integer id) {
		boolean b = todoMapper.delete(id);
	}
	
	public void putTodo(Integer id, TodoWithoutId todoWithoutId) {
		Todo todo = new Todo();
		BeanUtils.copyProperties(todoWithoutId, todo);
		todo.setId(id);
		int ret = todoMapper.update(todo);
	}
}
