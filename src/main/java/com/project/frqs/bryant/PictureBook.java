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
	
	/*
	book1 = Book("Frankenstein", "Mary Shelley");
	book2 = PictureBook("The Wonderful Wizard of Oz", "L. Frank Baum", "W.W. Denslow");
	*/
}