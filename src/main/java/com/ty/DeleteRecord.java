package com.ty;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/DeleteRecord")
public class DeleteRecord extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null) {
	        String uemail = (String) session.getAttribute("uemail");  // Retrieve emailId from session

	        if (uemail != null) {
	            // Proceed with using emailId
	            Connection connection = ConnectionPool.getConnection();
	            try {
	            	String sql = "DELETE FROM details WHERE uemail=?";
					PreparedStatement stmt = connection.prepareStatement(sql);
					stmt.setString(1, uemail);
					int rowsUpdated = stmt.executeUpdate();
					if (rowsUpdated > 0) {
//	            		resp.getWriter().println("");
	            		req.setAttribute("msg", "Student information Deleted successfully.");
//                System.out.println(uemail);
	            		RequestDispatcher rd = req.getRequestDispatcher("recorddeleted.jsp");
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
	}
}
