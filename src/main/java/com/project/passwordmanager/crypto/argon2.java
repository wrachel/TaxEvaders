package com.project.passwordmanager.crypto;
import de.mkammerer.argon2.*;
import java.security.NoSuchAlgorithmException;

public class argon2 implements crypto {
    public String hash(String toHash) throws NoSuchAlgorithmException {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        return argon2.hash(1, 37888, 1, toHash.toCharArray());
    }

    public boolean check(String hash, String password) throws NoSuchAlgorithmException {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        return argon2.verify(hash, password.toCharArray());
    }
}
