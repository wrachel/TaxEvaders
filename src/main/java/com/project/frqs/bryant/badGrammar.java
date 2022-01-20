package com.project.frqs.bryant;

public class badGrammar {
    private String[] words;
    public badGrammar(String[] words) {
        this.words = words;
    }

    public String[] primitiveUnderstandingOfPresentParticiples() {
        String[] presentParticiples = new String[this.words.length];
        int index = 0;
        for (String word : this.words) {
            presentParticiples[index] = word + "ing";
            index += 1;
        }
        return presentParticiples;
    }
}
