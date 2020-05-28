package com.web.db;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Bankservlet
 */
public class Bankservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = "root";
		String pass = "database";
		
		String jdbcurl = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
		String driver = "com.mysql.jdbc.Driver";
		
		try {
			
			PrintWriter out = response.getWriter();
			out.println("connection: "+jdbcurl);
			Class.forName(driver);
			
			Connection con = DriverManager.getConnection(jdbcurl, user, pass);
			out.println("Success!!");
			con.close();
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

	}

