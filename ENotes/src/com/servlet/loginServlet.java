package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.DAO.UserDAO;
import com.Db.DBConnect;
import com.User.UserDetails;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		UserDetails us=new UserDetails();
		us.setEmail(email);
		us.setPassword(password);
		
		
		UserDAO dao=new UserDAO(DBConnect.getConn());
		UserDetails user=dao.loginUser(us);
		
		PrintWriter out=response.getWriter();
		
		if(user!=null)
		{
		    HttpSession session=request.getSession();	
			response.sendRedirect("home.jsp");
		}
		else {
			HttpSession session=request.getSession();
			session.setAttribute("login-failed", "Invalid UserName or Password");
			response.sendRedirect("login.jsp");
		}
		
	}
	

}
