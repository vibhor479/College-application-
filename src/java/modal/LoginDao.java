/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Shashank
 */
public class LoginDao {  
public static boolean validate(String name,String password){  
boolean status=false;  
try{  
Class.forName("com.mysql.cj.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/project348?useSSL=false&verifyServerCertificate=false&allowMultiQueries=true","root","MyNewPass");  
    
      
PreparedStatement ps=con.prepareStatement(  
"select * from signup where name=? and Password=?");  
ps.setString(1,name);  
ps.setString(2,password);  
      
ResultSet rs=ps.executeQuery();  
status=rs.next();  
          
}catch(Exception e){System.out.println(e);}  
return status;  
}  
}  
