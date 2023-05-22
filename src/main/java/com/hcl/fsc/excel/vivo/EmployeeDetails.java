package com.hcl.fsc.excel.vivo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hcl.fsc.mastertables.Gender;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class EmployeeDetails {
   	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;
	private Integer sapId;
	private String name;
	
	@OneToOne
	private Gender gender;
	private String email;
	private Long contactNo;
	private Long alternateContactNo;
	private String address;
	private String state;	
	private String region;
	
	
}
