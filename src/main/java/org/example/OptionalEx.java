package org.example;

import java.util.Optional;

public class OptionalEx {

    public static void main(String[] args) {

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println();
        System.out.println("================>>>>>>   My My Kyaw Gyi   <<<<<<<=================");
        System.out.println();
        System.out.println("******************************************************************");

        // Input Data
        String name = "This is Not Null";
        String shotName = "Chit";
        String nameIs = null;

        // Optional usage
        Optional<String> optionalName = Optional.ofNullable(name);
        Optional<String> optionalShortName = Optional.ofNullable(shotName);
        Optional<String> optionalNull = Optional.ofNullable(nameIs);


        // ========== Optional Basic Check ==========
        if (optionalNull.isEmpty()) {
            System.out.println(" optionalNull is EMPTY  : " + optionalNull);
        }

        if (optionalShortName.isPresent()) {
            System.out.println(" shortName is present: " + optionalShortName.get());
            System.out.println(" shortName length: " + shotName.length());
        }

        if (optionalName.isPresent()) {
            System.out.println(" name is present: " + optionalName.get());
        } else {
            System.out.println(" name is missing!");
        }

        // ========== Using orElse ==========

        System.out.println();
        String fullName = Optional.ofNullable(nameIs).orElse("Default Name");
        System.out.println("Full Name: " + fullName);

        // ========== Using orElseGet ==========

        System.out.println();
        String safeName = optionalNull.orElseGet(() -> "Generated Default Name");
        System.out.println("Safe Name: " + safeName);

        // ========== Using map ==========

        System.out.println();
        optionalName
                .map(n -> n.toUpperCase())
                .ifPresent(n -> System.out.println("Uppercased Name: " + n));

        // ========== Using filter ==========


        Optional<String> longName = optionalName.filter(n -> n.length() > 10);
        longName.ifPresent(n -> System.out.println("Long Name (>10 chars): " + n));

        // ========== Using ifPresentOrElse ==========


        optionalNull.ifPresentOrElse(
                val -> System.out.println("✔ optionalNull has value: " + val),
                () -> System.out.println("✖ optionalNull is empty.")
        );

        // ========== Simulated Check ==========


        simulateLogin("admin");
        simulateLogin(null);
    }

    // Logic Function: Login Check Simulation
    public static void simulateLogin(String username) {
        Optional<String> optionalUser = Optional.ofNullable(username);
        optionalUser
                .filter(user -> user.equals("admin"))
                .ifPresentOrElse(
                        user -> System.out.println(" Welcome " + user + ", you are logged in."),
                        () -> System.out.println(" Access Denied or Username is Missing!")
                );
    }
}
