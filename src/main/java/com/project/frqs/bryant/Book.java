package com.project.frqs.bryant;

public class Book {
	private String title;
	private String author; 

	public Book(String t, String a) {
		title = t;
		author = a;
	}

	public String printBookInfo() {
		return title + ", written by " + author;
	}
}