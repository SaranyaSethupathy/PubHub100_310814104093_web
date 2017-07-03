package com.pubhub.controller;  

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pubhub.dao.UserDAO;
import com.pubhub.model.User;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String email_id = request.getParameter("email");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		session.setAttribute("registered user", name);

		User user = new User();

		user.setName(name);
		user.setEmail_id(email_id);
		user.setPassword(password);

		UserDAO dao = new UserDAO();

		try {

			dao.register(user);
			response.sendRedirect("login.jsp");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
