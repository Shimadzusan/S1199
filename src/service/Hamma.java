package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Hamma {
	String main_text = "";
	boolean name, number, logic, retoric, text_structure;
	
	Finalable final_instance;
	
	public Hamma(Samplable sample) {
		this.main_text = sample.get_text();
		this.name = sample.get_name();
		this.number = sample.get_number();
		this.logic = sample.get_logic();
		this.retoric = sample.get_retoric();
		this.text_structure = sample.get_text_structure();
		
		if(sample.get_logic())sample.set_logic_data(logic_binding());
		
		if(sample.get_number())sample.set_number_data(numbers());
		System.out.println("size of numbers: " + numbers().size());
		
//**********************************************************
		Buffer.lenght = main_text.length();
		Buffer.lenght2 = (main_text.length() - words_volume());
		Buffer.lenght3 = sentence_volume();
	}
	public int words_volume() {
		//..COUNT ALL WORDS FROM DATATEXT
			String[] array_all_words = main_text.split(" ");	//подсчет слов по количеству пробелов
			int volume = array_all_words.length;			
			return volume;
		}

		public int sentence_volume() {
		//..COUNT ALL SATZ FROM DATATEXT
			int point_count = 0;
			char[] array_of_symbol = main_text.toCharArray();			//подсчет предложений по количеству точек
					
				for(int i = 0; i < array_of_symbol.length; i++) {
						if(array_of_symbol[i] == '.') point_count++;
				}
			return point_count;
		}
		
		public HashMap logic_binding(){
			/*
			 * Метод logic_binding() извлекает из текста логические связки следующим образом:
			 * В массиве всех слов происходит поиск следующих функторов: и, или, не, если...
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
			
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			map.put("конъюнкция(логическое \"и\"):    ", con);
			map.put("дизъюнкция(логическое \"или\"):  ", dis);
			map.put("отрицание(логическое \"не\"):    ", not);
			map.put("импликация(логическое \"если\"): ", impl);
			//System.out.println(map.size());
			
			return map;
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

		
		public HashSet numbers(){
			/*
			 * Метод number() извлекает из текста числа следующим образом:
			 * Исходный текст преобразуется в массив слов
			 * Каждое слово массива преобразуется в массив символов
			 * В массиве символов осуществляется поиск чисел
			 * Если находим число, извлекаем все слово, и переходим к следующему слову
			 */
			HashSet<String> set = new HashSet<String>();
			
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
									set.add(word_of_list_all_words);
										break;	
								}
						}
				}
				return set;
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
}
