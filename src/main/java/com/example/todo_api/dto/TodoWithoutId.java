package com.example.todo_api.dto;

import lombok.Data;

@Data
public class TodoWithoutId {
	private String title;
	private String status;
	private String details;
}
