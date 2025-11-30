package com.example;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class TestBean {

	private String name;
	private String message;

	public TestBean() {
	}

	@PostConstruct
	public void init() {
		this.name = "placeholder";
		this.message = "placeholder";
	}

	public void sayHello() {
		if (name == null || name.isBlank()) {
			setMessage("Please enter a name.");
		} else {
			setMessage("Hello, " + name + "!");
		}
	}

	// Getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}