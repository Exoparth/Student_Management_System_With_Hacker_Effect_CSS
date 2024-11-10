package com.ty;
import java.io.IOException;
import java.sql.Connection;
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

@WebServlet("/login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("uemail");
		String upwd = req.getParameter("upwd");
	
		Connection connection = ConnectionPool.getConnection();

		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM details WHERE uemail=?");
			HttpSession session = req.getSession(false);
			ps.setString(1, email);
//			if(session != null) {
//				session.invalidate();
//			}
//			
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				String dbPassword = rs.getString(5);
				if (dbPassword.equals(upwd)) {
					session=req.getSession(true);
					session.setAttribute("uemail",email);
					session.setAttribute("upwd",upwd);
					session.setAttribute("uname", rs.getString("uname"));
//					req.setAttribute("uname", rs.getString("uname"));
					req.setAttribute("uname", rs.getString("uname"));
					req.setAttribute("msg", "Login Succ");
					RequestDispatcher rd = req.getRequestDispatcher("dashboard.jsp");
					rd.forward(req, resp);
				}else {
					req.setAttribute("msg", "Wrong Password");
					RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
					rd.forward(req, resp);
				}
			} else {
				req.setAttribute("msg", "User Not Registered");
				RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
				rd.forward(req, resp);
			}
			
		} catch (SQLException e) {
			req.setAttribute("msg", "Something went wrong please try again later");
			RequestDispatcher rd = req.getRequestDispatcher("register.jsp");
			rd.forward(req, resp);
			e.printStackTrace();
		} finally {
			ConnectionPool.submitConnection(connection);
		}

	}
}
