package com.java_db_example.utility;

import java.util.Scanner;

public class Password {
    private final String password = "mlpzaq987";
    Scanner scanner = new Scanner(System.in);

    public String getPassword() {
        return password;
    }

    public boolean handleInput() {
        System.out.println("Enter admin password: ");
        String pwd = scanner.nextLine();
        return (getPassword().equals(pwd));
    }

}
