package com.project.passwordmanager.controllers.harry;

public class PictureBook extends Book {
    private String illustrator;

    public PictureBook(String title, String author, String illustrator) {
        super(title, author);
        this.illustrator = illustrator;
    }
    public String printBookInfo(){

        return super.printBookInfo() + " and illustrated by " + illustrator;
    }

}
