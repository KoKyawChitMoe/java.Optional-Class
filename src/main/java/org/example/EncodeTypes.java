package org.example;

import java.util.Base64;

public class EncodeTypes {
    public static void main(String[] args) {
        String data = "spripqoej[fpjef[pawejfpaiejfpaoiefhapwefoiapeifhapoiapoeifhpwefngBoot";

        // Standard Base64
        String base64 = Base64.getEncoder().encodeToString(data.getBytes());
        System.out.println("Base64: " + base64);

        // Base64 URL-Safe
        String base64Url = Base64.getUrlEncoder().encodeToString(data.getBytes());
        System.out.println("Base64Url: " + base64Url);
    }
}
