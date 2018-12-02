/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myPack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Shashank
 */
public class leave extends HttpServlet {

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
        PrintWriter out = response.getWriter() ;
               
          
String n=request.getParameter("textname");  
String p=request.getParameter("fathername");  
String e=request.getParameter("cgpa");  
String c=request.getParameter("per");    
String x=request.getParameter("city");  
String d=request.getParameter("state");
String m=request.getParameter("xx");  
String f=request.getParameter("yy");  

          
try{  
Class.forName("com.mysql.cj.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/project348?useSSL=false&verifyServerCertificate=false&allowMultiQueries=true","root","MyNewPass");  
  
PreparedStatement ps=con.prepareStatement(  
"insert into signup values(?,?,?,?,?,?,?,?)");  
  
ps.setString(1,n);  
ps.setString(2,p);  
ps.setString(3,e);  
ps.setString(4,c);  
ps.setString(7,x);  
ps.setString(8,d);
ps.setString(9,m);  
ps.setString(10,f);  
          
int i=ps.executeUpdate();  
if(i>0)  
    out.println("Leave is submuitted");
request.getRequestDispatcher("/leave.html").forward(request, response);
      
          
}
catch (Exception e2) {
    System.out.println(e2);
}  
          
out.close();  
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
        return "Short description";
    }
}


    