package com.project.frqs.rachel.frq9;

import com.project.frqs.bryant.Book;

public class rachelBookListing extends rachelBook{
    private Double price;
    private rachelBook book;

    public rachelBookListing(String t, String a, Double p){
        super(t, a);
        price = p;
    }

    public void printDescription(){
        super.printBookInfo();
        System.out.println("$" + price);
    }

    public String toString(){
        String str = super.toString();
        str += ", $" + price;
        return str;
    }

    /*
    public static void main(String[] args){
        rachelBookListing listing1 = new rachelBookListing("Frankenstein", "Mary Shelley", 10.99);
        System.out.println(listing1);
    }

     */

}
