package com.project.passwordmanager.controllers.harry;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class hfrq10controller {
    @GetMapping("/harry/frq10")
    public String frq10(@RequestParam(name = "num", required = false, defaultValue = "24") int  num,
                        @RequestParam(name = "num2", required = false, defaultValue = "48") int  num2,
                        @RequestParam(name = "numerator", required = false, defaultValue = "15") int  numerator,
                        @RequestParam(name = "denom", required = false, defaultValue = "30") int  denom,Model model) throws IOException {

        NumberSystem number= new NumberSystem();

int a =number.gcf(num, num2);
model.addAttribute("a", Integer.toString(a));
String b= number.reduceFraction(numerator, denom);
String fin= numerator +"/"+denom+" reduces to "+ b;
model.addAttribute("b", fin);



      return "frqs/harryfrq10";
    }
    @GetMapping("/harry/frqcode10")
    public String code(){
        return "frqs/code10";
    }

}
