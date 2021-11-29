package com.project.passwordmanager.crypto;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class sha256 implements crypto {
    public String hash(String toHash) throws NoSuchAlgorithmException {
        MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
        BigInteger hash = new BigInteger(1, sha256.digest(toHash.getBytes(StandardCharsets.UTF_8)));
        return String.format("%064x", hash);
    }

    public boolean check(String hash, String password) throws NoSuchAlgorithmException {
        MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
        BigInteger hashed = new BigInteger(1, sha256.digest(password.getBytes(StandardCharsets.UTF_8)));
        return String.format("%064x", hashed).equals(hash);
    }
}
