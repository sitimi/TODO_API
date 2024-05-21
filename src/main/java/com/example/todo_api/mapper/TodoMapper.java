package com.example.todo_api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.todo_api.entity.Todo;

@Mapper
public interface TodoMapper {
	Todo findById(int id);
	List<Todo> findAll();
	int insert(@Param("todo") Todo todo);
	int update(Todo todo);
	boolean delete(int id);

}
