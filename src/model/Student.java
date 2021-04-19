package model;

import java.io.Serializable;

public class Student implements Serializable{
	private String name;
	private String id;
	private String year;
	private String gender;
	
	public Student(String name, String id, String year, String gender) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.id = id;
		this.year = year;
		this.gender = gender;
	}
	
	public Student() {
		this("","","","");
	}
	
	public String getName() {
		return this.name;		
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getYear() {
		return this.year;		
	}
	
	public String getGender() {
		return this.gender;
	}
	
}
