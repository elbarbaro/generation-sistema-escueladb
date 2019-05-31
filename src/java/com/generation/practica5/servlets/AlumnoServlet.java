/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.generation.practica5.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ELBARBARO
 */

@WebServlet(name = "AlumnoServlet", urlPatterns = {"/agregarAlumno"})
public class AlumnoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        String nombre = req.getParameter("nombreAlumno");
        String apellidos = req.getParameter("apellidoAlumno");
        String edad = req.getParameter("edadAlumno");
        
        
    }
    
}
