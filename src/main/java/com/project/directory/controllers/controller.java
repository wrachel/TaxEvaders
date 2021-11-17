package com.project.directory.controllers;

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


@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class controller {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/about/kevin")
    public String kevin() {
        return "frontend/about-kevin";
    }


}

