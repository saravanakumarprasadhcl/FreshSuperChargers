package com.hcl.elch.freshersuperchargers.trainingworkflow.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name="category")
public class Category {
	
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
