package com.project.passwordmanager.controllers.harry;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class hfrq7controller {
    @GetMapping("/harry/frq7")
    public String frq7(@RequestParam(name = "first", required = false, defaultValue = "john") String first,
                       @RequestParam(name = "last", required = false, defaultValue = "smith") String last,Model model) throws IOException {

        userName myUserNames = new userName(first, last);
        int n = myUserNames.GetCount();
        String name = "";

        for (int i=0; i<n; i++)
        {
            name = name +myUserNames.IndexerGetIndexAt(i)+", ";
            //System.out.println( myUserNames.IndexerGetIndexAt(iLoop));
        }

        model.addAttribute("a",name);
        model.addAttribute("count", n);
        return "frqs/harryfrq7";
    }
    @GetMapping("/harry/fq7code")
    public String code(){
        return "/frqs/frq7code";

    }

}
