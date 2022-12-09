package me.overlight.auth;

import java.util.HashMap;
import java.util.Objects;

public class PassManager {
    private static HashMap<String, String> passwords = new HashMap<>();


    public static void addPassword(String username, String password){
        passwords.put(username, password);
    }
    public static boolean check(String username){
        return passwords.containsKey(username);
    }
    public static boolean check(String username, String password){
        return Objects.equals(passwords.get(username), password);
    }
}
