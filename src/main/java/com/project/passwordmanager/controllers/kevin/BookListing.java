package com.project.passwordmanager.controllers.kevin;

import java.util.ArrayList;

public class BookListing{

    private Book book;
    private double price;

    public static void main(String[] args) {
        ArrayList<Book> myLibrary = new ArrayList<Book>();
        Book book1 = new Book("Frankenstein", "Mary Shelley");
        PictureBook book2 = new PictureBook("The Wonderful Wizard of Oz", "L. Frank Baum", "W.W. Denslow");
        myLibrary.add(book1);
        myLibrary.add(book2);

        BookListing listing1 = new BookListing(book1, 10.99);
        listing1.printDescription();
        BookListing listing2 = new BookListing(book2, 12.99);
        listing2.printDescription();
    }

    public BookListing(Book b, double price) {
        book = b;
        this.price = price;
    }

    //used to be void
    public String printDescription() {
        book.printBookInfo();
        System.out.println(", " + price);

        return book.printBookInfo() + ", $" + price;
    }

}
