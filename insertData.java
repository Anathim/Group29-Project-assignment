
package com.tutoringapp.tutoringapp;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class insertData extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet insertData</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet insertData at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        Connection con = null;
        try {
            con = DriverManager.getConnection("url", "username", "password");
        } catch (SQLException ex) {
            Logger.getLogger(insertData.class.getName()).log(Level.SEVERE, null, ex);
        }
        Statement stmt;
        try {
            stmt = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(insertData.class.getName()).log(Level.SEVERE, null, ex);
        }
        String n = " ", s= " ", pn = " ", e = " ", p = " ";
        n = request.getParameter("Name");
        s = request.getParameter("Surname");
        pn = request.getParameter("Phone");
        e = request.getParameter("Email");
        p = request.getParameter("Password");
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            try {
                con = DriverManager.getConnection("jdbc:derby://localhost:1527/users", "Anathim", "Anathim");
            } catch (SQLException ex) {
                Logger.getLogger(insertData.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                stmt = con.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(insertData.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            stmt = executeUpdate("insert into users value('"+n+"', '"+s+"', '"+pn+"', '"+e+"', '"+p+"')");
            
            pw.print("<h1>Your account is created successfully!</h1>");
        }
        
        catch(Exception oe) {
            pw.println("Sorry! Try again later.");
        }
        
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "\"Anathi\", \"Mhlom\", \"0714785486\", \"amhlom@gmail.com\", \"Anathimhlom\"";
    }// </editor-fold>

    private Statement executeUpdate(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
