package com.project.passwordmanager.controllers.kevin;

public class frq6 {
    public static void main(String[] args) {
        String[] words = {"ten", "fading", "post", "card", "thunder", "hinge", "trailing", "batting"};
        for (String word : words) {
            if(word.endsWith("ing")) {
                System.out.println(word);
            }
        }
    }
}
