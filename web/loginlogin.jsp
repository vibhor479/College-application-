


<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <%
            String uname=request.getParameter("email");
           String password =request.getParameter("password");
           try{
	
               String myUrl="jdbc:mysql://localhost/acadview";
		//step 1:
		Class.forName("com.mysql.jdbc.Driver");
      		//step 2:
		Connection conn=DriverManager.getConnection(myUrl,"root","");
                String query="Select Email,Password from signup where your email= '"+uname+"' and password='"+password+"'";
		//step 3:
		Statement st=conn.createStatement();
		//step 4:
		ResultSet rs =st.executeQuery(query);
		if(rs.next()){
			out.println("Logged in successfully");
		}  
                else
                out.println("Invalid username or password");
		//step 5
		st.close();
		}
		catch(Exception e){
			System.out.println("Got an exception! ");
			System.out.println(e.getMessage());
		}
           %>
    </body>
</html>
