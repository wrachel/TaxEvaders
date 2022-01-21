package com.project.passwordmanager.controllers.harry;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class hfrq6controller {
    @GetMapping("/harry/frq6a")
    public String frq6a(@RequestParam(name = "find", required = false, defaultValue = "ing") String find, Model model) throws IOException {
        String[] words = new String[]{"ten", "fading", "post", "card", "thunder", "hinge", "trailing", "batting"};
       String fin="";

        for (String str : words) {
            if (str.substring(str.length() - 3).equals(find)) {
                fin = fin +" "+ str +",";
                model.addAttribute("a", fin);
            }
        }



            return "frqs/harryfrq6a";
    }
        
    @GetMapping("/harry/frq6b")
    public String frq6b(){

        return "frqs/harryfrq6b";
    }
}
