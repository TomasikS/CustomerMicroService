/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sovy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stefan.tomasik
 */
public class Database {

    private static final String QUERY = "SELECT C.id, C.meno, C.priezvisko, C.idkniha, O.id\n"
            + "FROM Zakaznik C\n"
            + "INNER JOIN book O\n"
            + "ON C.idkniha = O.id;";

    public List readData() throws SQLException {

        List<Customer> list = new ArrayList();
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bookstore", "postgres", "postgres");
                PreparedStatement preparedStatement = connection.prepareStatement(QUERY);) {
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

    public void insertData(Customer customer) {
        String url = "jdbc:postgresql://localhost:5432/bookstore";
        String user = "postgres";
        String password = "postgres";

        String query = "INSERT INTO Zakaznik(firstname, lastname) VALUES(?, ?)";

        try (Connection con = DriverManager.getConnection(url, user, password);
                PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, customer.getFirstname());
            pst.setString(2, customer.getLastname());
            pst.executeUpdate();

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(Database.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    public Customer getCustomerById(int id) {
        String url = "jdbc:postgresql://localhost:5432/bookstore";
        String user = "postgres";
        String password = "postgres";
        String query = "select * from Zakaznik where id=" + id;
        Customer customer = null;
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bookstore", "postgres", "postgres");
                PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int idcustomer = rs.getInt("id");
                String firstname = rs.getString(2);
                String lastname = rs.getString(3);
                int idbook = rs.getInt(4);
                
                
                 customer = (new Customer(id, firstname, lastname, idbook));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customer;
    }

    void remove(int id) {
       
         String url = "jdbc:postgresql://localhost:5432/bookstore";
        String user = "postgres";
        String password = "postgres";
        String query = "delete  from Zakaznik where id=" + id;
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bookstore", "postgres", "postgres");
                PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            ResultSet rs = preparedStatement.executeQuery();

          /*  while (rs.next()) {
                int idcustomer = rs.getInt("id");
                String firstname = rs.getString(2);
                String lastname = rs.getString(3);
                int idbook = rs.getInt(4);
                
                
                  
            }*/
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
        
        
        
    }

}
