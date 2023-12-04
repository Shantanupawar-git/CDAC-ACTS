package com.app.dto;


import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ToString
@Setter
@Getter
public class StudentDTO{
	
	@JsonProperty(access=Access.READ_ONLY)
	private Long id;
	private String rollno; 
	private String StudentFirstName; 
	private String StudentLastName; 
	private String City;
	private String CourseName;
	private LocalDate DoB;
}
