package com.to;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "class")
public class Class {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;

private String name;


public Class() {
	super();

}

public Class(String name) {
	super();
	this.name = name;
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



@Override
public String toString() {
	return "Class [id=" + id + ", name=" + name + "]";
}

}
