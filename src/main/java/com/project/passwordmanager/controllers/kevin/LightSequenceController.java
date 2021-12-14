package com.project.passwordmanager.controllers.kevin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LightSequenceController {

    @GetMapping("/kevin/unit2")
    public String displayFRQ() {
        return "frontend/kevin/unit2";
    }

    @GetMapping("/kevin/unit2/interactive")
    public String displayFRQInteractive(Model model,
                                        @RequestParam(name = "a", required = false, defaultValue = "3") int a,
                                        @RequestParam(name = "b", required = false, defaultValue = "4") int b,
                                        @RequestParam(name = "initSeq", required = false, defaultValue = "0101 0101 0101") String initSeq,
                                        @RequestParam(name = "changeSeq", required = false, defaultValue = "0011 0011 0011") String changeSeq,
                                        @RequestParam(name = "segment", required = false, defaultValue = "1110") String segment,
                                        @RequestParam(name = "oldSeq", required = false, defaultValue = "1000 1100 1110") String oldSeq,
                                        @RequestParam(name = "insertSeg", required = false, defaultValue = "1111 1111") String insertSeg
                                        ) {

        String resultSeq;

        // PART (a)
        LightSequence gradShow = new LightSequence(initSeq);
        String parta = gradShow.getSeq();

        // PART (b)
        gradShow.display();

        // PART (c)
        gradShow.changeSequence(changeSeq);
        String newGradShow = gradShow.getSeq();

        // PART (d)
        resultSeq = gradShow.insertSegment(insertSeg, 4);

        // PART (e)
        int index = oldSeq.indexOf(segment);
        String newSeq = oldSeq.substring(0, index) + oldSeq.substring(index + segment.length());

        // PART (f)
        double partf = Math.sqrt(a*a + b*b);

        model.addAttribute("initSeq", initSeq);
        model.addAttribute("newGradShow", newGradShow);
        model.addAttribute("resultSeq", resultSeq);
        model.addAttribute("newSeq", newSeq);
        model.addAttribute("partf", partf);

        return "frontend/kevin/unit2interactive";
    }
}