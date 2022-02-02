package com.project.passwordmanager.controllers.kevin;

import java.util.Objects;

public class frq3 {

    public String rsvpAttending(boolean rsvp) {
        return rsvp ? "attending" : "not attending";
    }

    public String foodSelection(int selection) {
        String food = "";
        switch(selection) {
            case 1:
                food = "beef";
                break;
            case 2:
                food = "chicken";
                break;
            case 3:
                food = "pasta";
                break;
        }
        return food;
    }

    public String rsvpMaker(boolean rsvp, int selection) {
        String message = "";
        if(rsvp) {
            String food = foodSelection(selection);
            message = "Thanks for attending. You will be served " + food + ".";
        } else {
            message = "Sorry you can't make it.";
        }
        return message;
    }

    public String stringMatch(String option1, String option2) {
        return (Objects.equals(option1, option2)) ? "true" : "false";
    }
}
