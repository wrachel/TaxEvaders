package com.project.passwordmanager.controllers.harry;

public class BookListing{
    private String book;
    private double price;
    public BookListing(String book, double price){
        this.book = book;
        this.price = price;
    }
    public String printDescription(){
        return book + ", $"+price;
    }
}
