package com.example.demo.model;

public class Person {

	private int id;
	private String name;
	private int phone;
	
	public Person() {}
	public Person(int id, String name, int phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
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
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}

}
