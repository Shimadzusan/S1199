package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servlet_one")
public class Servlet_one extends HttpServlet {
	private static final long serialVersionUID = 1L;
	boolean lg = false;
       
    public Servlet_one() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("I am servlet_one!");
		System.out.println("method post");
		
		request.setCharacterEncoding("utf-8");
		String web_text = request.getParameter("comment");
		
		String name = request.getParameter("family");
		String logic = request.getParameter("logic");
		String number = request.getParameter("number");
		
		if(logic != null)lg = true;
		
		//System.out.println(log);
		System.out.println(web_text);
		System.out.println(name);
		Buffer.lenght = web_text.length();
		
		Betta betta = new Betta(web_text, lg);
		
		response.sendRedirect("index.jsp");
	}

}
