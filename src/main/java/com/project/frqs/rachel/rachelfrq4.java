package com.project.frqs.rachel;

public class rachelfrq4 {

    public String returnchar(String str){
        int longest = 1;
        int current = 1;
        char longestchar = str.charAt(0);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i + 1)){
                current++;
            } else {
                current = 1;
            }
            if (current > longest) {
                longest = current;
                longestchar = str.charAt(i);
            }
        }
        String returnvalue = longest + " " + longestchar;
        return returnvalue;
    }
}
