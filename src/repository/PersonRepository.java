package repository;

import java.sql.*;

public class PersonRepository {

    public void getCostumers(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Integer rowsAffected = 0;
        try {
            String url = "jdbc:postgresql://localhost:5432/MyBookShop";
            String dbUsername = "postgres";
            String dbPassword = "ceparola";

            connection = DriverManager.getConnection(url, dbUsername, dbPassword);

//            String query = "INSERT INTO person values('Bogdan', 'Test')";
            String query = "SELECT * FROM customers;";
            preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            // Display function to show the Resultset
            while (resultSet.next()) {
                String username = resultSet.getString("customerid");
                String password = resultSet.getString("email");
                System.out.println(username + "     " + password);
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
    }

    public int logIn(String email){
        int customerId=0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Integer rowsAffected = 0;
        try {
            String url = "jdbc:postgresql://localhost:5432/MyBookShop";
            String dbUsername = "postgres";
            String dbPassword = "ceparola";

            connection = DriverManager.getConnection(url, dbUsername, dbPassword);

//            String query = "INSERT INTO person values('Bogdan', 'Test')";
            String query = "SELECT customerid FROM customers WHERE email=?;";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Display function to show the Resultset
            while (resultSet.next()) {
                customerId = resultSet.getInt("customerid");
                System.out.println(customerId);
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
        return customerId;
    }
}
