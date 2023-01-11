package com.app.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class Test extends HttpServlet{
	public Test() {
		
	}
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException
	{
		PrintWriter pw=res.getWriter();
        pw.print("Hello");
	}
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		doGet(req,res);
	}
}
