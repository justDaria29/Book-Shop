package repository;

import java.sql.*;

public class UpdateRepository {

    public String update(String email, String firstName, String lastName, String phoneNo, String address, int customerId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Integer rowsAffected = 0;
        try {
            String url = "jdbc:postgresql://localhost:5432/MyBookShop";
            String dbUsername = "postgres";
            String dbPassword = "ceparola";

            connection = DriverManager.getConnection(url, dbUsername, dbPassword);

//            String query = "INSERT INTO person values('Bogdan', 'Test')";
            String query = "UPDATE customers SET firstname=?, lastname=?, email=?, phonenumber=?, address=? WHERE customerid=?;";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, phoneNo);
            preparedStatement.setString(5, address);
            preparedStatement.setInt(6, customerId);
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


    public Customer getCostumer(int customerId){
        Connection connection = null;
        Customer customer=new Customer();
        PreparedStatement preparedStatement = null;
        Integer rowsAffected = 0;
        try {
            String url = "jdbc:postgresql://localhost:5432/MyBookShop";
            String dbUsername = "postgres";
            String dbPassword = "ceparola";

            connection = DriverManager.getConnection(url, dbUsername, dbPassword);

//            String query = "INSERT INTO person values('Bogdan', 'Test')";
            String query = "SELECT * FROM customers WHERE customerid=?;";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, customerId);

            ResultSet resultSet = preparedStatement.executeQuery();


            // Display function to show the Resultset
            while (resultSet.next()) {
                customer.setCustomerId(customerId);
                String firstName = resultSet.getString("firstname");
                customer.setFirstName(firstName);
                String lastName = resultSet.getString("lastname");
                customer.setLastName(lastName);
                String email = resultSet.getString("email");
                customer.setEmail(email);
                String phoneNo = resultSet.getString("phonenumber");
                customer.setPhoneNo(phoneNo);
                String address = resultSet.getString("address");
                customer.setAddress(address);
                System.out.println("First name: "+ firstName);
                System.out.println("Last name: "+ lastName);
                System.out.println("Email: "+ email);
                System.out.println("Phone number: "+ phoneNo);
                System.out.println("Address: "+ address);
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
        return customer;
    }
}
