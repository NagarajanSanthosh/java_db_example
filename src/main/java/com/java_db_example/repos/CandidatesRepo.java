package com.java_db_example.repos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.java_db_example.config.DbConnection;
import com.java_db_example.data.Candidates;

public class CandidatesRepo {
    private Connection connection;
    Scanner scanner = new Scanner(System.in);

    public CandidatesRepo() throws SQLException {
        this.connection = DbConnection.getConnection();
    }

    /**
     * Retrive all the candidates
     * 
     * @return list of canidate
     */
    public List<Candidates> getAllCandidates() {
        List<Candidates> candidates = new ArrayList<>();
        String sql = "select * from candidates";
        try (Statement statement = connection.createStatement();
                ResultSet resultset = statement.executeQuery(sql)) {
            while (resultset.next()) {
                Candidates candidate = new Candidates();
                candidate.setCandidateId(resultset.getInt("candidate_id"));
                candidate.setCandidateName(resultset.getString("candidate_name"));
                candidate.setPartyId(resultset.getInt("party_id"));
                candidate.setConstituencyId(resultset.getInt("constituency_id"));
                candidates.add(candidate);
            }
        } catch (Exception e) {
            System.err.println("Error fetching candidates details");
        }
        return candidates;
    }

    /**
     * print the list of candidates
     * 
     * @param candidates
     */
    public void candidatePrinter(List<Candidates> candidates) {
        System.out.printf("%-20s %-30s %-20s %-20s \n", "Candidate Id", "Candidate Name", "Party Id",
                "Constituency Id");
        System.out.println(
                "------------------------------------------------------------------------------------------------");
        for (Candidates candidate : candidates) {
            System.out.printf("%-20s %-30s %-20s %-20s \n", candidate.getCandidateId(), candidate.getCandidateName(),
                    candidate.getPartyId(), candidate.getConstituencyId());
        }
    }

    public void methodHandler(int option) {

        if (option == 1) {
            List<Candidates> candidate = getAllCandidates();
            candidatePrinter(candidate);
        }
    }

}