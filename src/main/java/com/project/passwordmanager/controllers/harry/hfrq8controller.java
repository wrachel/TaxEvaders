package com.project.passwordmanager.controllers.harry;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class hfrq8controller {
    @GetMapping("/harry/frq8")
    public String frq8 (@RequestParam(name = "crop1", required = false, defaultValue = "peas") String crop1,
                        @RequestParam(name = "yield1", required = false, defaultValue = "12") String yield1,
                        @RequestParam(name = "crop2", required = false, defaultValue = "peas") String crop2,
                        @RequestParam(name = "yield2", required = false, defaultValue = "12") String yield2,
                        @RequestParam(name = "crop3", required = false, defaultValue = "peas") String crop3,
                        @RequestParam(name = "yield3", required = false, defaultValue = "12") String yield3,
                        @RequestParam(name = "crop4", required = false, defaultValue = "peas") String crop4,
                        @RequestParam(name = "yield4", required = false, defaultValue = "12") String yield4,
                        @RequestParam(name = "crop5", required = false, defaultValue = "peas") String crop5,
                        @RequestParam(name = "yield5", required = false, defaultValue = "12") String yield5,
                        @RequestParam(name = "crop6", required = false, defaultValue = "peas") String crop6,
                        @RequestParam(name = "yield6", required = false, defaultValue = "12") String yield6,
                        @RequestParam(name = "crop7", required = false, defaultValue = "peas") String crop7,
                        @RequestParam(name = "yield7", required = false, defaultValue = "12") String yield7,
                        @RequestParam(name = "crop8", required = false, defaultValue = "peas") String crop8,
                        @RequestParam(name = "yield8", required = false, defaultValue = "12") String yield8,
                        @RequestParam(name = "crop9", required = false, defaultValue = "peas") String crop9,
                        @RequestParam(name = "yield9", required = false, defaultValue = "12") String yield9,
                        @RequestParam(name = "crop10", required = false, defaultValue = "peas") String crop10,
                        @RequestParam(name = "yield10", required = false, defaultValue = "12") String yield10,
                        @RequestParam(name = "crop11", required = false, defaultValue = "peas") String crop11,
                        @RequestParam(name = "yield11", required = false, defaultValue = "12") String yield11,
                        @RequestParam(name = "crop12", required = false, defaultValue = "peas") String crop12,
                        @RequestParam(name = "yield12", required = false, defaultValue = "12") String yield12, Model model) throws IOException {

        Plot p1 = new Plot(crop1, Integer.parseInt(yield1));
        Plot p2 = new Plot(crop2, Integer.parseInt(yield2));
        Plot p3 = new Plot(crop3, Integer.parseInt(yield3));
        Plot p4 = new Plot(crop4, Integer.parseInt(yield4));
        Plot p5 = new Plot(crop5, Integer.parseInt(yield5));
        Plot p6 = new Plot(crop6, Integer.parseInt(yield6));
        Plot p7 = new Plot(crop7, Integer.parseInt(yield7));
        Plot p8 = new Plot(crop8, Integer.parseInt(yield8));
        Plot p9 = new Plot(crop9, Integer.parseInt(yield9));
        Plot p10 = new Plot(crop10, Integer.parseInt(yield10));
        Plot p11 = new Plot(crop11, Integer.parseInt(yield11));
        Plot p12 = new Plot(crop12, Integer.parseInt(yield12));
        Plot[][] plots = {{p1, p2, p3},
                {p4, p5, p6},
                {p7, p8, p9},
                {p10, p11, p12}};
        experimentalFarm f = new experimentalFarm(plots);
        Plot highestYield = f.getHighestYield("corn");
        Plot highestYield1 = f.getHighestYield("peas");
        Plot highestYield2 = f.getHighestYield("wheat");
        Plot highestYield3 = f.getHighestYield("rice");

        try {
            model.addAttribute("y1", highestYield.toString());

        } catch (Exception e) {
            model.addAttribute("y1","corn: null");
        }
        try{
            model.addAttribute("y2",highestYield1.toString());
        }
        catch (Exception e){
            model.addAttribute("y2","peas: null");
        }
        try{
            model.addAttribute("y3",highestYield2.toString());
        }
        catch (Exception e){
            model.addAttribute("y3","wehat: null");
        }
        try{
            model.addAttribute("y4",highestYield3.toString());
        }
        catch (Exception e){
            model.addAttribute("y4","rice: null");
        }
        //System.out.println("The method call f.sameCrop(0)");
        model.addAttribute("c1", f.sameCrop(0));
   //     System.out.println("The method call f.sameCrop(1)");
        model.addAttribute("c2", f.sameCrop(1));
        model.addAttribute("c3",f.sameCrop(2));

        return "frqs/harryfrq8";
    }
    @GetMapping("/harry/frq8code")
    public String frq8code(){
        return "frqs/hfrq8code";
    }
}