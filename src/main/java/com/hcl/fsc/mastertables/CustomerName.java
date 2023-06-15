package com.hcl.fsc.mastertables;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="customer_name_master")
public class CustomerName {
	
	@Id
	private Integer uid;
	
	private String customerName;
	
	private LocalDateTime createdDate;
	
	private LocalDateTime updatedDate;
}
