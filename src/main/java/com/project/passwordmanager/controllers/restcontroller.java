package com.project.passwordmanager.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class restcontroller {
        @GetMapping("/deploy")
        public String  rest() { return ""; }
}
