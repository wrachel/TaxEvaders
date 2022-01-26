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
	
	/*
	book1 = Book("Frankenstein", "Mary Shelley");
	book2 = PictureBook("The Wonderful Wizard of Oz", "L. Frank Baum", "W.W. Denslow");
	*/
}