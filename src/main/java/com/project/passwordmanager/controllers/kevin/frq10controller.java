package com.project.passwordmanager.controllers.kevin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Objects;

import static com.project.passwordmanager.controllers.kevin.NumberSystem.gcf;
import static com.project.passwordmanager.controllers.kevin.NumberSystem.reduceFraction;

@Controller
public class frq10controller {
    @GetMapping("/kevin/unit10/interactive")
    public String displayFRQInteractive(Model model,
                                        @RequestParam(name = "number1", required = false, defaultValue = "3") String number1,
                                        @RequestParam(name = "number2", required = false, defaultValue = "7") String number2,
                                        @RequestParam(name = "selection", required = false, defaultValue = "gcf") String switcher
    ) {
        String result = "";
        int int1 = Integer.parseInt(number1);
        int int2 = Integer.parseInt(number2);

        if(Objects.equals(switcher, "gcf")) {
            result = Integer.toString(gcf(int1, int2));
        }
        if(Objects.equals(switcher, "fraction")) {
            result = reduceFraction(int1, int2);
        }

        model.addAttribute("result", result);
        return "frontend/kevin/unit10interactive";
    }
}
