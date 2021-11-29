package com.project.passwordmanager;
import com.project.passwordmanager.crypto.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.NoSuchAlgorithmException;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        crypto hash = cryptoFactory.create("argon2");
        System.out.println(hash.hash("test"));
        System.out.println(hash.check(hash.hash("test"), "test"));
        SpringApplication.run(Main.class, args);
    }

}

