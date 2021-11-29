package com.project.passwordmanager.crypto;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class sha512 implements crypto {
    public String hash(String toHash) throws NoSuchAlgorithmException {
        MessageDigest sha512 = MessageDigest.getInstance("SHA-512");
        BigInteger hash = new BigInteger(1, sha512.digest(toHash.getBytes(StandardCharsets.UTF_8)));
        return String.format("%064x", hash);
    }

    public boolean check(String hash, String password) throws NoSuchAlgorithmException {
        MessageDigest sha512 = MessageDigest.getInstance("SHA-512");
        BigInteger hashed = new BigInteger(1, sha512.digest(password.getBytes(StandardCharsets.UTF_8)));
        return String.format("%064x", hashed).equals(hash);
    }
}
