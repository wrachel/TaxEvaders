package com.project.directory.controllers;

import com.project.directory.sql_helper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.project.directory.minilab.bryant.unlabeled_nodes.calculate_sequence;

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class controller {
    @GetMapping("/about")
    public String about(@RequestParam(name="name", required=false, defaultValue="stranger") String name, Model model) {
        model.addAttribute("name", name); // MODEL is passed to html
        return "about-new"; // returns HTML VIEW (greeting)
    }

    @GetMapping("/directory")
    public String directory(Model model) {
        String[][] teachers = {
                {"Mr. Mortensen", "A101", "jmortensen@powayusd.com"},
                {"Mrs. Craig", "E101", "cocraig@powayusd.com"},
                {"Mr. Liao", "K105", "fliao@powayusd.com"},
                {"Mrs. Lanzi-Sheaman", "G104", "mlanzi@powayusd.com"},
                {"Mr. Millman", "K106", "rmillman@powayusd.com"},
                {"Mrs. Dupas", "J102", "ddupas@powayusd.com"},
                {"Mrs. Balderas", "D118", "mbalderas@powayusd.com"},
                {"Mrs. Derksen", "G103", "mderksen@powayusd.com"},
                {"Mr. Ozuna", "K103", "kozuna@powayusd.com"},
                {"Mrs. Wong", "M116", "rwong@powayusd.com"},
                {"Mrs. Buehler", "L103", "jbuehler@powayusd.com"},
                {"Mrs. Volger", "L114", "ddupas@powayusd.com"},
                {"Mrs. Darcey", "G115", "ddupas@powayusd.com"},
                {"Mrs. Ayres", "L117", "eayres@powayusd.com"},
                {"Mr. Strutton", "D117", "astrutton@powayusd.com"},
                {"Mrs. Craig", "E101", "ccraig@powayusd.com"},
                {"Mrs. Ross", "R501", "rross@powayusd.com"},
                {"Mrs. Parmley", "L112", "@eparmleypowayusd.com"},
                {"Mr. Swanson", "L116", "@tswansonpowayusd.com"},
                {"Mr. Krenz", "J102", "@jkrenzpowayusd.com"},
                {"Mrs. Nydam", "L102", "cnydam@powayusd.com"},
                {"Mr. Bernabeo", "L101", "jbernabeo@powayusd.com"},
                {"Mrs. Callicot", "K104", "acallicot@powayusd.com"},
                {"Mrs. Lin", "D116", "clin@powayusd.com"},
                {"Mrs. Giffin", "L111", "tgiffin@powayusd.com"},
                {"Mrs. Alvarez", "D111", "malvarez@powayusd.com"},
                {"Mrs. Smedley", "E104", "lsmedley@powayusd.com"},
                {"Mrs. Cheskaty", "E106", "jcheskaty@powayusd.com"},
                {"Mrs. Dafoe", "G101", "sdafoe@powayusd.com"},
                {"Mrs. Jenkins", "G101", "cjenkins@powayusd.com"},
        };
        //model.addAttribute("teacherName", "Mr.Mortensen");
        //model.addAttribute("teacherName1", "Mrs.Craig");
        //model.addAttribute("teacherName2", "Mr.Liao");
        model.addAttribute("teachers", teachers);
        return "teacherDirectory"; // returns HTML VIEW (greeting)
    }

    @GetMapping("/directory_sql")
    public String directory_sql(Model model) {
        String url = "jdbc:sqlite:db/test.db";
        sql_helper database = new sql_helper();
        String[][] teachers = database.read_teachers(url);

        model.addAttribute("teachers", teachers);
        return "teacherDirectorySQL"; // returns HTML VIEW (greeting)
    }

    @PostMapping("/directory_sql")
    public String add_teacher(@RequestParam(name="name", required=true) String name, @RequestParam(name="email", required=true) String email, @RequestParam(name="room", required=true) String room, Model model) {
        String url = "jdbc:sqlite:db/test.db";
        sql_helper database = new sql_helper();

        database.add_teacher(url, name, room, email);

        return "redirect:/directory_sql";
    }

    @GetMapping("/test")
    public String about(@RequestParam(name="file", required=false, defaultValue="THEME1") String file) {
        return file; // returns HTML VIEW (greeting)
    }

    @GetMapping("/binary")
    public String binary(@RequestParam(name="bits", required=false, defaultValue="8") int bits,
                         @RequestParam(name="image_off", required=false, defaultValue="/images/sadFace.png") String IMAGE_OFF,
                         @RequestParam(name="image_on", required=false, defaultValue="/images/happyFace.png") String IMAGE_ON, Model binary_model) {
        binary_model.addAttribute("bits", bits);
        binary_model.addAttribute("IMAGE_OFF", IMAGE_OFF);
        binary_model.addAttribute("IMAGE_ON", IMAGE_ON);
        return "hackathon/binary"; // returns HTML VIEW (greeting)
    }

    @GetMapping("/nerd")
    public String nerd(@RequestParam(name="count", required=false, defaultValue="4") int n, Model nerd_model) {
        nerd_model.addAttribute("seq", calculate_sequence(n));
        return "minilabs/nonisomorphic_count"; // returns HTML VIEW (greeting)
    }

    @GetMapping("/lucasNum")
    public String lucasNum(@RequestParam(name="count", required=false, defaultValue="4") int x, Model lucas_model) {
        lucas_model.addAttribute("series", calculate_sequence(x));
        return "minilabs/lucasNum"; // returns HTML VIEW (greeting)
    }

}

