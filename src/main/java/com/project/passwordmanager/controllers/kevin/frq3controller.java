package com.project.passwordmanager.controllers.kevin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class frq3controller extends frq3{

    @GetMapping("/kevin/unit3")
    public String displayFRQ() {
        return "frontend/kevin/unit3";
    }

    @GetMapping("/kevin/unit3/interactive")
    public String displayFRQInteractive(Model model,
                                        @RequestParam(name = "rsvp", required = false, defaultValue = "false") boolean rsvp,
                                        @RequestParam(name = "selection", required = false, defaultValue = "1") int selection,
                                        @RequestParam(name = "option1", required = false, defaultValue = "taco") String option1,
                                        @RequestParam(name = "option2", required = false, defaultValue = "taco") String option2
    ) {
        model.addAttribute("rsvp", rsvpAttending(rsvp));
        model.addAttribute("selection", foodSelection(selection));
        model.addAttribute("rsvpMsg", rsvpMaker(rsvp, selection));
        model.addAttribute("stringMatch", stringMatch(option1, option2));

        return "frontend/kevin/unit3interactive";
    }
}