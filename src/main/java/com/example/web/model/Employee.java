package com.example.web.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "web")
public class Employee {
    
	
	private int userId;
	
	private int id;
	
	private String title;
	
	private String body;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
    

}
