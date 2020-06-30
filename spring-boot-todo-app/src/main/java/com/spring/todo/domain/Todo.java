package com.spring.todo.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long id;
	public String todoItem;
	public String completed;
	
	public Todo() {
		
	}
	
	public Todo(String todoItem, String completed) {
		super();
		this.todoItem = todoItem;
		this.completed = completed;
	}

	
	
}
