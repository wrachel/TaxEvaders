package com.project.frqs.bryant;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class badGrammar {
    private String[] words;
    public badGrammar(String[] words) {
        this.words = words;
    }

    public String[] primitiveUnderstandingOfPresentParticiples() {
        String[] presentParticiples = new String[0];
        for (String word : this.words) {
            if (word.substring(word.length() - 3).equals("ing")) {
                presentParticiples = Arrays.copyOf(presentParticiples, presentParticiples.length + 1);
                presentParticiples[presentParticiples.length - 1] = word;
            }
        }
        return presentParticiples;
    }

    public static void main(String[] args) {
        badGrammar test = new badGrammar(new String[] {"ten", "fading", "post", "card", "thunder", "hinge", "trailing", "batting"});
        for (String participle : test.primitiveUnderstandingOfPresentParticiples()) {
            System.out.println(participle);
        }
    }
}
