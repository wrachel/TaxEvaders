package com.project.passwordmanager.controllers.rachel;

import com.project.frqs.rachel.rachel_Invitation;
import com.project.frqs.rachel.rachelfrq4;
import com.project.frqs.rachel.rachelfrq5q2;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class rachelfrq5 {
    @GetMapping("/rachel/frq5")
    public String rachelfrq5(@RequestParam(name = "hostName", required = false, defaultValue = "Rachel Wei") String hostName, @RequestParam(name = "address", required = false, defaultValue = "16601 Nighthawk Ln") String address, @RequestParam(name = "invited", required = false, defaultValue = "N/A") String invited, @RequestParam(name = "length", required = false, defaultValue = "8")int length, @RequestParam(name = "prefix", required = false, defaultValue="A")String prefix, Model model) {
        rachel_Invitation invite = new rachel_Invitation(hostName, address);
        model.addAttribute("inviteNotif", (invite.invitedPerson(invited)));

        rachelfrq5q2 passwordgen = new rachelfrq5q2(length, prefix);
        model.addAttribute("password", passwordgen.pwGen());

        return "/frqs/rachel/rachelfrq5";
    }

}