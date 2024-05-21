package com.example.todo_api.dto;

import lombok.Data;

@Data
public class TodoResponse {
	private Integer id;
	private String title;
	private String status;
	private String details;
}
