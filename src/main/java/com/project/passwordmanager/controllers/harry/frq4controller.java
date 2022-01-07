package com.project.passwordmanager.controllers.harry;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class frq4controller extends frq4 {

    @GetMapping("/harry/frq4a")
    public String frq4q1(@RequestParam(name = "String", required = false, defaultValue = " ") String input, Model model) throws IOException, InterruptedException {

            String a = longestStreak(input);
            model.addAttribute("a", a);


        return "frqs/harryfrq4";
    }

    @GetMapping("/harry/frq4b")
    public String frq4q2(@RequestParam(name = "rounds", required = false, defaultValue = "5") int round,
                         @RequestParam(name = "coin", required = false, defaultValue = "10") int coin, Model model) throws IOException, InterruptedException{

        String b = playGame(round, coin);
        model.addAttribute("b", b);
        model.addAttribute("round", round);

        return "frqs/harryfrq4b";
    }

    @GetMapping("/harry/frq4code")
    public String code(){
        return "frqs/frq4code";
    }
}
