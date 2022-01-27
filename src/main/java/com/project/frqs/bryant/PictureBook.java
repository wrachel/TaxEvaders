package com.project.frqs.bryant;

public class PictureBook extends Book {
	private String illustrator;
	
	public PictureBook(String t, String a, String i) {
		super(t, a);
		illustrator = i;
	}

	public String printBookInfo() {
		return super.printBookInfo() + " and illustrated by " + illustrator;
	}

	public static void main(String[] args) {
		Book book1 = new Book("Frankenstein", "Mary Shelley");
		Book book2 = new PictureBook("The Wonderful Wizard of Oz", "L. Frank Baum", "W.W. Denslow");
		System.out.println(book1.printBookInfo());
		System.out.println(book2.printBookInfo());
	}
}