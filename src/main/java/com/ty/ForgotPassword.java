package com.ty;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ForgotPassword")
public class ForgotPassword extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uemail = req.getParameter("uemail");
		
		System.out.println(uemail);
		String upwd = req.getParameter("upwd");
		System.out.println(upwd);
		 resp.setContentType("text/html");
	        PrintWriter out = resp.getWriter();
	        Connection connection = ConnectionPool.getConnection();
		try{
			
			
			PreparedStatement ps = connection.prepareStatement("UPDATE details SET upwd=? WHERE uemail=?");
			ps.setString(1, upwd);
			ps.setString(2, uemail);
			int rowsUpdated = ps.executeUpdate();
        	if (rowsUpdated > 0) {
        		resp.getWriter().println("Student information updated successfully.");
        		RequestDispatcher rd = req.getRequestDispatcher("passwordUpdated.jsp");
        		rd.forward(req, resp);
        	} else {
        		resp.getWriter().println("No student found with the provided email ID.");
        	}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
