package com.project.passwordmanager.controllers.harry;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class hfrq8controller {
    @GetMapping("/harry/frq8")
    public String frq8 (){

        return "frqs/harryfrq8";
    }
}
