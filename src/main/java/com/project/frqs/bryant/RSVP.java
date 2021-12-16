package com.project.frqs.bryant;

public class RSVP {
    private String option1;
    private int selection;
    private boolean rsvp;

    public RSVP(boolean rsvp, int selection) { // constructor moment
        this.rsvp = rsvp;
        this.selection = selection;

        if (rsvp) {
            if (selection == 1) {
                this.option1 = "Thanks for attending. You will be served beef.";
            }
            else if (selection == 2) {
                this.option1 = "Thanks for attending. You will be served chicken.";
            }
            else if (selection == 3) {
                this.option1 = "Thanks for attending. You will be served pasta.";
            }
            else {
                this.option1 = "Thanks for attending. You will be served fish.";
            }
        }
        else {
            this.option1 = "Sorry you can't make it.";
        }
    }

    public String get_attendance() {
        return rsvp ? "attending": "not attending";
    }

    public String get_message() {
        return this.option1;
    }

    public String verify_value(String option2) {
        return String.valueOf(this.option1 == option2);
    }

    public static String[] get_result(boolean rsvp, int selection, String option2) {
        String[] finalArray = new String[2];

        RSVP event = new RSVP(rsvp, selection);
        finalArray[0] = event.get_attendance();
        finalArray[1] = event.get_message();
        finalArray[2] = event.verify_value(option2);
        return finalArray;
    }

    public static void main(String[] args) {
        RSVP event = new RSVP(true, 1);
        System.out.println(event.get_attendance());
        System.out.println(event.get_message());
        System.out.println(event.verify_value("beef"));
    }
}
