package com.project.passwordmanager.controllers.rachel;
import com.project.frqs.rachel.rachel_frq4_game;
import com.project.frqs.rachel.rachelfrq4;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class rachel_frq4_coingame {
    @GetMapping("/rachel/frq4/question2")
    public String rachelfrq4coin(@RequestParam(name="coins", required = false, defaultValue = "5") int coins, @RequestParam(name="rounds", required = false, defaultValue = "10") int rounds, Model rachelfrq4coinsmodel){
        rachel_frq4_game coingame = new rachel_frq4_game(coins, rounds);
        rachelfrq4coinsmodel.addAttribute("winner", coingame.playGame());
        return "frqs/rachel/rachelfrq4_game";
    }
}
