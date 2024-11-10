package com.ty;

import java.io.IOException;
import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);  // Get session, don't create a new one if it doesn't exist
	    
	    if (session != null) {
	        String uemail = (String) session.getAttribute("uemail");  // Retrieve emailId from session

	        if (uemail != null) {
	            // Proceed with using emailId
//	            resp.getWriter().println("Email ID from session: " + uemail);
	            String uname= req.getParameter("uname");
	            //String uemail= req.getParameter("uemail");
	            long uphone= Long.parseLong(req.getParameter("uphone"));
	            String ustd= req.getParameter("ustd");
	            String upwd= req.getParameter("upwd");
	            Connection connection = ConnectionPool.getConnection();
	            try {
	            	String sql = "UPDATE details SET uname=?,uphone=?,ustd=?,upwd=? WHERE uemail=?";
	            	PreparedStatement stmt = connection.prepareStatement(sql);
	            	stmt.setString(1, uname);
	            	stmt.setLong(2, uphone);
	            	stmt.setString(3, ustd);
	            	stmt.setString(4, upwd);
	            	stmt.setString(5, uemail);
	            	int rowsUpdated = stmt.executeUpdate();
	            	if (rowsUpdated > 0) {
	            		resp.getWriter().println("Student information updated successfully.");
	            		req.setAttribute("msg", "Your Details has been Updated");
	            		session.setAttribute("uname", uname);
	            		
//                System.out.println(uemail);
	            		RequestDispatcher rd = req.getRequestDispatcher("updatedetails.jsp");
	            		rd.forward(req, resp);
	            	} else {
	            		resp.getWriter().println("No student found with the provided email ID.");
	            	}
	            } catch (SQLException e) {
	            	// TODO Auto-generated catch block
	            	e.printStackTrace();
	            }
	        } else {
	            resp.getWriter().println("No email ID found in session.");
	        }
	    } else {
	        resp.getWriter().println("Session not found. Please log in first.");
	    }
	}
}
