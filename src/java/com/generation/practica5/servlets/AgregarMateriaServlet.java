/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.generation.practica5.servlets;

import com.generation.practica5.util.JDBCUtility;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ELBARBARO
 */
@WebServlet(name = "AgregarMateria", urlPatterns = {"/agregarMateria"})
public class AgregarMateriaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Connection conn = null;
        Statement stmt = null;
        try {
            
            String nombre = req.getParameter("nombreMateria");
            String descripcion = req.getParameter("descripcionMateria");
            String creditosMateria = req.getParameter("creditosMateria");
            
            conn = JDBCUtility.getConnection();
            stmt = conn.createStatement();
            
            //System.out.println("insert into materia values ('" + nombre + "', '" + descripcion + "', " + creditosMateria + ", now());");
            stmt.executeUpdate("insert into materia values (1,'" + nombre + "', '" + descripcion + "', " + creditosMateria + ", now())");
        } catch (SQLException ex) {
            Logger.getLogger(AgregarMateriaServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(stmt != null){
                try {
                    stmt.close();
                    JDBCUtility.closeConnection(conn);
                } catch (SQLException ex) {
                    Logger.getLogger(AgregarMateriaServlet.class.getName()).log(Level.SEVERE, null, ex);
                }   
            }
        }
    }
    
}
