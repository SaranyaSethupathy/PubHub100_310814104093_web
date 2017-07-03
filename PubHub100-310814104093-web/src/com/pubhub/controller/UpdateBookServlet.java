package com.pubhub.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pubhub.dao.BookDAO;
import com.pubhub.model.Book;


@WebServlet("/UpdateBookServlet")
public class UpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =Integer.parseInt( request.getParameter("id"));
		String name = request.getParameter("name");
	       
	      
	       
	      Book book = new Book();
	      book.setId(id);
	       book.setName(name);
	       
	      
	       
	       BookDAO dao = new BookDAO();
	       try {
			dao.update(book);
			response.sendRedirect("home.jsp");
		} catch (Exception e) {
	
			e.printStackTrace();
		}
	}
	

}
