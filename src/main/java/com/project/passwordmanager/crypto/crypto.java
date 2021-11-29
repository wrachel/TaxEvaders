package com.project.passwordmanager.crypto;
import java.security.NoSuchAlgorithmException;

public interface crypto {
    String hash(String toHash) throws NoSuchAlgorithmException;
    boolean check(String hash, String password) throws NoSuchAlgorithmException;
}
