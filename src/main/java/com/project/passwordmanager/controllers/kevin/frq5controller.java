package com.project.passwordmanager.controllers.kevin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class frq5controller extends Invitation {


    @GetMapping("/kevin/unit5/interactive")
    public String displayFRQInteractive(Model model,
                                        @RequestParam(name = "addy", required = false, defaultValue = "16440 Bernardo Center Dr") String addy,
                                        @RequestParam(name = "name", required = false, defaultValue = "Mario") String name
    ) {
        Invitation inv = new Invitation(addy);
        inv.setAddress(addy);
        model.addAttribute("invite", inv.invite(name));

        return "frontend/kevin/unit5interactive";
    }
}
