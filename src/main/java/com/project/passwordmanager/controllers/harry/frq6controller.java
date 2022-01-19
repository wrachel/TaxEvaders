package com.project.passwordmanager.controllers.harry;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class frq6controller {
    @GetMapping("/harry/frq6a")
    public String frq6a() {

        return "frqs/harryfrq6a";
    }
    @GetMapping("/harry/frq6b")
    public String frq6b(){

        return "frqs/harryfrq6b";
    }
}
