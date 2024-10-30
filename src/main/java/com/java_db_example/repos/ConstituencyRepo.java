package com.java_db_example.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.java_db_example.config.DbConnection;
import com.java_db_example.data.Constituency;

public class ConstituencyRepo {
    private Connection connection;

    public ConstituencyRepo() throws SQLException {
        connection = DbConnection.getConnection();
    }

    Scanner scanner = new Scanner(System.in);

    private List<Constituency> getAllConstituencies() {
        String sql = "select * from constituency";
        List<Constituency> constituencies = new ArrayList<>();
        try (Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);) {
            while (resultSet.next()) {
                Constituency constituency = new Constituency();
                constituency.setConstituencyId(resultSet.getInt("c_id"));
                constituency.setConstituencyName(resultSet.getString("c_name"));
                constituency.setDistrict(resultSet.getString("c_district"));
                constituencies.add(constituency);
            }
        } catch (Exception e) {
            System.err.println("Error fetching constituency details");
        }
        return constituencies;
    }

    public void constituencyPrinter(List<Constituency> constituencies) {
        System.out.printf("%-20s %-30s %-20s\n", "Constituency Id", "Constituency Name", "District");
        System.out.println(
                "--------------------------------------------------------------------------------------");
        for (Constituency constituency : constituencies) {
            System.out.printf("%-20s %-30s %-20s\n", constituency.getConstituencyId(),
                    constituency.getConstituencyName(), constituency.getDistrict());
        }
    }

    public boolean isConstituencyIdValid(int constituencyId) {
        String sql = "select count(*) from constituency where c_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setInt(1, constituencyId);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.err.println("Error fetching constituency id");
        }
        return false;
    }

    public void methodHandler(int option) {
        if (option == 1) {
            constituencyPrinter(getAllConstituencies());
        } else if (option == 2) {

        } else if (option == 3) {

        }
    }

}
