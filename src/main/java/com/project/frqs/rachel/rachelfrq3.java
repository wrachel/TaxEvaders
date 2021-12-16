package com.project.frqs.rachel;
import java.util.Objects;

public class rachelfrq3 {

    public String returnrsvp (boolean rsvp){
        if (rsvp = true){
            return "attending";
        }
        else {
            return "not attending";
        }
    }

    public String printfood(int selection){
        String[] food = {"fish", "beef", "chicken", "pasta", "fish"};
        if (selection < 4){
            return food[selection];
        }
        else {
            return "fish";
        }
    }

    public String rsvpfood(boolean rsvp, int selection) {
        String note="";
        if (rsvp = true) {
            if (selection == 1) {
                note = "Thanks for attending. You will be served beef.";
            } else if (selection == 2) {
                note = "Thanks for attending. You will be served chicken.";
            } else if (selection == 3) {
                note = "Thanks for attending. You will be served pasta.";
            } else {
                note = "Thanks for attending. You will be served fish.";
            }
        }
        if (rsvp = false) {
            note = "Sorry you can't make it.";
        }
        return note;
    }

    public String checkString(String option1, String option2){
        if(option1.equals(option2)){
            return "true";
        }
        else{
            return "false";
        }
    }


}

