package com.firstservlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class first implements Servlet {

	

	@Override
	public void destroy() {
		System.out.println("destory....");
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return "firstservel";
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("initliies....");
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("srevices....");
		
	}

}
