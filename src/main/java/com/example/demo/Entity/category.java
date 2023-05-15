package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class category {
	
	@Id
	@Column(name="userId")
	long userId;
	
	@Column(name = "category")
	private String category;
	
	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public String  getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
