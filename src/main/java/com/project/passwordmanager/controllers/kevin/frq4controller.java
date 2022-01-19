package com.project.passwordmanager.controllers.kevin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("kevinfrq4")
public class frq4controller extends frq4{

    @GetMapping("/kevin/unit4/interactive")
    public String displayFRQInteractive(Model model,
                                        @RequestParam(name = "word", required = false, defaultValue = "CCAAAAATTT!") String word,
                                        @RequestParam(name = "rounds", required = true, defaultValue = "5") int round,
                                        @RequestParam(name = "rounds", required = true, defaultValue = "10") int coin1,
                                        @RequestParam(name = "rounds", required = true, defaultValue = "10") int coin2
    ) {
        model.addAttribute("longestStreak", longestStreak(word));

        String game = playGame(round, coin1, coin2);

        model.addAttribute("game", game);
        model.addAttribute("round", round);
        model.addAttribute("coin1", firstcoin());
        model.addAttribute("coin2", secondcoin());

        return "frontend/kevin/unit4interactive";
    }
}