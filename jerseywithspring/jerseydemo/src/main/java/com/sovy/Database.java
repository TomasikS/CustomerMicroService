/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sovy;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author stefan.tomasik
 */
public class Database {

    public Connection createConnection() throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        Connection connection;
        Properties properties = new Properties();
        properties.load(new java.io.FileInputStream("C://Users//stefan.tomasik//Documents//jerseywithspring//jerseydemo//src//main//resources//application.properties"));
        String url = properties.getProperty("host");
        String user = properties.getProperty("username");;
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        Class.forName(driver);

        connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    public List readData() throws SQLException, ClassNotFoundException, IOException {
        String QUERY = "SELECT C.id, C.meno, C.priezvisko, C.idkniha, O.id\n"
                + "FROM Zakaznik C\n"
                + "INNER JOIN book O\n"
                + "ON C.idkniha = O.id;";
        List<Customer> list = new ArrayList();
        //  try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bookstore", "postgres", "postgres");
        Connection connection = createConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
        {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String firstname = rs.getString(2);
                String lastname = rs.getString(3);
                int idbook = rs.getInt(4);
                list.add(new Customer(id, firstname, lastname, idbook));
            }
        }
        return list;
    }

    public void insertData(Customer customer) throws SQLException, ClassNotFoundException, IOException {
        /*  String url = "jdbc:postgresql://localhost:5432/bookstore";
        String user = "postgres";
        String password = "postgres";*/

        String query = "INSERT INTO Zakaznik(firstname, lastname) VALUES(?, ?)";
        Connection connection = createConnection();
        //   try (Connection con = DriverManager.getConnection(url, user, password);
        PreparedStatement pst = connection.prepareStatement(query);

        //) 
        pst.setString(1, customer.getFirstname());
        pst.setString(2, customer.getLastname());
        pst.executeUpdate();

    }

    public Customer getCustomerById(int id) throws SQLException, ClassNotFoundException, IOException {
        /*  String url = "jdbc:postgresql://localhost:5432/bookstore";
        String user = "postgres";
        String password = "postgres";*/
        String query = "select * from Zakaznik where id=" + id;
        Customer customer = null;
        Connection connection = createConnection();
        // try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bookstore", "postgres", "postgres");
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        //) {
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            int idcustomer = rs.getInt("id");
            String firstname = rs.getString(2);
            String lastname = rs.getString(3);
            int idbook = rs.getInt(4);

            customer = (new Customer(id, firstname, lastname, idbook));
        }

        return customer;
    }

    void remove(int id) throws SQLException, ClassNotFoundException, IOException {

        /*  String url = "jdbc:postgresql://localhost:5432/bookstore";
        String user = "postgres";
        String password = "postgres";*/
        String query = "delete  from Zakaznik where id=" + id;
        ///try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bookstore", "postgres", "postgres");
        Connection connection = createConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        {
            ResultSet rs = preparedStatement.executeQuery();

            /*  while (rs.next()) {
                int idcustomer = rs.getInt("id");
                String firstname = rs.getString(2);
                String lastname = rs.getString(3);
                int idbook = rs.getInt(4);
                
                
                  
            }*/
        }

    }

}
