<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" href="style.css">
 
<title>Insert title here</title>
</head>
	<body bgcolor = #d4dee4>
       
            
            <div id="object_button">
            <a href  = 'index.html' style="color: white">Главная страница</a>
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
            
            <!--
            <div style="color: white; width: 69.2%; height: 5%; background: #d4dee4; font-family: Roman">
<p>                <a href='http://localhost:8080/Webnew/theory.html'> Теория</a> О проекте Контакты Сравнить отчеты</p></div>
            -->
            <div style = "font-family: brush script mt"; align = "center"><h1>Simple analysis of the text</h1>
            </div>
<! modul_one>
            
            <div style="color: white; width: 69.2%; height: 45%; background: #46AF97; font-family: Roman; border: solid 1px black;  float: left">
                
                 <form method = "POST" action = "Servlet_one">
                
                <p align="center"><textarea  style= "background-color: #ffe; color: #930; name: comment; cols: 100; rows: 65; width: 97%; height: 80%"></textarea></p>
                 <p align="center"><input  onclick="my_f()" id="mybutton" type = "submit" value = "Проверить текст">&nbsp;
            <input type = "submit" value = "Загрузить файл"> &nbsp;<input type = "submit" value = "Сохранить отчет">
            </p>
            </form>
            </div>
<! modul_two>
            
             <script src="script.js"></script>
            
            
            <div style="color: white; width: 30%; height: 45%; background: #1C6956; font-family: Roman; border: solid 1px black; float: right"> <p><input name="dzen" type="checkbox" value="pdzen" >&nbsp; &nbsp; &nbsp; Имена</p>
    <p><input name="dzen" type="checkbox" value="pdzen" >&nbsp; &nbsp; &nbsp; Числа</p>
    <p><input name="dzen" type="checkbox" value="pdzen" >&nbsp; &nbsp; &nbsp; Логические связки</p>
    <p><input name="dzen" type="checkbox" value="pdzen" >&nbsp; &nbsp; &nbsp; Риторические словари</p>
    <p><input name="dzen" type="checkbox" value="pdzen" >&nbsp; &nbsp; &nbsp; Структура текста</p>
            </div>
<! modul_three>
            <div style="height: 46%;">
            </div>
            
            <div id="object">
                
                
                
                     <p style = "padding: 1px 30px;">РезультатыКаждый узел в языковом префиксном дереве содержит одну букву слова. Чтобы составить слово, нужно следовать по ветвям дерева, проходя по одной букве за раз. Дерево начинает ветвиться, когда порядок букв отличается от других имеющихся в нем слов или когда слово заканчивается. Каждый узел содержит букву (данные) и булево значение, которое указывает, является ли он последним в слове.
                
                    <br>
                <br> Посмотрите на иллюстрацию и попробуйте составить слова. Всегда начинайте с корневого узла вверху и спускайтесь вниз. Это дерево содержит следующие слова: ball, bat, doll, do, dork, dorm, send, sense.
                </p>
                
            </div>
            
        </body>     
   
    
      
</html>