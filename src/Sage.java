import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Sage {
	/* Блок основных переменных:
	 * количество символов(с пробелами и без)
	 * количество слов
	 * -//-//- пледложений
	 * словарный запас
	 * имена
	 * числа
	 * логические связки(и, или, не, а, если...) 
	 */
	
	
	String main_text = "";
	
	Sage(){
		
	}
	
	Sage(String text){
//-----------------------MAIN INTERFACE--------------------------------------------------------------*
		System.out.println("Interface of output!");
		System.out.println("...text from*");
		main_text = loding_data(text);
		System.out.println("количество символов: с пробелами - " + main_text.length() + ", без пробелов - " + (main_text.length() - words_volume()));
		System.out.println("количество слов: " + words_volume());
		System.out.println("словарный запас: " + vocabulary());
		System.out.println("количество предложений: " + satz_volume());
		
		System.out.println("-------------------------------------------------------------");
		System.out.println("Имена:");
		names();
		System.out.println("-------------------------------------------------------------");
		System.out.println("Числа:");
		numbers();
		
		System.out.println("-------------------------------------------------------------");
		System.out.println("структура текста:");
		//text_structure();
		
		System.out.println("-------------------------------------------------------------");
		System.out.println("логические связки:");
		vocab_of_retoric();
		
//---------------------------------------------------------------------------------------------------*
	}
	
public String loding_data(String path) {
//..LODING DATA INTO MEMORY FROM LOCATION ON H.D.D
//INPUT: FILE ON HARD DISK
//OUTPUT: VARIABLE TYPE STRING
	String text = "";
			File text_from_file = new File(path);//*input
			Scanner scan_main_text = null;
				
				try {
				scan_main_text = new Scanner(text_from_file);
				} 
				catch (FileNotFoundException e) {
				e.printStackTrace();
				}
						  
					while(scan_main_text.hasNextLine()){		
						text += scan_main_text.nextLine() + " ";
					
					}
					scan_main_text.close();
					
//Добавление "абракадабры" для чего смотри метод names()
					//main_text = "qwertyu. " + main_text + " uytrewq";
					//System.out.println(main_text);//*output
return text;					
}

public int words_volume() {
//..COUNT ALL WORDS FROM DATATEXT
	String[] array_all_words = main_text.split(" ");	//подсчет слов по количеству пробелов
	int volume = array_all_words.length;
			
//Options: сборка слов вновь в текст с пробелами
//				String result = "";
//				for(int i = 0; i < array_all_words.length; i++ ){
//				result = result + " " + array_all_words[i];
//				}				
	return volume;
}

public int satz_volume() {
//..COUNT ALL SATZ FROM DATATEXT
	int point_count = 0;
	char[] array_of_symbol = main_text.toCharArray();			//подсчет предложений по количеству точек
			
		for(int i = 0; i < array_of_symbol.length; i++) {
				if(array_of_symbol[i] == '.') point_count++;
		}
	return point_count;
}

public int vocabulary() {
//..COUNT VOLUME DIFFRENT WORDS FROM DATATEXT
//..словарный запас
	int difference = 0;
	String text = getClear_text(main_text);			
	String[] array_all_words = text.split(" ");
	HashSet<String> set = new HashSet<String>(); //вычисление различных слов через SET
				
		for(int i = 0; i < array_all_words.length; i++) {
					set.add(array_all_words[i]);
		}
				difference = set.size();
	return difference;
	}

public String getClear_text(String fragment){
//..DELETE ALL TRASH_SYMBOL FROM DATATEXT
//..удаление лишних символов(точки, запятые и др.) и установление единого регистра
			char[] array_of_symbol = fragment.toCharArray();
			ArrayList<Character> list = new ArrayList<Character>();
			String final_fragment = "";
			
				for(int i = 0; i < array_of_symbol.length; i++) {
					array_of_symbol[i] = Character.toLowerCase(array_of_symbol[i]);
					if(array_of_symbol[i] != '.' && array_of_symbol[i] != ',' && array_of_symbol[i] != '"' ) list.add(array_of_symbol[i]);
				}
					
					for(int i = 0; i < list.size(); i++){
						final_fragment += list.get(i);	
					}
	return final_fragment;
}

public String getClear_text2(String fragment){
	//..DELETE ALL TRASH_SYMBOL FROM DATATEXT
	//..удаление лишних символов(точки, запятые и др.) 
				char[] array_of_symbol = fragment.toCharArray();
				ArrayList<Character> list = new ArrayList<Character>();
				String final_fragment = "";
				
					for(int i = 0; i < array_of_symbol.length; i++) {
						if(array_of_symbol[i] != '.' && array_of_symbol[i] != ',' && array_of_symbol[i] != '"' && array_of_symbol[i] != ')' && array_of_symbol[i] != '»') list.add(array_of_symbol[i]);
					}
						
						for(int i = 0; i < list.size(); i++){
							final_fragment += list.get(i);	
						}
		return final_fragment;
	}

public void names(){	
	/*
	 * Метод names() извлекает из текста Имена следующим образом:
	 * Исходный текст преобразуется в массив символов
	 * В массиве символов осуществляется поиск последовательности символов,
	 * в данном случае это - символ верхнего регистра + пробел слева + точка после пробела,
	 * либо другие варианты
	 * Обнаружив искомую последовательность символов, формируется строка, которая и есть Имя
	 * Имена добавляются в список
	 * 
	 * В силу специфики алгоритма в начало и конец текста намерено добавлене "абракадабра",
	 * пока это решение под вопросом
	 */
	
	char[] array_all_symbol = main_text.toCharArray();
	char symbol;
	String name = "";
	ArrayList<String> list_of_name = new ArrayList<String>();
	
		for(int i = 0; i < array_all_symbol.length; i++){
			symbol = array_all_symbol[i];
//Логика: ...
				if(Character.isUpperCase(symbol) && array_all_symbol[i-1] == ' ' && array_all_symbol[i-2] != '.' && array_all_symbol[i-3] != '.' || Character.isUpperCase(symbol) && array_all_symbol[i-1] != ' '){
//Формирование строки: символы преобразуются в строку до пробела
						while(array_all_symbol[i] != ' '){
							name +=  array_all_symbol[i];
							i++;
						}
								list_of_name.add(getClear_text2(name));
								name = "";
				}
		}
		
		for(String element : list_of_name){
			System.out.println(element);
		}
		
		System.out.println();
}

public void numbers(){
	/*
	 * Метод number() извлекает из текста числа следующим образом:
	 * Исходный текст преобразуется в массив слов
	 * Каждое слово массива преобразуется в массив символов
	 * В массиве символов осуществляется поиск чисел
	 * Если находим число, извлекаем все слово, и переходим к следующему слову
	 */
	String[] list_all_words = main_text.split(" ");
	String word_of_list_all_words = "";
	char[] list_of_sybol;
	char symbol;
	
		for(int i = 0; i < list_all_words.length; i++){
			word_of_list_all_words = list_all_words[i];
			list_of_sybol = word_of_list_all_words.toCharArray();		
//Ищем в слове (которое представлено набором символов) числа, и если находим, то извлекаем все слово			
				for(int k = 0; k < list_of_sybol.length; k++){
					symbol = list_of_sybol[k];
					
						if(Character.isDigit(symbol)){
							System.out.println(word_of_list_all_words);	
								break;	
						}
				}
		}
}

public void text_structure(){
	/*
	 * Метод text_structure() выявляет структуру текста следующим образом:
	 * Исходный текст очищается от лишних символов(запятые, точки и т.д.)
	 * Очищенный текст преобразуется в массив слов
	 * Из массива слов образуется два операционных массива: set and list
	 * Новый операционный массив map_of_heap содержит количество упоминаний элементов массива set
	 * в массиве list. Что и осталось упорядочить по возрастанию
	 * В массиве map_of_heap осуществляется поиск самого большого числа, затем поиск строки с этим самым
	 * большим числом, далее запись этой строки с самым большим числом в новый массив sorted_list,
	 * и удаление отсортированной записи из map_of_heap
	 * */
	
	String text = getClear_text(main_text);
	String[] list_all_words = text.split(" ");
//**********************************************************************	
		HashSet<String> set = new HashSet<String>();
			for(int i = 0; i < list_all_words.length; i++) {
				set.add(list_all_words[i]);
			}
	
		ArrayList<String> list = new ArrayList<String>();
			for(String element : list_all_words){
				list.add(element);
			}
//**********************************************************************
			
	HashMap<String, Integer> map_of_heap = new HashMap<String, Integer>();
	int count = 0;
	
		for(String element_of_set : set){
			
				for(String element_of_list : list){
					if(element_of_set.equals(element_of_list))count++; 	
				}
					map_of_heap.put(element_of_set, count);
					count = 0;
		}
//**********************************************************************
	ArrayList<String> sorted_list = new ArrayList<String>();
	String element_of_sorted_list = "";
	int big = 0;
	
	while(map_of_heap.size() != 0){
		
		for(HashMap.Entry<String, Integer> super_number : map_of_heap.entrySet()){
//Осуществляем поиск самого большого числа из map_of_heap
			if(big < super_number.getValue())big = super_number.getValue();
		}
		
			for(HashMap.Entry<String, Integer> row : map_of_heap.entrySet()){
//Осуществляем поиск KEY с самым большим числом в map_of_heap	
				if(row.getValue() == big){
					element_of_sorted_list = row.getKey() + " | " + row.getValue();
						sorted_list.add(element_of_sorted_list);
//Удаление и обнуление
							map_of_heap.remove(row.getKey(), row.getValue());
								big = 0;
									break;
				}
			}
	}
	
	System.out.println("++++++++++++++++++++++++");
		for(String element : sorted_list){
			System.out.println(element);
		}
}

public void vocab_of_retoric(){
	/*
	 * Метод number() извлекает из текста числа следующим образом:
	 * 
	 */
	
	int con = 0;
	int dis = 0;
	int not = 0;
	int impl = 0;
	String element_of_list = "";
	String[] list_all_words = main_text.split(" ");
		for(int i = 0; i < list_all_words.length; i++) {
			element_of_list = getClear_text2(list_all_words[i]);
				
			if(element_of_list.equals("и"))con++;
			if(element_of_list.equals("или"))dis++;
			if(element_of_list.equals("не"))not++;
			if(element_of_list.equals("если"))impl++;
		}
	System.out.println("конъюнкция(логическое \"и\"):    " + con);
	System.out.println("дизъюнкция(логическое \"или\"):  " + dis);
	System.out.println("отрицание(логическое \"не\"):    " + not);
	System.out.println("импликация(логическое \"если\"): " + impl);
}

//..вспомогательные методы для вычисления структуры текста---------------------------*
public String delete_last(String h){
	char[] ch = h.toCharArray();
	String s = "";
	for(int i = 0; i < ch.length - 1; i++){
		s += ch[i];
		
	}
	return s;
}

public String delete_two_last(String h){
	char[] ch = h.toCharArray();
	String s = "";
	for(int i = 0; i < ch.length - 2; i++){
		s += ch[i];
	}
	return s;
}
//----------------------------------------------------------------------------------*
}
