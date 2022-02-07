package com.project.passwordmanager.controllers.kevin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class frq8controller {
    @GetMapping("/kevin/unit8/interactive")
    public String displayFRQInteractive(Model model,
                                        @RequestParam(name = "crop", required = false, defaultValue = "corn") String crop,
                                        @RequestParam(name = "col", required = false, defaultValue = "2") String col
    ) {
        // making the plot -----------------------------------------------
        Plot[][] plots = new Plot[4][3];
        String[][] cropArr = {
                {"corn", "corn", "peas"},
                {"peas", "corn", "corn"},
                {"wheat", "corn", "rice"},
                {"corn", "corn", "peas"}
        };
        int[][] yieldArr = {
                {20, 30, 10},
                {30, 40, 62},
                {10, 50, 30},
                {55, 30, 30}
        };
        for(int i = 0; i<plots.length; i++) {
            for(int j = 0; j<plots[i].length; j++) {
                plots[i][j] = new Plot(cropArr[i][j], yieldArr[i][j]);
            }
        }
        ExperimentalFarm f = new ExperimentalFarm(plots);
        // ----------------------------------------------------------------
        model.addAttribute("highestYield", f.getHighestYield(crop));
        model.addAttribute("sameCrop", f.sameCrop(Integer.parseInt(col)));

        return "frontend/kevin/unit8interactive";
    }
}
