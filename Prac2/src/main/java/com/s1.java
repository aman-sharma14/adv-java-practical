package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class s1
 */
public class s1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public s1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection connection  = DriverManager.getConnection("jdbc:mariadb://localhost:3306/db","root","root");
			
			PreparedStatement ps = connection.prepareStatement("select * from employees where username=? and password=?");
			ps.setString(1, username);
			ps.setString(2,pwd);
			
			ResultSet rs = ps.executeQuery();
			HttpSession session = request.getSession();
			
			
			if(rs.next()) {
				session.setAttribute("res", rs.getString("department"));
			}
			else {
				session.setAttribute("res", "Invalid Credentials");
			}
			
			response.sendRedirect("dashboard.jsp");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
