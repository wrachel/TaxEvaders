package com.project.frqs.bryant.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.project.frqs.bryant.LightSequence.*;

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class controller {
    @GetMapping("/frq2")
    public String nerd(@RequestParam(name = "a", required = false, defaultValue = "3") int a, @RequestParam(name = "b", required = false, defaultValue = "4") int b, @RequestParam(name = "initSeq", required = false, defaultValue = "0101 0101 0101") String initSeq, @RequestParam(name = "changeSeq", required = false, defaultValue = "0011 0011 0011") String changeSeq, @RequestParam(name = "segment", required = false, defaultValue = "1100000111") String segment, @RequestParam(name = "oldSeq", required = false, defaultValue = "00") String oldSeq, @RequestParam(name = "insertSeg", required = false, defaultValue = "1111 1111") String insertSeg, Model light_model) {
        light_model.addAttribute("data", calculate_sequence(a, b, initSeq, changeSeq, segment, oldSeq, insertSeg));
        light_model.addAttribute("desc", new String[]{"Initial display", "Changed display", "Display after insertion", "Replaced segment", "Distance between lights"});
        return "frqs/frq2"; // returns HTML VIEW (greeting)
    }
}