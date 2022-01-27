package com.project.frqs.rachel.frq9;
import java.util.ArrayList;

public class RachelPictureBook extends rachelBook{
    private String illustrator;

    public RachelPictureBook(String t, String a, String i) {
        super(t, a);
        illustrator = i;
    }

    public void printBookInfo(){
        super.printBookInfo();
        System.out.println("and illustrated by " + illustrator);
    }

    public String toString(){
        String str = super.toString();
        str += "and illustrated by " + illustrator;
        return str;
    }

    /*
    public static void main(String[] args){
        rachelBook book1 = new rachelBook("Frankenstein", "Mary Shelley");
        RachelPictureBook book2 = new RachelPictureBook("The Wonderful Wizard of Oz", "L. Frank Baum", "W.W. Denslow");
        ArrayList<rachelBook> myLibrary = new ArrayList<rachelBook>();
        myLibrary.add(book1);
        myLibrary.add(book2);

        for(rachelBook str : myLibrary){
            System.out.println(str);
        }

    }
     */
}
