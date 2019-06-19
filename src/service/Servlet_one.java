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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("I am servlet_one ...method post");
		
		request.setCharacterEncoding("utf-8");
//=========================================================================================	
		String web_text = request.getParameter("text_area");
			
			String name = request.getParameter("name");
			String number = request.getParameter("number");
			String logic = request.getParameter("logic");
			String retoric = request.getParameter("retoric");
			String text_structure = request.getParameter("text_structure");
			
		if(logic != null) {lg = true;} else {lg = false;}
		
		//Samplable sample = new Sample();
//if-version_one
		if(name != null) {sample.set_name(true);} else {sample.set_name(false);}
		if(number != null) {sample.set_number(true);} else {sample.set_number(false);}
		if(logic != null) {sample.set_logic(true);} else {sample.set_logic(false);}
//if-version_two
		sample.set_retoric((retoric != null) ? true : false);
		sample.set_text_structure((text_structure != null) ? true : false);
		
		sample.set_text(web_text);
		
		Sample.sample = this.sample;//only for jsp-page
		
		
//		System.out.println(web_text);
//		
//		System.out.println(name);
//		System.out.println(number);
//		System.out.println(logic);
//		System.out.println(retoric);
//		System.out.println(text_structure);
//		
//		System.out.println("lg: " + lg);
//		
//	//-----------------------------------------
		System.out.println("++++++++++++++++++++++++++++++++++++");
		System.out.println("1" + sample.get_name());
		System.out.println("2" + sample.get_number());
		System.out.println("3" + sample.get_logic());
		System.out.println("4" + sample.get_retoric());
		System.out.println("5" + sample.get_text_structure());
		new Hamma(sample);
		//System.out.println(sample.get_logic_data());
		
//==========================================================================================
		
		Buffer.lenght = web_text.length();
		
		//Betta betta = new Betta(web_text, lg);
		
		response.sendRedirect("index.jsp");
		
//for consol desing
		System.out.println("======================================");
		System.out.println();
	}

}

//class Sample implements Samplable {
//	String text;
//	static Samplable sample;
//	
//	boolean name, number, logic, retoric, text_structure;
//	
//	HashSet name_data;
//	HashSet number_data;
//	HashMap logic_data;
//	
//	@Override
//	public void set_logic_data(HashMap logic_data) {
//		this.logic_data = logic_data;
//	}
//	@Override
//	public HashMap get_logic_data() {
//		return this.logic_data;
//	}
////-------------------------------------------------------------------------
//	@Override
//	public void set_text(String text) {
//		this.text = text;
//	}
//
//	@Override
//	public String get_text() {
//		return this.text;
//	}
//
//	@Override
//	public void set_name(boolean name) {
//		this.name = name;
//	}
//
//	@Override
//	public boolean get_name() {
//		return this.name;
//	}
//
//	@Override
//	public void set_number(boolean number) {
//		this.number = number;
//	}
//
//	@Override
//	public boolean get_number() {
//		return this.number;
//	}
//
//	@Override
//	public void set_logic(boolean logic) {
//		this.logic = logic;
//	}
//
//	@Override
//	public boolean get_logic() {
//		return this.logic;
//	}
//
//	@Override
//	public void set_retoric(boolean retoric) {
//		this.retoric = retoric;
//	}
//
//	@Override
//	public boolean get_retoric() {
//		return this.retoric;
//	}
//
//	@Override
//	public void set_text_structure(boolean text_structure) {
//		this.text_structure = text_structure;
//	}
//
//	@Override
//	public boolean get_text_structure() {
//		return this.text_structure;
//	}
//
//}

// interface Samplable {
//	 
//	 void set_text(String text);
//	 String get_text();
//	 
//	 void set_name(boolean name);
//	 boolean get_name();
//	 
//	 void set_number(boolean number);
//	 boolean get_number();
//	 
//	 void set_logic(boolean logic);
//	 boolean get_logic();
//	 
//	 void set_retoric(boolean retoric);
//	 boolean get_retoric();
//	 
//	 void set_text_structure(boolean text_structure);
//	 boolean get_text_structure();
//	 
//	 void set_logic_data(HashMap logic_data);
//	 HashMap get_logic_data();
//	 
//}
