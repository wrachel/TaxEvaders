package com.project.passwordmanager.controllers.kevin;

public class Book

{

    private String title;

    private String author;



    public Book(String t, String a)

    {

        title = t;

        author = a;

    }


// used to void
    public String printBookInfo()

    {

        System.out.print(title + ", written by " + author);

        return title + ", written by " + author;
    }

}