package com.project.passwordmanager.controllers.rachel;

import com.project.frqs.rachel.rachelfrq3;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
    public class rachelController extends rachelfrq3 {
    @GetMapping("/rachel/frq3")
    public String rachelfrq3(@RequestParam(name = "rsvp", required = false, defaultValue = "false") boolean rsvp, @RequestParam(name = "selection", required = false, defaultValue = "1") int selection, @RequestParam(name = "option1", required = false, defaultValue = "dog") String option1, @RequestParam(name = "option2", required = false, defaultValue = "dog") String option2, Model frq3model) {
        frq3model.addAttribute("rsvp", returnrsvp(rsvp));
        frq3model.addAttribute("food", printfood(selection));
        frq3model.addAttribute("message", rsvpfood(rsvp, selection));
        frq3model.addAttribute("stringMatch", checkString(option1, option2));

        return "frontend/frqs/rachelfrq3";
    }

/*
    public Object checkString(String option1, String option2) {
        if (option1.equals(option2)) {
            return "true";
        } else {
            return "false";
        }
    }

    public Object rsvpfood(boolean rsvp, int selection) {
        String note = "";
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

    public Object printfood(int selection) {
        String[] food = {"fish", "beef", "chicken", "pasta", "fish"};
        if (selection < 4) {
            return food[selection];
        } else {
            return "fish";
        }
    }

    public Object returnrsvp(boolean rsvp) {
        if (rsvp = true) {
            return "attending";
        } else {
            return "not attending";
        }
    }

 */

}
