package com.jsoft.ebooksdirectory.model;

import java.util.Map;

/**
*	Book model
*	@author JohnJQC
*/
public class Book {
    String name;
    Long year;
	String author;
	Map<String, Boolean> categories;
	String editorial;
	String language;

	Book(){}

	Book(String name, Long year) {
        this.name = name;
        this.year = year;
    }
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getYear() {
		return year;
	}
	public void setYear(Long year) {
		this.year = year;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Map<String, Boolean> getCategories() {
		return categories;
	}

	public void setCategories(Map<String, Boolean> categories) {
		this.categories = categories;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
}