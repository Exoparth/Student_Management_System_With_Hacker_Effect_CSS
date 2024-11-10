package com.ty;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/DetailsServlet")
public class DetailsServlet extends HttpServlet {
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	try {
    		 HttpSession session = req.getSession(false);
    		 if (session != null) {
    	            String uemail = (String) session.getAttribute("uemail");
    	            String uname= (String) session.getAttribute("uname");
    	            if (uemail != null) {
    	                // Process the emailId as needed
//    	                resp.getWriter().println("Welcome, " + uname+ "!");
    		String url = "jdbc:postgresql://localhost:5432/student_management?user=postgres&password=root";
    		resp.setContentType("text/html");
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url);
			PreparedStatement ps = con.prepareStatement("SELECT * FROM details WHERE uemail= ?");
			ps.setString(1, uemail);
			ResultSet rs = ps.executeQuery();
			PrintWriter pw = resp.getWriter();
			//pw.println("<html><body><table border='1'><tr><td>Uname</td><td>Uemail</td><td>Uphone</td><td>Ustd</td><td>Upwd</td></tr>");
			while(rs.next()) {
				//pw.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td></tr>");
				req.setAttribute("uname", rs.getString("uname"));
				req.setAttribute("uemail", rs.getString("uemail"));
				req.setAttribute("uphone", rs.getString("uphone"));
				req.setAttribute("ustd", rs.getString("ustd"));
				req.getRequestDispatcher("personaldetails.jsp").forward(req, resp);
			}
			rs.close();
			ps.close();
			con.close();
			
    	            } else {
    	            	resp.getWriter().println("Email ID not found in Database.");
    	            }
    		 } else {
    			 resp.getWriter().println("No active session found. Please log in.");
    		 }
			//pw.println("</table></body></html>");
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
    }
}
