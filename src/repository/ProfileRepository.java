package repository;

import model.BookModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfileRepository {

    public boolean delete( int customerId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Integer rowsAffected = 0;
        try {
            String url = "jdbc:postgresql://localhost:5432/MyBookShop";
            String dbUsername = "postgres";
            String dbPassword = "ceparola";

            connection = DriverManager.getConnection(url, dbUsername, dbPassword);

//            String query = "INSERT INTO person values('Bogdan', 'Test')";
            String query = "DELETE FROM customers WHERE customerid=?";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, customerId);


            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();

        } finally {
            // Close resources in a finally block to ensure they are closed even if an exception occurs
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
        if(rowsAffected==0)
            return false;
        else return true;
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

    public List<BookModel> getData(String genre){
        List<BookModel> books=new ArrayList<>();
        BookModel bookModel =new BookModel();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            String url = "jdbc:postgresql://localhost:5432/MyBookShop";
            String dbUsername = "postgres";
            String dbPassword = "ceparola";

            connection = DriverManager.getConnection(url, dbUsername, dbPassword);

            String query ;
            if(genre=="All"){
                query = "SELECT * FROM books;";
                preparedStatement = connection.prepareStatement(query);

            }
            else{
                query = "SELECT * FROM books WHERE genre=?;";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1,genre);
            }

            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println(resultSet);

            // Display function to show the Resultset
            while (resultSet.next()) {
                int bookId=resultSet.getInt("bookid");
                String title=resultSet.getString("title");
                String author=resultSet.getString("author");
                String genre1=resultSet.getString("genre");
                String isbn=resultSet.getString("isbn");
                int publicationYear=resultSet.getInt("publicationyear");
                int price=resultSet.getInt("price");
                int stockQuantity=resultSet.getInt("stockquantity");

                BookModel newBook= new BookModel(bookId, title, author, genre1, isbn, publicationYear, price, stockQuantity);
                books.add(newBook);
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
        return books;
    }

    public int getStockAmount(String title)
    {
       int amount=0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            String url = "jdbc:postgresql://localhost:5432/MyBookShop";
            String dbUsername = "postgres";
            String dbPassword = "ceparola";

            connection = DriverManager.getConnection(url, dbUsername, dbPassword);


//            String query = "INSERT INTO person values('Bogdan', 'Test')";
            String query = "SELECT stockquantity FROM books WHERE title=?;";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, title);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Display function to show the Resultset
            while (resultSet.next()) {
        amount=resultSet.getInt("stockquantity");
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
        return amount;
    }
}
