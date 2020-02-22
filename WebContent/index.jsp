<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import = "service.*"  %>
     <%@ page import = "java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="style.css">
</head>
	<body bgcolor = #d4dee4>
		<form method = "POST" action = "Servlet_one">
       
            <div id="object_button">
            <a href  = 'index.jsp' style="color: white">Главная страница</a>
            </div>
            
            <div id="object_button">
            <a href  = 'theory.html' style="color: white">Теория</a>
            </div>
            
             <div style="color: white; background: #1C6956; height: 3%; width: 10%; float: left; border: solid 1px black; margin: 2px; text-align: center">
             <a href  = 'about_project.html' style="color: white">О проекте</a>
            </div>
            
            <div style="color: white; background: #1C6956; height: 3%; width: 10%; float: left; border: solid 1px black; margin: 2px; text-align: center">
            <a href  = 'contact.html' style="color: white">Контакты</a>
            </div>
            
            <div style = "font-family: brush script mt"; align = "center"><h1>Simple analysis of the text</h1>
            </div>
            
<! modul_one: text_area and buttons>
            
            <div style="color: white; width: 69.2%; height: 300px; background: #46AF97; font-family: Roman; border: solid 1px black;  float: left">
                <p align="center"><textarea  name= "text_area" style= "background-color: #ffe; color: #930; cols: 100; rows: 65; width: 27%; height: 500px"></textarea></p>
                 <p align="center"><input  onclick="my_f()" id="mybutton" type = "submit" value = "Проверить текст">&nbsp;
            <input type = "submit" value = "Загрузить файл"> &nbsp;<input type = "submit" value = "Сохранить отчет"></p>
            </div>

<! modul_two>
            
             <script src="script.js"></script>
            
            
    <div style="color: white; width: 30%; height: 300px; background: #1C6956; font-family: Roman; border: solid 1px black; float: right">
    
    <p><input name="name" type="checkbox" value="true" >&nbsp; &nbsp; &nbsp; Имена</input></p>
    <p><input name="number" type="checkbox" value="true" >&nbsp; &nbsp; &nbsp; Числа</p>
    <p><input name="logic" type="checkbox" value="true" >&nbsp; &nbsp; &nbsp; Логические связки</p>
    <p><input name="retoric" type="checkbox" value="true" >&nbsp; &nbsp; &nbsp; Риторические словари</p>
    <p><input name="text_structure" type="checkbox" value="true" >&nbsp; &nbsp; &nbsp; Структура текста</p>
   
    </div>
			
<! modul_three>
    <div style="height: 320px;">
        <br>&nbsp; &nbsp;
         <br>&nbsp; &nbsp;
    </div>

    <div id="object">   
        <p style = "padding: 5px 30px;">Результаты: Каждый узел в языковом префиксном дереве содержит одну букву слова. Чтобы составить слово, нужно следовать по ветвям дерева, проходя по одной букве за раз. Дерево начинает ветвиться, когда порядок букв отличается от других имеющихся в нем слов или когда слово заканчивается. Каждый узел содержит букву (данные) и булево значение, которое указывает, является ли он последним в слове.
        <br>
        <br> Общая информация:
		</p>
				
<! modul_four: java_code, jsp>

	<%Samplable jsp_sample = Sample.sample; %>	
					
	<%out.println("all symbols: " + Buffer.lenght + ", all symbols without space: " + Buffer.lenght2);%>
	<br><%
	out.println("all words: " + (Buffer.lenght - Buffer.lenght2));%>
	<br><%
	out.println("all sentence: " + Buffer.lenght3);
	//out.println(s.get_logic());
	%><br><br>

	Логические связки:<br><br>
 	<%
	   try{
		   if(jsp_sample.get_logic()) {
			out.println("конъюнкция: " + jsp_sample.get_logic_data().get("конъюнкция(логическое \"и\"):    "));%>
			<br><%
			out.println("дизъюнкция: " + jsp_sample.get_logic_data().get("дизъюнкция(логическое \"или\"):  "));%>
			<br><%
			out.println("отрицание: " + jsp_sample.get_logic_data().get("отрицание(логическое \"не\"):    "));%> 
			<br><%
			out.println("импликация: " + jsp_sample.get_logic_data().get("импликация(логическое \"если\"): "));%>
			<br><br>
			<%                
			}
		}
	   catch (NullPointerException e) {
			e.printStackTrace();
		}
	   finally {
	   }
	%>

	Числа:
	<br>    
	<%
		try {
		   if(jsp_sample.get_number()) {
			 HashSet<String> set_number = jsp_sample.get_number_data(); 
				for(String element : set_number){
					%><br>
					<%
					out.println(element);
				}
	%><br><%				
			}
		} catch (NullPointerException e) {
				e.printStackTrace();
			}
		   finally {   
		   }
	%>

	Имена:
		<br>    
		<%
			try {
			   if(jsp_sample.get_name()) {
				 HashSet<String> set_name = jsp_sample.get_name_data(); 
					for(String element : set_name){
						%><br>
						<%
						out.println(element);
					}	   
				}
			} catch (NullPointerException e) {
					e.printStackTrace();
				}
			   finally {   
			   }
			%>   

	Структура текста:
		<br>    
		<%
			try {
			   if(jsp_sample.get_text_structure()) {
				 ArrayList<String> sorted_list = jsp_sample.get_text_structure_data(); 
				 //TreeMap<String, Integer> sorted_map = jsp_sample.get_text_structure_data(); 
					for(String element : sorted_list){
						%><br>
						<%
						out.println(element);
					}
					/* map.entrySet().stream()
			        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()) 
			        .forEach(System.out::println); // или любой другой конечный метод*/
				}
			} catch (NullPointerException e) {
					e.printStackTrace();
				}
			  finally {   
			   }
			%>   
         
            </div>
            <br>
           </form>
       </body>  
</html>