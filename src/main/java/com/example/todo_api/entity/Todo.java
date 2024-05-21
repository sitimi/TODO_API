package com.example.todo_api.entity;

import lombok.Data;

@Data
public class Todo {
	private Integer id;
	private String title;
	private String status;
	private String details;
}
