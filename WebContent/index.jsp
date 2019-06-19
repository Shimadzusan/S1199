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
            <a href  = 'index.html' style="color: white">Главная страница</a>
            </div>
            
            <div id="object_button">
            <a href  = 'localhost:8080\S1199\WebContent\theory.html' style="color: white">Теория</a>
            </div>
            
             <div style="color: white; background: #1C6956; height: 3%; width: 10%; float: left; border: solid 1px black; margin: 2px; text-align: center">
             <a href  = 'about_project.html' style="color: white">О проекте</a>
            </div>
            
            <div style="color: white; background: #1C6956; height: 3%; width: 10%; float: left; border: solid 1px black; margin: 2px; text-align: center">
            <a href  = 'contact.html' style="color: white">Контакты</a>
            </div>
            
            <!--
            <div style="color: white; width: 69.2%; height: 5%; background: #d4dee4; font-family: Roman">
<p>                <a href='http://localhost:8080/Webnew/theory.html'> Теория</a> О проекте Контакты Сравнить отчеты</p></div>
            -->
            <div style = "font-family: brush script mt"; align = "center"><h1>Simple analysis of the text</h1>
            </div>
            
<! modul_one: text_area and buttons>
            
            <div style="color: white; width: 69.2%; height: 300px; background: #46AF97; font-family: Roman; border: solid 1px black;  float: left">
                <p align="center"><textarea  name= "text_area" style= "background-color: #ffe; color: #930; cols: 100; rows: 65; width: 97%; height: 200px"></textarea></p>
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
    <br>&nbsp; &nbsp;
    <br>&nbsp; &nbsp;
    
            </div>
<! modul_three>
            <div style="height: 320px;">
            <br>&nbsp; &nbsp;
            <br>&nbsp; &nbsp;
            </div>
            
            
            <div id="object">
       
              <p style = "padding: 5px 30px;">РезультатыКаждый узел в языковом префиксном дереве содержит одну букву слова. Чтобы составить слово, нужно следовать по ветвям дерева, проходя по одной букве за раз. Дерево начинает ветвиться, когда порядок букв отличается от других имеющихся в нем слов или когда слово заканчивается. Каждый узел содержит букву (данные) и булево значение, которое указывает, является ли он последним в слове.
                <br>
                <br> Посмотрите на иллюстрацию и попробуйте составить слова. Всегда начинайте с корневого узла вверху и спускайтесь вниз. Это дерево содержит следующие слова: ball, bat, doll, do, dork, dorm, send, sense.
                </p>
				
<! modul_four: java_code, jsp>
			<%Samplable s = Sample.sample; %>	
                
<%out.println("all symbols: " + Buffer.lenght);%>
<br><%
out.println("all symbols without space: " + Buffer.lenght2);%>
<br><%
out.println("all words: " + (Buffer.lenght - Buffer.lenght2));%>
<br><%
out.println("all sentence: " + Buffer.lenght3);
//out.println(s.get_logic());

%><br>
   <%
   try{
   if(s.get_logic()) {
	   //HashMap m = new HashMap();
	   out.println("Логические связки:<br>");

out.println("конъюнкция: " + s.get_logic_data().get("конъюнкция(логическое \"и\"):    "));%>
<br><%
out.println("дизъюнкция: " + s.get_logic_data().get("дизъюнкция(логическое \"или\"):  "));%>
<br><%
out.println("отрицание: " + s.get_logic_data().get("отрицание(логическое \"не\"):    "));%> 
<br><%
out.println("импликация: " + s.get_logic_data().get("импликация(логическое \"если\"): "));
                }
   }
   catch (NullPointerException e) {
		e.printStackTrace();
		}
   finally{
	   
   }
%> 
<br>
<br>    
<%
   try{
   if(s.get_number()) {
	   out.println("Числа:");%><br><%
	 HashSet<String> set_x = s.get_number_data(); 
for(String z : set_x){
	%><br>
	<%
	out.println(z);
}	   

}
   }
   catch (NullPointerException e) {
		e.printStackTrace();
		}
   finally{
	   
   }
%>     
         
            </div>
            <br>
            </form>
        </body>  
</html>