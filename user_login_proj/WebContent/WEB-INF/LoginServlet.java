
package com.loginApp.model;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loginApp.Service.UserDao;
/**
 * @author bridgeit satyendra Singh In this class using Http servlet for login
 *         details. take user information from user (id and password) If user id
 *         and password is correct the saved into database through Hibernate
 *         configuration. then show success message. If user id and password
 *         Does not match then page go to fail jsp page, Where Show fail
 *         massage.
 */
public class LoginServlet extends HttpServlet {

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
		//System.out.println(user.getUser_id());
	//	System.out.println(user.getUser_password());
		
		if (user!=null) {
			System.out.println("hi");
			RequestDispatcher rdp = req.getRequestDispatcher("/success.jsp");
			rdp.forward(req, resp);
		} else {
			req.getRequestDispatcher("/fail.jsp").forward(req, resp);
		}

	}
}
