package com.to;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@OneToOne
	private Class level;
	public Student() {
		super();

	}
	public Student(String name, Class level) {
		super();
		this.name = name;
		this.level = level;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Class getLevel() {
		return level;
	}

	public void setLevel(Class level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", level=" + level + "]";
	}


}
