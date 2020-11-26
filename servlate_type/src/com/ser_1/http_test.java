package com.ser_1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class http_test extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("get...");
		String x= req.getParameter("email");
		String y= req.getParameter("pass");
		resp.getWriter().print(x);
		resp.getWriter().print(y);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("post...");
		
		String email=req.getParameter("email");
		String pass =req.getParameter("pass");
		System.out.println(email +"\t" + pass);
	}
}
