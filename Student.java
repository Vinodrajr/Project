package com.hibernate.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Student {
	@Id
	private int rollno;
	private String name;
	private String phno;
	private String standrad;
}
