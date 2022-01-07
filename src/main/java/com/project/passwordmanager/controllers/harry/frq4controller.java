package com.project.passwordmanager.controllers.harry;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class frq4controller extends frq4 {

    @GetMapping("/harry/frq4a")
    public String frq4q1(@RequestParam(name = "String", required = false, defaultValue = "aaaabb") String input, Model model) throws IOException, InterruptedException {
      String a = longestStreak(input);

      model.addAttribute("a", a);

        return "frqs/harryfrq4";
    }

    @GetMapping("/harry/frq4b")
    public String frq4q2() throws IOException{

        return "frqs/harryfrq4b";
    }
}
