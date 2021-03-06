package com.webhook;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import java.lang.*;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.*;

// Extend HttpServlet class to create Http Servlet
@WebServlet("/welcome")
public class MyServletDemo extends HttpServlet {

	private String mymsg;

	public void init() throws ServletException {
		mymsg = "Hello World!";
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Setting up the content type of webpage
		response.setContentType("text/html");

		// Writing message to the web page
		PrintWriter out = response.getWriter();
		out.println("<h1>" + mymsg + "</h1>");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException

	{
		PrintWriter out = res.getWriter();
		String login = req.getParameter("uname");
		String password = req.getParameter("password");
		out.println("Your login ID is: ");
		out.println(login);
		out.println("Your password is: ");
		out.println(password);
		out.close();
		System.out.println("---------------------ReqStart-------------------------");
		for (Enumeration<?> names = req.getHeaderNames(); names.hasMoreElements(); ) {
			String name = (String) names.nextElement();
		    for (Enumeration<?> values = req.getHeaders(name); values.hasMoreElements(); ) {
		    	System.out.println(values.nextElement() );
		    }
		}
		

	}

	public void destroy() {
		/*
		 * leaving empty for now this can be used when we want to do something
		 * at the end of Servlet life cycle
		 */
	}

}
