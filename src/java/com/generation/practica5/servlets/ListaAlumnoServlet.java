/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.generation.practica5.servlets;

import com.generation.practica5.util.JDBCUtility;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
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

@WebServlet(name="ListaAlumno", urlPatterns = {"/lista"})
public class ListaAlumnoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        int port = 3306;
        
        // Este objeto es para establecer la conexión
        Connection conn = null;

        // Este objeto es para decir que accion quiero hacer a la bd
        Statement stmt = null;

        // Este objeto es para la salida del contenido de mi pagina
        PrintWriter salida = null;

        // Esta query es para traer la informacion desde la base de datos
        String query = "select * from alumno";

        // Indicar el tipo de contenido que va mostrar mi pagina: HTML
        resp.setContentType("text/html");

        // Inicilizando objeto salida para preparar el contenido de mi pagina web
        salida = resp.getWriter();
            
        try {
            
            // Estableciendo la conexion a la base de datos
            conn = JDBCUtility.getConnection();
            
            // Creando un objeto para realizar la ejecucion de consultas en la bd
            stmt = conn.createStatement();
            
            // Se hace la ejecucion de la consulta que regresa un conjunto de resultados llamado ResultSet
            ResultSet resultados = stmt.executeQuery(query);
            
            // Pregunto si hay filas siguientes en un conjunto de datos y posiciono
            while(resultados.next()){
                
                // A traves de los metodos get en un ResultSet puedo recuperar los valores de los campos
                int id_alumno = resultados.getInt("id_alumno");
                String nombre = resultados.getString("nombre");
                String apellido = resultados.getString("apellido");
                
                // Mostramos la informacion a traves del objeto de salida para mi vista web
                salida.println("<h4>" +  id_alumno + "</h4>");
                salida.println("<h3>" + nombre + " " + apellido + "</h3>");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ListaAlumnoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(stmt != null){
                    stmt.close();
                }
                JDBCUtility.closeConnection(conn);
            } catch (SQLException ex) {
                Logger.getLogger(ListaAlumnoServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
