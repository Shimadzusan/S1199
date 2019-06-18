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
       
    public Servlet_one() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("I am servlet_one!");
		System.out.println("method post");
		
		request.setCharacterEncoding("utf-8");
		String user = request.getParameter("comment");
		String text = request.getParameter("text");
		//response.setContentType("text/html;charset=utf-8");
		System.out.println(user);
		Buffer.lenght = user.length();
		//PrintWriter out = response.getWriter();
		
		response.sendRedirect("index.jsp");
	}

}
