package com.project.passwordmanager;
import java.util.Random;
import java.util.ArrayList;

public class JavaPassGenerator {
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SYMBOLS = "!@#$%&*()_+-=[]|,./?><";
    private boolean useLower;
    private boolean useUpper;
    private boolean useDigits;
    private boolean useSymbols;
    private int length;

    public JavaPassGenerator(boolean symbols1, boolean digits1, boolean upper1, int length1){
        this.useLower = true;
        this.useUpper = upper1;
        this.useDigits = digits1;
        this.length = length1;
        this.useSymbols = symbols1;
    }

    public String generate(int length) {
        // Argument Validation.
        if (length <= 0) {
            return "";
        }

        // Variables.
        StringBuilder password = new StringBuilder(length);
        Random random = new Random(System.nanoTime());

        // Collect the categories to use.
        ArrayList<String> charCategories = new ArrayList<>(4);
        if (useLower = true) {
            charCategories.add(LOWER);
        }
        if (useUpper = true) {
            charCategories.add(UPPER);
        }
        if (useDigits = true) {
            charCategories.add(DIGITS);
        }
        if (useSymbols = true) {
            charCategories.add(SYMBOLS);
        }

        // Build the password.
        for (int i = 0; i < length; i++) {
            String charCategory = charCategories.get(random.nextInt(charCategories.size()));
            int position = random.nextInt(charCategory.length());
            password.append(charCategory.charAt(position));
        }
        return new String(password);
    }

    public static void main(String[] args){
        JavaPassGenerator passwordGenerator = new JavaPassGenerator(true, true, true, 10);
        String password = passwordGenerator.generate(10);
        System.out.println(password);
    }
}
