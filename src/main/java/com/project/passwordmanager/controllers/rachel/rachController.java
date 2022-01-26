package com.project.passwordmanager.controllers.rachel;

import com.project.frqs.rachel.rachel_Invitation;
import com.project.frqs.rachel.rachelfrq4;
import com.project.frqs.rachel.rachelfrq5q2;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;

import com.project.frqs.rachel.rachelfrq7;
import com.project.frqs.rachel.rachelfrq6;

@Controller
public class rachController {
    /*@GetMapping("/rachel/frq6")
    public String rachelfrq5(@RequestParam(name = "words", required = false, defaultValue = "ten, fading, post, card, thunder, hinge, trailing, batting") ArrayList<String> words, Model model) {
        rachelfrq6 ing = new rachelfrq6(words);
        model.addAttribute("returnStatement", (ing.returnvalue(words)));
        return "/frqs/rachel/rachelfrq6";
    }
     */

    @GetMapping("/rachel/frq6")
    public String rachelfrq6(){
        return "frqs/rachel/rachelfrq6";
    }

    @GetMapping("/rachel/frq7")
    public String rachelfrq7(@RequestParam(name="firstName", required = false, defaultValue = "Rachel")String firstName, @RequestParam(name="lastName", required = false, defaultValue = "Wei")String lastName, Model model){
        rachelfrq7 randomUsername = new rachelfrq7(firstName, lastName);
        model.addAttribute("username", randomUsername.randomUsername());
        return "frqs/rachel/rachelfrq7";
    }

}