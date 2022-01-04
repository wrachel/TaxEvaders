package com.project.frqs.harry;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class frq4controller {

    @GetMapping("/harry/frq4a")
    public String frq4q1() throws IOException {
        return "frontend/frqs/harryfrq4";
    }

    @GetMapping("/harry/frq4b")
    public String frq4q2() throws IOException{
        return "frontend/frqs/harryfrq4b";
    }
}
