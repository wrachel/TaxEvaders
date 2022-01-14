package com.project.passwordmanager.controllers.harry;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class Hfrq5controller{ //extends frq5
    @GetMapping("/harry/frq5a")
    public String frq5q1(@RequestParam(name = "host", required = false, defaultValue = "karen") String host,
                         @RequestParam(name = "add", required = false, defaultValue = "ad") String add,
                         @RequestParam(name = "inv", required = false, defaultValue = "Cheryl") String inv,
                         @RequestParam(name = "new", required = false, defaultValue = "address") String newadd ,Model model) throws IOException{

        frq5 myinvite= new question1();
        String c= myinvite.invite(host, add, inv);
        //String c=invite(host,add,inv );

        model.addAttribute("b", add);
        model.addAttribute("a", host);
        model.addAttribute("c",c);
        model.addAttribute("d", newadd);

        return "frqs/harryfrq5";
    }
    @GetMapping("/harry/frq5b")
    public String frq5q2(){

        return "frqs/harryfrq5b";
    }
    @RequestMapping(value="/generate.htm", method = RequestMethod.GET)
    public String handle(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException{
    //  frq5 mypwd = new PasswordGenerator();

        model.addAttribute("a", "good");

        return "frqs/harryfrq5b";
    }
}
