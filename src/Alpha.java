import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Alpha {

	public static void main(String[] args) {
		//new Sage("C:\\Users\\Stalin\\workspace\\S1199\\text.txt");
		new Structure_of_the_text("C:\\Users\\Stalin\\workspace\\S1199\\text.txt");
		 // E:\\Java\\словари for S-1199\\2019\\dict_opcorpora.txt
	 
	}
}

class Structure_of_the_text{
	int var_alpha = 0;
	int size;
	ArrayList<String> just_array = new ArrayList<String>();
	
	String main_text;
	
	Structure_of_the_text(String text) {
		System.out.println("...structure_of_the_text");
			Sage sage = new Sage();
				this.main_text = sage.loding_data(text);
				
//======================================================
	//text_structure();
	text_structure_two();
	System.out.println(var_alpha);
	System.out.println(var_alpha - size);
	
	for(String element : just_array){
		System.out.println(element);
	}
				//System.out.println(main_text.length());
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
}

public void text_structure_two(){
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
//Part II
//input data: HashSet
//output data: List<String[]>
System.out.println();
System.out.println("PART II =========================================================");
	String word_one = "";
	String word_two = "";
	
	ArrayList<String> list_of_set_one = new ArrayList<String>(set);
	ArrayList<String> list_of_set_two = new ArrayList<String>(set);

	for(int i = 0; i < list_of_set_one.size(); i++) {
		word_one = list_of_set_one.get(i);
		//System.out.println(element);
		
		for(int k = 0; k < list_of_set_two.size(); k++) {
			//System.out.println(element_betta);
			word_two = list_of_set_two.get(k);
			method_alpha(word_one, word_two);
//			if(word_one.equals(word_two)){
//		
//				list_of_set_two.remove(k);
//			}
//			else{
//			method_alpha(word_one, word_two);
//			}
		}
			
	}
	System.out.println(set.size());
	size = set.size();
}

private void method_alpha(String word_one, String word_two) {
	
	if(word_one.length() > 3 && word_one != word_two && (word_one.length() == word_two.length())) {
		
		char[] char_one = word_one.toCharArray();
		String word_one_a = "";
		char[] char_two = word_two.toCharArray();
		String word_two_a = "";
		
			for(int i = 0; i < char_one.length - 1; i++){
				word_one_a += "" + char_one[i];
			}
			
			for(int i = 0; i < char_two.length - 1; i++){
				word_two_a += "" + char_two[i];
			}
				
				if(word_one_a.equals(word_two_a)){
				
		just_array.add(word_two);
		System.out.println(word_one + " | " + word_two);
				}
	}
}

//**********************************************************************


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

}