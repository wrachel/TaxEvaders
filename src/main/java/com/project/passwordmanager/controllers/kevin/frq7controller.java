package com.project.passwordmanager.controllers.kevin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class frq7controller {
    @GetMapping("/kevin/unit7/interactive")
    public String displayFRQInteractive(Model model,
                                        @RequestParam(name = "firstName", required = false, defaultValue = "Kevin") String firstName,
                                        @RequestParam(name = "lastName", required = false, defaultValue = "Do") String lastName,
                                        @RequestParam(name = "usedNames", required = false, defaultValue = "DoKev, DoKevin") String usedNames
    ) {

        String[] namesUsed = usedNames.split(", ");
        UserName user = new UserName(firstName, lastName);
        ArrayList<String> list1 = new ArrayList<String>(user.possibleNames);
        user.setAvailableUserNames(namesUsed);
        ArrayList<String> list2 = new ArrayList<String>(user.possibleNames);

        model.addAttribute("list1", list1);
        model.addAttribute("list2", list2);

        return "frontend/kevin/unit7interactive";
    }
}
