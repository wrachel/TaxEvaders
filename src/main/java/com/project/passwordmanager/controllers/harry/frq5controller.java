package com.project.passwordmanager.controllers.harry;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
public class frq5controller {
    @GetMapping("/harry/frq5a")
    public String frq5q1(){

        return "frqs/harryfrq5";
    }
    @GetMapping("/harry/frq5b")
    public String frq5q2(){

        return "frqs/harryfrq5";
    }
}
