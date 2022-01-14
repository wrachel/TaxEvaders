package com.project.passwordmanager.controllers.harry;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class Hfrq5controller {
    @GetMapping("/harry/frq5a")
    public String frq5q1(@RequestParam(name = "host", required = false, defaultValue = "karen") String host,
                         @RequestParam(name = "add", required = false, defaultValue = "ad") String add,
                         @RequestParam(name = "inv", required = false, defaultValue = "Cheryl") String inv,
                         @RequestParam(name = "new", required = false, defaultValue = "address") String newadd ,Model model) throws IOException{

        frq5 myinvite= new question1();
        String c= myinvite.invite(host, add, inv);
        //String c=invite(host,add,inv );

        model.addAttribute("b", add);
        model.addAttribute("a", host);
        model.addAttribute("c",c);
        model.addAttribute("d", newadd);

        return "frqs/harryfrq5";
    }
    @GetMapping("/harry/frq5b")
    public String frq5q2(@RequestParam(name = "flength", required = true, defaultValue = "4") int length,
                         @RequestParam(name = "pref", required = true, defaultValue = "chs") String prefix,
                         @RequestParam(name = "second", required = true, defaultValue = "6") int second, Model model) throws IOException{

        String[] arr;
        PasswordGenerator mygen = new PasswordGenerator(length, prefix);
        arr = mygen.main(prefix, length, second);

        for(int i =0; i<=arr.length; i++){
            switch(i){
                case 0:
                    model.addAttribute("count1",arr[i]);
                    break;
                case 1:
                    model.addAttribute("pw1",arr[i]);
                    break;
                case 2:
                    model.addAttribute("pw2",arr[i]);
                    break;
                case 3:
                    model.addAttribute("count2",arr[i]);
                    break;
                case 4:
                    model.addAttribute("count3",arr[i]);
                    break;
                case 5:
                    model.addAttribute("pw3",arr[i]);
                    break;
                case 6:
                    model.addAttribute("count4",arr[i]);
                    break;
                case 7:
                    model.addAttribute("count5",arr[i]);
                    break;
            }
        }

        return "frqs/harryfrq5b";
    }

}
