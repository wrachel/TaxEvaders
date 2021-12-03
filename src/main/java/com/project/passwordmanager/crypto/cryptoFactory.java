package com.project.passwordmanager.crypto;

public class cryptoFactory {
    public static crypto create(String hash_type) {
        if (hash_type.equalsIgnoreCase("sha256")) {
            return new sha256();
        }
        else if (hash_type.equalsIgnoreCase("sha512")) {
            return new sha512();
        }
        else if (hash_type.equalsIgnoreCase("argon2")) {
            return new argon2();
        }
        return null;
    }
}
