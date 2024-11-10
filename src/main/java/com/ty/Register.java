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


@WebServlet("/register")
public class Register extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("uname");
		String email = req.getParameter("uemail");
		long phone = Long.parseLong(req.getParameter("uphone"));
		String std = req.getParameter("ustd");
		String password = req.getParameter("upwd");
		
		Connection connection = ConnectionPool.getConnection();
		try {			
			PreparedStatement ps = connection.prepareStatement("INSERT INTO details VALUES(?,?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, email);//If duplicate email id occured it will go the catch block(email=pk)
			ps.setLong(3, phone);
			ps.setString(4, std);
			ps.setString(5, password);
			
			int insert = ps.executeUpdate();
			if(insert>0) {
//				HttpSession session = req.getSession();
//				session.setAttribute("uemail", email);
//				session.setAttribute("uname", name);
//				session.setAttribute("upwd", password);
				req.setAttribute("msg", "registration succ");
				RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
				rd.forward(req, resp);
			}else {
				req.setAttribute("msg", "registration failed");
				RequestDispatcher rd=req.getRequestDispatcher("register.jsp");
				rd.forward(req, resp);
			}
		} catch (SQLException e) {
			req.setAttribute("msg", "Email is already registered");
			RequestDispatcher rd=req.getRequestDispatcher("register.jsp");
			rd.forward(req, resp);
			e.printStackTrace();
		}finally {
			ConnectionPool.submitConnection(connection);
		}
	}
}
