package com.pubhub.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pubhub.dao.UserDAO;
import com.pubhub.model.User;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String email_id = request.getParameter("email");
	       String password = request.getParameter("password");
	       
	       
	       User user = new User();
	       user.setEmail_id(email_id);
	       user.setPassword(password);
	       
	       UserDAO dao = new UserDAO();
	       try { 
	      
	    	  
			boolean flag = dao.login(user);
			//response.sendRedirect("failure.jsp");
			if(flag)
			{
				response.sendRedirect("success.jsp");
				
			}
			else
			{
				response.sendRedirect("failure.jsp");
				
			}
		} catch (Exception e) {
	
			e.printStackTrace();
			//response.sendRedirect("failure.jsp");
		}
	}
	}

