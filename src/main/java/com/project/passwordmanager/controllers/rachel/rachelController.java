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

        return "frqs/rachelfrq3";
    }


}
