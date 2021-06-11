package com.to;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "subject")
public class Subject {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	@OneToOne
	private Class level;
	
    @ManyToOne
    @JoinColumn(nullable = false)
    private Teacher teacher;

	
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Subject(String name, Class level) {
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

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

//	@Override
//	public String toString() {
//		return "Subject [id=" + id + ", name=" + name + ", level=" + level + ", teacher=" + teacher + "]";
//	}
	
	
}
