package com.pubhub.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pubhub.dao.BookDAO;
import com.pubhub.model.Book;




@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		   String name = request.getParameter("name");
	       int price =Integer.parseInt( request.getParameter("price"));
	       
	      Book book = new Book();
	       
	       book.setName(name);
	       book.setPrice(price);
	      
	       
	       BookDAO dao = new BookDAO();
	       try {
			dao.save(book);
			response.sendRedirect("home.jsp");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
			
	}

}
