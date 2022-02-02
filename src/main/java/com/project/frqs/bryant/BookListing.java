package com.project.frqs.bryant;

public class BookListing {	
	private Book book;
	private double price;
	
	public BookListing(Book book, double price) {
		this.book = book;
		this.price = price;
	}

	public String printDescription() {
		return String.format("%s, $%.2f", book.printBookInfo(), price);
	}

	public static void main(String[] args) {
		Book book1 = new Book("Frankenstein", "Mary Shelley");
		BookListing listing1 = new BookListing(book1, 12.50);
		System.out.println(listing1.printDescription());
	}
}