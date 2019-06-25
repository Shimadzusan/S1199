package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class Hamma {
	String main_text = "";
	boolean name, number, logic, retoric, text_structure;
	
	String[] array_all_words;
	
//два конструктора добавлены только из-за тестирования, для удобства тестирования
	public Hamma() {
		
	}
	
	public Hamma(String text) {
		this.main_text = text;
	}
	
	public Hamma(Samplable sample) {
		this.main_text = sample.get_text();
//switches
		this.name = sample.get_name();
		this.number = sample.get_number();
		this.logic = sample.get_logic();
		this.retoric = sample.get_retoric();
		this.text_structure = sample.get_text_structure();

//processing
		//if(sample.get_text_structure())sample.set_text_structure_data(text_structure());
		if(sample.get_text_structure())sample.set_text_structure_data(text_structure_two());
		if(sample.get_name())sample.set_name_data(names());
		if(sample.get_number())sample.set_number_data(numbers());
		if(sample.get_logic())sample.set_logic_data(logic_binding());
		
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
		
	public HashSet names() {	
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
			
				for(int i = 5; i < array_all_symbol.length; i++){
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
				System.out.println(list_of_name.size());
//				for(String element : list_of_name){
//					System.out.println(element);
//				}
				HashSet<String> set_name = new HashSet<String>(list_of_name);
				
				System.out.println();
				return set_name;
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
	public ArrayList text_structure(){
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
		//здесь мы упорядочиваем массив-карту map_of_heap по убыванию
				
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
				return sorted_list;
		}
	public ArrayList text_structure_two(){
		/*
		 * Метод text_structure() выявляет структуру текста следующим образом:
		 * Исходный текст очищается от лишних символов(запятые, точки и т.д.)
		 * Очищенный текст преобразуется в массив слов
		 * Из массива слов образуется два операционных массива: set and list
		 * 
		 * 
		 * Новый операционный массив map_of_heap содержит количество упоминаний элементов массива set
		 * в массиве list. Что и осталось упорядочить по возрастанию
		 * В массиве map_of_heap осуществляется поиск самого большого числа, затем поиск строки с этим самым
		 * большим числом, далее запись этой строки с самым большим числом в новый массив sorted_list,
		 * и удаление отсортированной записи из map_of_heap
		 * */
		
		String text = getClear_text(main_text);
		 array_all_words = text.split(" ");
	//**********************************************************************	
			HashSet<String> set = new HashSet<String>();
				for(int i = 0; i < array_all_words.length; i++) {
					set.add(array_all_words[i]);
				}
		
			ArrayList<String> list_all_words = new ArrayList<String>();
				for(String element : array_all_words){
					list_all_words.add(element);
				}
	//**********************************************************************
	//Part II
	//input data: HashSet
	//output data: List<String[]>
	System.out.println();
	System.out.println("PART II ============================================");
		String word_one = "";
		String word_two = "";
		
		TreeSet<String> tree_set = new TreeSet<String>();
		
		ArrayList<String> list_of_set_one = new ArrayList<String>(set);
		//ArrayList<String> list_of_set_two = new ArrayList<String>(set);

	//+++++++++Цикл в котором происходит вся операция выявления++++++++++++++
		for(int i = 0; i < list_of_set_one.size(); i++) {
			word_one = list_of_set_one.get(i);
			String word_three = word_one;
		
				for(int k = i; k < list_of_set_one.size(); k++) {
					word_two = list_of_set_one.get(k);
	//Входные данные 2 ключевых слова
	//Два метода вместо предполагаемых шести))
	//========================================================================
	//First method: Слова с одинаковым количеством символов
	//Значение 3 указывает на длину сортируемых слов
		if(word_one.length() > 3 && word_one != word_two && (word_one.length() == word_two.length())) {
					
			char[] char_one = word_one.toCharArray();
			String word_one_a = "";
			char[] char_two = word_two.toCharArray();
			String word_two_a = "";
				
				for(int j = 0; j < char_one.length - 2; j++){
					word_one_a += "" + char_one[j];
				}
						
				for(int j = 0; j < char_two.length - 2; j++){
					word_two_a += "" + char_two[j];
				}
				
					if(word_one_a.equals(word_two_a)){
						word_three += " " +  word_two;
	//System.out.println(word_three);
							list_of_set_one.remove(k);
								i++;
					}
		}
	//======================================================================	
	//Second method: Слова одинаковые по смыслу, НО разные по количеству символов
	//Значение 4 указывает на длину сортируемых слов
	//Значение 2 указывает на разницу в количестве сортируемых слов
		if(word_one.length() > 4 &&  (word_one.length() - word_two.length() <= 2 && word_one.length() - word_two.length() >= -2 ) && word_one.length() - word_two.length() != 0 ) {
	//Alpha			
			if(word_one.length() > word_two.length()) { //!!!
				int index = word_one.length() - word_two.length();
				char[] char_one = word_one.toCharArray();
				char[] char_two = word_two.toCharArray();
				String word_one_a = "";
				String word_two_a = "";
						
					for(int j = 0; j < (char_one.length - index) - 1; j++){
						word_one_a += "" + char_one[j];
					}
								
					for(int j = 0; j < char_two.length - 1; j++){
						word_two_a += "" + char_two[j];
					}
									
						if(word_one_a.equals(word_two_a)){
							word_three += " " +  word_two;
	//System.out.println(word_three);
								list_of_set_one.remove(k);
									i++;
						}
			}
	//Betta				
			if(word_one.length() < word_two.length()) { //!!!
				int index = word_two.length()  - word_one.length();
				char[] char_one = word_one.toCharArray();
				char[] char_two = word_two.toCharArray();
				String word_one_a = "";
				String word_two_a = "";
				
					for(int j = 0; j < char_one.length - 1; j++){
						word_one_a += "" + char_one[j];
					}
								
					for(int j = 0; j < (char_two.length - index) - 1; j++){
						word_two_a += "" + char_two[j];
					}
									
						if(word_one_a.equals(word_two_a)){
							word_three += " " +  word_two;
	//System.out.println(word_three);
								list_of_set_one.remove(k);
									i++;
						}
			}
		}	
	//========================================================================
			}
			tree_set.add(word_three);	
		}
	//Вывод отсортированного списка одинаковых слов по смыслу:
	// ...планета, планеты, планете, планет
//		for(String element : tree_set){
//			System.out.println(element);
//		}
		
	//========================================================================
	//Здесь выполняется рассчет количества одинаковых слов по смыслу==========
		ArrayList<String> list5 = new ArrayList<String>(tree_set);
		ArrayList<String[]> list6 = new ArrayList<String[]>();
			for(int j = 0; j < list5.size(); j++){
				String s = list5.get(j);
				String[] ss = s.split(" ");
				list6.add(ss);
			}
			
			System.out.println("Проверка: " + list5.size() + " " + list6.size());
	//Теперь работаем с list_all_words and list6
			TreeMap<String, Integer> map = new TreeMap<String, Integer>();
			ArrayList<Star> list = new ArrayList<Star>();
			
			for(String s10 : list5){
				int number = 0;
				String[] s = s10.split(" ");
				for(int i = 0; i < s.length; i++){
					number += get_number(s[i]);
				}
				
				map.put(s10, number);
				list.add(new Star(s10, number));
				
			}
	//ВЫвод списка не упорядоченного по значению	
//			for(Map.Entry<String, Integer> s_number : map.entrySet()){
//			
//				System.out.println(s_number.getKey() + " | " + s_number.getValue());
//			}
	//Вывод списка упорядоченного по значению
			System.out.println();
			System.out.println("Вывод списка упорядоченного по значению:");
			//
			for(int j = 0; j < list.size(); j++) {
				for(int i = 0; i < list.size() - 1; i++) {
					
				System.out.println("number " + i + ": " + list.get(i).key + " " + list.get(i).value);	
				Star a = list.get(i);
				Star b = list.get(i+1);
				
					if(list.get(i).value > list.get(i+1).value) {
						list.set(i, b);
						list.set(i + 1, a);
					}
				}
			}
				//
			ArrayList<String> list_jsp = new ArrayList<String>();	 
				for(int i = list.size() - 1; i > 0; i --) {
					list_jsp.add(list.get(i).toString());
				}
			
		return list_jsp;
	}
	
	private int get_number(String string) {
		
		int i = 0;
		for(int n = 0; n < array_all_words.length; n++) {
			if(string.equals(array_all_words[n]))i++;
		}
		return i;
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

class Star {
	int value;
	String key;
	
	public Star(String k, int v) {
		this.key = k;
		this.value = v;
	}
	
	void set_v(int value) {
		this.value = value;
	}
	
	int get_v() {
		return this.value;
	}
	
	void set_k(String key) {
		this.key = key;
	}
	
	String get_k() {
		return this.key;
	}
	
	 @Override
	    public String toString() {
		 String s = get_k() + " ~ " + get_v();
	        return s;
	 }
}

