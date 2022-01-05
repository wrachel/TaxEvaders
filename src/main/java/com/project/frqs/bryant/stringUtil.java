package com.project.frqs.bryant;

import java.util.Arrays;

public class stringUtil {
    private String str;

    public stringUtil(String str) { // constructor moment
        this.str = str;
    }

    public String longestStreak() {
        int maxLen, currLen;
        char maxChar, currChar;
        maxLen = currLen = 0;
        maxChar = currChar = ' ';
        for(int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == currChar) {
                currLen += 1;
            }
            else {
                maxChar = (currLen > maxLen ? currChar : maxChar);
                maxLen = (currLen > maxLen ? currLen : maxLen);
                currChar = str.charAt(i);
                currLen = 1;
            }
        }
        return maxChar + " " + maxLen;
    }

    public static void main(String[] args) {
        stringUtil stringTester = new stringUtil("This is a test string!");
        System.out.println(stringTester.longestStreak());
    }
}
