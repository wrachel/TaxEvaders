package com.project.passwordmanager.controllers.kevin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;


@Controller
public class frq6controller {

    @GetMapping("/kevin/unit6/interactive")
    public String displayFRQInteractive(Model model,
                                        @RequestParam(name = "ingList", required = false, defaultValue = "ten, fading, post, card, thunder, hinge, trailing, batting") String ingList,
                                        @RequestParam(name = "itemsSoldList", required = false, defaultValue = "48, 50, 37, 62, 38, 70, 55, 37, 64, 60") String itemsSoldList,
                                        @RequestParam(name = "fixed", required = false, defaultValue = "10.0") String fixed,
                                        @RequestParam(name = "perItem", required = false, defaultValue = "1.5") String perItem
    ) {
        String[] ingListArr = ingList.split(", ");
        ArrayList<String> ingWords = new ArrayList<String>();
        for (String word : ingListArr) {
            if(word.endsWith("ing")) {
                ingWords.add(word);
            }
        }
        System.out.println(ingWords.size());

        String[] itemsSold = itemsSoldList.split(", ");
        int[] itemsSoldArr = new int[itemsSold.length];
        for (int i = 0; i < itemsSold.length; i++) {
            itemsSoldArr[i] = Integer.parseInt(itemsSold[i]);
        }

        double[] wagesArr = new double[itemsSoldArr.length];

        Payroll frq = new Payroll(itemsSoldArr, wagesArr);
        double fixedWage = Double.parseDouble(fixed);
        double perItemWage = Double.parseDouble(perItem);
        frq.computeWages(fixedWage, perItemWage);

        model.addAttribute("bonusThreshold", frq.computeBonusThreshold());
        model.addAttribute("wages", frq.getWages());
        model.addAttribute("ingWords", ingWords);

        return "frontend/kevin/unit6interactive";
    }
}
