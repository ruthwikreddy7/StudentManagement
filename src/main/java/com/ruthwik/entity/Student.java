package com.ruthwik.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student_table")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rollno;
	private String name;
	private Integer classnumber;
	private String section;
	private Float percentage;
	public Integer getRollno() {
		return rollno;
	}
	
	public Student() {
		
	}
	public Student(String name, Integer classnumber, String section, Float percentage) {
		super();
		this.name = name;
		this.classnumber = classnumber;
		this.section = section;
		this.percentage = percentage;
	}


	public void setRollno(Integer rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getClassnumber() {
		return classnumber;
	}
	public void setClassnumber(Integer classnumber) {
		this.classnumber = classnumber;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public Float getPercentage() {
		return percentage;
	}
	public void setPercentage(Float percentage) {
		this.percentage = percentage;
	}

	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", classnumber=" + classnumber + ", section=" + section
				+ ", percentage=" + percentage + "]";
	}
	
    
}
