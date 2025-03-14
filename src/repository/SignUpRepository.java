package repository;

import java.sql.*;

public class SignUpRepository {

    public String signUp(String email, String firstName, String lastName, String phoneNo, String address, int customerId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Integer rowsAffected = 0;
        try {
            String url = "jdbc:postgresql://localhost:5432/MyBookShop";
            String dbUsername = "postgres";
            String dbPassword = "ceparola";

            connection = DriverManager.getConnection(url, dbUsername, dbPassword);

//            String query = "INSERT INTO person values('Bogdan', 'Test')";
            String query = "INSERT INTO Customers (CustomerID, FirstName, LastName, Email, PhoneNumber, Address) VALUES (?, ?, ?, ?, ?, ?);";
            preparedStatement = connection.prepareStatement(query);


            preparedStatement.setInt(1, customerId);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, phoneNo);
            preparedStatement.setString(6, address);


            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return "Error at DB level";
        } finally {
            // Close resources in a finally block to ensure they are closed even if an exception occurs
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
                return rowsAffected + " Rows Affected. Success! Connection Closed!";
            } catch (SQLException e) {
                e.printStackTrace();
                return "Error at DB level";
            }
        }
    }

    public int getNextIndex()
    {
        int index=50;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            String url =  "jdbc:postgresql://localhost:5432/MyBookShop";
            String dbUsername = "postgres";
            String dbPassword = "ceparola";

            connection = DriverManager.getConnection(url, dbUsername, dbPassword);

//            String query = "INSERT INTO person values('Bogdan', 'Test')";
            String query = "SELECT customerid FROM customers WHERE customerid>= ALL (SELECT customerid from customers);";
            preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            // Display function to show the Resultset
            while (resultSet.next()) {
                index = resultSet.getInt("customerid");
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
        return (index+1);
    }

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
}
