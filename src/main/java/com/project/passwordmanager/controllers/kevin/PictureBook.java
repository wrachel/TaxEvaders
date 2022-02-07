package com.project.passwordmanager.controllers.kevin;

public class PictureBook extends Book {

    private String illustrator;

    public PictureBook(String t, String a, String i) {
        super(t, a);
        illustrator = i;
    }

    // used to be void
    @Override
    public String printBookInfo(){
        super.printBookInfo();
        System.out.print(" and illustrated by " + illustrator);

        return super.printBookInfo() + " and illustrated by " + illustrator;
    }

    public static void main(String[] args) {
        PictureBook myBook = new PictureBook("Peter and Wendy", "J.M. Barrie", "F.D. Bedford");
        myBook.printBookInfo();

    }
}
