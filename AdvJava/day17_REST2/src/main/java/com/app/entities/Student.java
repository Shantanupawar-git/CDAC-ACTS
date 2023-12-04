package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class Student extends BaseEntity {
	private String rollno; 
	private String StudentFirstName; 
	private String StudentLastName; 
	private String City;
	private String CourseName;
	private LocalDate DoB;
}
