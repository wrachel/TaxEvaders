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

	public static void main(String[] args) {
		Book book1 = new Book("Frankenstein", "Mary Shelley");
		System.out.println(book1.printBookInfo());
	}
}