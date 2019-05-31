/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.generation.practica5.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ELBARBARO
 */
public class JDBCUtility {
    
    public static Connection getConnection(){
        Connection conn = null;
        String urlConnection = "jdbc:mysql://localhost:3306/pruebageneration?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        try {
            //DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(urlConnection, "root", "root");
            System.out.println("Se conecto a la base de datos");
        } catch (SQLException ex) {
            System.out.println("Error al conectar con base de datos");
            ex.printStackTrace();
            //Logger.getLogger(JDBCUtility.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(JDBCUtility.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
    public static void closeConnection(Connection connection) throws SQLException{
        if(connection != null){
                connection.close();
                connection = null;
                System.out.println("Se cerro la conexión a la base de datos");
        }
    }
    
    public static void getConnection1(){
        
        
    }
}
