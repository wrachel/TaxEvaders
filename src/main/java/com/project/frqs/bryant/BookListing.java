package com.project.frqs.bryant;

public class BookListing {	
	private Book book;
	private double price;
	
	public BookListing(Book book, double price) {
		this.book = book;
		this.price = price;
	}

	public String printDescription() {
		return book.printBookInfo() + ", $" + price;
	}
}