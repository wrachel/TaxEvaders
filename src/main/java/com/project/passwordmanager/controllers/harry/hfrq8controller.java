package com.project.passwordmanager.controllers.harry;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class hfrq8controller {
    @GetMapping("/harry/frq8")
    public String frq8 (@RequestParam(name = "crop1", required = true, defaultValue = "corn") String crop1,
                        @RequestParam(name = "yield1", required = true, defaultValue = "12") int yield1,
                        @RequestParam(name = "crop2", required = true, defaultValue = "corn") String crop2,
                        @RequestParam(name = "yield2", required = true, defaultValue = "12") int yield2,
                        @RequestParam(name = "crop3", required = true, defaultValue = "corn") String crop3,
                        @RequestParam(name = "yield3", required = true, defaultValue = "12") int yield3,
                        @RequestParam(name = "crop4", required = true, defaultValue = "corn") String crop4,
                        @RequestParam(name = "yield4", required = true, defaultValue = "12") int yield4,
                        @RequestParam(name = "crop5", required = true, defaultValue = "corn") String crop5,
                        @RequestParam(name = "yield5", required = true, defaultValue = "12") int yield5,
                        @RequestParam(name = "crop6", required = true, defaultValue = "corn") String crop6,
                        @RequestParam(name = "yield6", required = true, defaultValue = "12") int yield6,
                        @RequestParam(name = "crop7", required = true, defaultValue = "corn") String crop7,
                        @RequestParam(name = "yield7", required = true, defaultValue = "12") int yield7,
                        @RequestParam(name = "crop8", required = true, defaultValue = "corn") String crop8,
                        @RequestParam(name = "yield8", required = true, defaultValue = "12") int yield8,
                        @RequestParam(name = "crop9", required = true, defaultValue = "corn") String crop9,
                        @RequestParam(name = "yield9", required = true, defaultValue = "12") int yield9,
                        @RequestParam(name = "crop10", required = true, defaultValue = "corn") String crop10,
                        @RequestParam(name = "yield10", required = true, defaultValue = "12") int yield10,
                        @RequestParam(name = "crop11", required = true, defaultValue = "corn") String crop11,
                        @RequestParam(name = "yield11", required = true, defaultValue = "12") int yield11,
                        @RequestParam(name = "crop12", required = true, defaultValue = "corn") String crop12,
                        @RequestParam(name = "yield12", required = true, defaultValue = "12") int yield12, Model model) throws IOException {

        Plot p1 = new Plot(crop1, yield1);
        Plot p2 = new Plot(crop2, yield2);
        Plot p3 = new Plot(crop3, yield3);
        Plot p4 = new Plot(crop4, yield4);
        Plot p5 = new Plot(crop5, yield5);
        Plot p6 = new Plot(crop6, yield6);
        Plot p7 = new Plot(crop7, yield7);
        Plot p8 = new Plot(crop8, yield8);
        Plot p9 = new Plot(crop9, yield9);
        Plot p10 = new Plot(crop10, yield10);
        Plot p11 = new Plot(crop11, yield11);
        Plot p12 = new Plot(crop12, yield12);
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
            model.addAttribute("y3","wheat: null");
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