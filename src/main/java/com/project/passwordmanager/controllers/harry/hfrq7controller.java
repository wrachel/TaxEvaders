package com.project.passwordmanager.controllers.harry;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class hfrq7controller {
    @GetMapping("harry/frq7")
    public String frq7(@RequestParam(name = "first", required = false, defaultValue = "john") String first,
                       @RequestParam(name = "last", required = false, defaultValue = "smith") String last,Model model) throws IOException {


        return "frqs/harryfrq7";
    }
}
