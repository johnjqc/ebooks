package com.jsoft.ebooksdirectory.model;

/**
*	Book model
*	@author JohnJQC
*/
class Book {
    String name;
    String year;
 
    Person(String name, String age) {
        this.name = name;
        this.age = age;
    }
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
}