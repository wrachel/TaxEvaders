package com.project.frqs.bryant;

import java.util.Random;

public class passwordGenerator {
    static int passwordsGenerated;
    private int length;
    private String prefix;

    public passwordGenerator(int length) {
        this.length = length;
        this.prefix = "A";
    }

    public passwordGenerator(int length, String prefix) {
        this.length = length;
        this.prefix = prefix;
    }

    public int pwCount() {
        return passwordsGenerated;
    }

    public String pwGen() {
        String digits = "";
        Random rand = new Random();

        for (int i = 0; i < this.length; i++) {
            digits += rand.nextInt(10);
        }

        passwordsGenerated += 1;

        return String.format("%s.%s", this.prefix, digits);
    }

    public static void main(String[] args) {
        passwordGenerator genOne = new passwordGenerator(4, "chs");
        System.out.println(genOne.pwCount());
        System.out.println(genOne.pwGen());
        System.out.println(genOne.pwGen());
        System.out.println(genOne.pwCount());

        passwordGenerator genTwo = new passwordGenerator(6);
        System.out.println(genTwo.pwCount());
        System.out.println(genTwo.pwGen());
        System.out.println(genTwo.pwCount());
        System.out.println(genOne.pwCount());
    }
}
