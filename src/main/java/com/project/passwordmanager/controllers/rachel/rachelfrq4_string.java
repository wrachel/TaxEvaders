package com.project.passwordmanager.controllers.rachel;

import com.project.frqs.rachel.rachelfrq4;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class rachelfrq4_string {
    @GetMapping("/rachel/frq4/question1")
    public String rachelfrq4(@RequestParam(name="str", required = false, defaultValue = "CCAAAAATTT!")String str, Model rachelfrq4model){
        rachelfrq4model.addAttribute("longestchar", rachelfrq4.returnchar(str));
        return "frqs/rachelfrq4";
    }
}
