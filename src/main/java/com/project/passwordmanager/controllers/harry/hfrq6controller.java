package com.project.passwordmanager.controllers.harry;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class hfrq6controller {
    @GetMapping("/harry/frq6a")
    public String frq6a(@RequestParam(name = "find", required = false, defaultValue = "ing") String find, Model model) throws IOException {
        String[] words = new String[]{"ten", "fading", "post", "card", "thunder", "hinge", "trailing", "batting"};
       String fin="";

        for (String str : words) {
            if (str.substring(str.length() - 3).equals(find)) {
                fin = fin +" "+ str +",";
                model.addAttribute("a", fin);
            }
        }



            return "frqs/harryfrq6a";
    }
        
    @GetMapping("/harry/frq6b")
    public String frq6b(@RequestParam(name = "one", required = false, defaultValue = "48") int one,
                        @RequestParam(name = "two", required = false, defaultValue = "50") int two,
                        @RequestParam(name = "three", required = false, defaultValue = "37") int three,
                        @RequestParam(name = "four", required = false, defaultValue = "62") int four,
                        @RequestParam(name = "five", required = false, defaultValue = "38") int five,
                        @RequestParam(name = "six", required = false, defaultValue = "70") int six,
                        @RequestParam(name = "seven", required = false, defaultValue = "55") int seven,
                        @RequestParam(name = "eight", required = false, defaultValue = "37") int eight,
                        @RequestParam(name = "nine", required = false, defaultValue = "64") int nine,
                        @RequestParam(name = "ten", required = false, defaultValue = "60") int ten,
                        @RequestParam(name = "fixed", required = false, defaultValue = "10") int fixed,
                        @RequestParam(name = "per", required = false, defaultValue = "1.5") String per,Model model) throws IOException{

        double peritem= Double.parseDouble(per);
        int[] numbers={one, two, three, four, five, six, seven, eight, nine, ten};
        double[] wage;

        pay newthresh = new pay();
        double threshold = newthresh.computeBonusThreshold(numbers);
        wage=newthresh.computeWages(fixed, peritem, threshold);


        model.addAttribute("a", threshold);
        for(int i =0; i<=wage.length; i++){
            switch(i){
                case 0:
                    model.addAttribute("b",wage[i]);
                    break;
                case 1:
                    model.addAttribute("c",wage[i]);
                    break;
                case 2:
                    model.addAttribute("d",wage[i]);
                    break;
                case 3:
                    model.addAttribute("r",wage[i]);
                    break;
                case 4:
                    model.addAttribute("f",wage[i]);
                    break;
                case 5:
                    model.addAttribute("g",wage[i]);
                    break;
                case 6:
                    model.addAttribute("h",wage[i]);
                    break;
                case 7:
                    model.addAttribute("i",wage[i]);
                    break;
                case 8:
                    model.addAttribute("j",wage[i]);
                    break;
                case 9:
                    model.addAttribute("k",wage[i]);
                    break;
            }
        }



        return "frqs/harryfrq6b";
    }
}
