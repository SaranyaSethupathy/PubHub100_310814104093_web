package com.pubhub.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pubhub.dao.BookDAO;
import com.pubhub.model.Book;

@WebServlet("/FindByIdServlet")
public class FindByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		Book book = new Book();

		book.setId(id);

		BookDAO dao = new BookDAO();

		try {
			Book book1 = dao.findById(id);
			RequestDispatcher rd = request.getRequestDispatcher("searchresult.jsp");
			request.setAttribute("book", book1);
			PrintWriter out = response.getWriter();
			out.print("hello");
			rd.forward(request, response);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
