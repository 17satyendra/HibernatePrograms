package com.servllet.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loginApp.Service.UserDao;
import com.loginApp.model.User;

public class Login extends HttpServlet {
	User user = null;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, NumberFormatException {
		String user_id = req.getParameter("username").trim();
		String password = req.getParameter("password").trim();
		req.setAttribute("u", user_id);
		req.setAttribute("p", password);

		System.out.println(user_id + " " + password);

		UserDao dao = new UserDao();

		user = dao.fetchByName(user_id);
		// System.out.println(user.getUser_id());
		// System.out.println(user.getUser_password());

		if (user != null) {
			System.out.println("hi");
			RequestDispatcher rdp = req.getRequestDispatcher("/success.jsp");
			rdp.forward(req, resp);
		} else {
			req.getRequestDispatcher("/fail.jsp").forward(req, resp);
		}

	}
}
