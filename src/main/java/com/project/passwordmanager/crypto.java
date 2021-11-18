package com.project.passwordmanager;
import de.mkammerer.argon2.*;

public class crypto {
    public String argon2(String toHash) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        return argon2.hash(1, 37888, 1, toHash.toCharArray());
    }
}
