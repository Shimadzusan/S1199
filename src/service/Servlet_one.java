package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servlet_one")
public class Servlet_one extends HttpServlet {
	private static final long serialVersionUID = 1L;
	boolean lg = false;
	Samplable sample;
       
    public Servlet_one() {
        super();
        sample = new Sample();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("I am servlet_one ...method post(marker)");
		request.setCharacterEncoding("utf-8");
		String web_text = request.getParameter("text_area") + " ";//плюс пробел - временный костыль
			
			String name = request.getParameter("name");
			String number = request.getParameter("number");
			String logic = request.getParameter("logic");
			String retoric = request.getParameter("retoric");
			String text_structure = request.getParameter("text_structure");
			
		if(logic != null) {lg = true;} else {lg = false;}
		
//if-version_one
		if(name != null) {sample.set_name(true);} else {sample.set_name(false);}
		if(number != null) {sample.set_number(true);} else {sample.set_number(false);}
		if(logic != null) {sample.set_logic(true);} else {sample.set_logic(false);}
//if-version_two
		sample.set_retoric((retoric != null) ? true : false);
		sample.set_text_structure((text_structure != null) ? true : false);
		sample.set_text(web_text);
		Sample.sample = this.sample;//only for jsp-page
		
		System.out.println("++++++++++++++++++++++++++++++++++++");
		System.out.println("1" + sample.get_name());
		System.out.println("2" + sample.get_number());
		System.out.println("3" + sample.get_logic());
		System.out.println("4" + sample.get_retoric());
		System.out.println("5" + sample.get_text_structure());
		System.out.println("Print cash check");
		new Hamma(sample);
		
		Buffer.lenght = web_text.length();
		response.sendRedirect("index.jsp");
		
//for consol desing
		System.out.println("======================================");
		System.out.println();
	}

}
