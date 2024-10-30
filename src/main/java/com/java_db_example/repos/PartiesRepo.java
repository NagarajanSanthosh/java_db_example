package com.java_db_example.repos;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.java_db_example.config.DbConnection;
import com.java_db_example.data.Parties;

public class PartiesRepo {
    private Connection connection;
    Scanner scanner = new Scanner(System.in);

    public PartiesRepo() throws SQLException {
        this.connection = DbConnection.getConnection();
    }

    /**
     * retrieve all parties
     * 
     * @return
     * @throws SQLException
     */
    public List<Parties> getAllParties() throws SQLException {
        List<Parties> parties = new ArrayList<>();
        String sql = "select * from parties";
        try (
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)) {
            // resultSet = statement.executeQuery("show tables");
            while (resultSet.next()) {
                Parties party = new Parties();
                party.setPartyId(resultSet.getInt("party_id"));
                party.setPartyName(resultSet.getString("party_name"));
                party.setChief(resultSet.getString("chief"));
                parties.add(party);
            }
        } catch (Exception e) {
            System.err.println("Error fetching result");
        }

        return parties;
    }

    /**
     * add parties
     * 
     * @param partyName
     * @param chief
     * @return
     * @throws SQLException
     */
    public String addParty(String partyName, String chief) throws SQLException {
        String sql = "Insert into parties (party_name, chief) values(?, ?)";
        try (
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, partyName);
            statement.setString(2, chief);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error adding party " + e.getMessage());
            e.printStackTrace();
        }
        return "Added successfully....";
    }

    public boolean isPartyIdValid(int partyId) {
        String sql = "select count(*) from parties where party_id = " + partyId;
        try (Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)) {
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.err.println("Error fetching party id");
        }
        return false;
    }

    /**
     * print the list of parties
     * 
     * @param partyList
     */
    public void partyPrinter(List<Parties> partyList) {
        System.out.printf("%-10s %-50s %-20s \n", "Party Id", "Party Name", "Chief");
        System.out.println("---------------------------------------------------------------------");
        for (Parties party : partyList) {
            System.out.printf("%-10d %-50s %-20s%n", party.getPartyId(), party.getPartyName(), party.getChief());
        }
    }

    /**
     * handles the method based on the input prompt from client
     * 
     * @param option
     * @throws SQLException
     */
    public void methodHandler(int option) throws SQLException {
        // call getparties
        if (option == 1) {
            List<Parties> party = getAllParties();
            // System.out.println(party.toString());
            partyPrinter(party);
        }
        // add party
        else if (option == 2) {
            System.out.println("Enter Party Name: ");
            String partyName = scanner.nextLine();
            System.out.println("Enter Chief: ");
            String chief = scanner.nextLine();
            String result = addParty(partyName, chief);
            System.out.println(result);
        } else if (option == 3) {

        } else if (option == 4) {

        } else
            close();

    }

    public void close() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
        if (scanner != null) {
            scanner.close();
        }
    }

}
