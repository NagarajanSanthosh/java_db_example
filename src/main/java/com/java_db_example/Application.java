package com.java_db_example;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.java_db_example.data.Parties;
import com.java_db_example.repos.CandidatesRepo;
import com.java_db_example.repos.PartiesRepo;
import com.java_db_example.utility.Password;

public class Application {
    public static void main(String[] args) throws SQLException, InputMismatchException, NumberFormatException {
        Scanner scanner = new Scanner(System.in);
        PartiesRepo partyRepo = new PartiesRepo();
        CandidatesRepo candidatesRepo = new CandidatesRepo();

        try {
            while (true) {
                System.out.println("Voting System");
                System.out.println("--------------");
                System.out.println("Enter 1 to get into Admin portal ");
                System.out.println("Enter 2 to get into Voter portal ");
                System.out.println("Enter 0 to exit ");
                System.out.println();
                int options = scanner.nextInt();
                if (options == 1) {
                    Password password = new Password();
                    if (password.handleInput()) {
                        System.out.println("Welcome!!\n---------\nEnter 1 - Party portal");
                        System.out.println("Enter 2 - candidate portal");
                        System.out.println("Enter 3 - ward portal");
                        System.out.println("Enter 4 - poll booth portal");
                        int adminOptions = scanner.nextInt();
                        // Party Manipulation
                        if (adminOptions == 1) {
                            System.out.println("Enter 1 - View Parties");
                            System.out.println("Enter 2 - Add Party");
                            System.out.println("Enter 3 - Remove Parties");
                            System.out.println("Enter 4 - Update parties");

                            int option = scanner.nextInt();
                            scanner.nextLine();
                            partyRepo.methodHandler(option);

                        }
                        // Candidate Manipulation
                        else if (adminOptions == 2) {
                            System.out.println(
                                    "Enter 1 to view candidate \nEnter 2 to add candidate\nEnter 3 to update candidate\nEnter 4 to delete candidate");
                            int option = scanner.nextInt();
                            candidatesRepo.methodHandler(option);
                            // if (option == 1) {
                                
                            // }
                            // else if (option == 1) {
                            //     System.out.println("Enter candidate name: ");
                            //     String candidateName = scanner.nextLine();
                            //     System.out.println("Enter Party Name: ");
                            //     String partyName = scanner.nextLine();
                            // }
                        }
                        // WARD MANIPULATION
                        else if (adminOptions == 3) {

                        }
                        // POLL BOOTH MANIPULATION
                        else if (adminOptions == 4) {

                        } else {
                            break;
                        }
                    } else {
                        System.out.println("Wrong Password!!!");
                    }

                } else if (options == 2) {

                } else {
                    System.out.println("Bye!");
                    scanner.close();
                    break;
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }
    }

}