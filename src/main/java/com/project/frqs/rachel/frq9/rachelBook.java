package com.project.frqs.rachel.frq9;

public class rachelBook {

    private String title;
    private String author;

    public rachelBook(String t, String a) {
        title = t;
        author = a;
    }

    public void printBookInfo() {
        System.out.print(title + ", written by " + author);
    }

    public String toString(){
        String str = title + ", written by " + author;
        return str;
    }
}
