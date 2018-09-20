import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Sage {
	String s_file = "";
	
	Sage(){
//-----------------------MAIN INTERFACE--------------------------------------------------------------*
		System.out.println("Interface of output!");
		System.out.println("...text from*");
		loding_data();
		System.out.println("количество символов: с пробелами - " + s_file.length() + ", без пробелов - " + (s_file.length() - words_volume()));
		System.out.println("количество слов: " + words_volume());
		System.out.println("словарный запас: " + vocabulary());
		System.out.println("количество предложений: " + satz_volume());
		
		System.out.println("-------------------------------------------------------------");
		System.out.println("Имена:");
		//names();
		System.out.println("-------------------------------------------------------------");
		System.out.println("Числа:");
		numbers();
		
		System.out.println("-------------------------------------------------------------");
		System.out.println("структура текста:");
		//text_structure();
//---------------------------------------------------------------------------------------------------*
	}
	
public void loding_data() {
//..LODING DATA INTO MEMORY FROM LOCATION ON H.D.D
//INPUT: FILE ON HARD DISK
//OUTPUT: VARIABLE TYPE STRING
			File main_text = new File("C:\\Users\\Stalin\\workspace\\S1199\\text.txt");//*input
			Scanner scan_main_text = null;
				
			try {
			scan_main_text = new Scanner(main_text);
			} 
			catch (FileNotFoundException e) {
			e.printStackTrace();
			}
						  
			while(scan_main_text.hasNextLine()){		
			s_file += scan_main_text.nextLine() + " ";
			
			}
			scan_main_text.close();
			//System.out.println(s_file);//*output		
			}

public int words_volume() {
//..COUNT ALL WORDS FROM DATATEXT
			String[] text = s_file.split(" ");			//подсчет слов по количеству пробелов
			int a = text.length;
			
			//сборка слов вновь в текст с пробелами
			String result = "";
			for(int i = 0; i < text.length; i++ ){
			result = result + " " + text[i];
			}
	return a;
}

public int satz_volume() {
//..COUNT ALL SATZ FROM DATATEXT
			int point_count = 0;
			char[] text = s_file.toCharArray();			//подсчет предложений по количеству точек
			for(int i = 0; i < text.length; i++) {
				if(text[i] == '.') point_count++;
			}
	return point_count;
}

public int vocabulary() {
//..COUNT VOLUME DIFFRENT WORDS FROM DATATEXT
//..словарный запас
				int difference = 0;
				String s = getClear_text(s_file);
				
				String[] text = s.split(" ");
				HashSet<String> set = new HashSet<String>(); //вычисление различных слов через SET
				for(int i = 0; i < text.length; i++) {
					set.add(text[i]);
				}
				difference = set.size();

		return difference;
	}

public String getClear_text(String s5){
//..DELETE ALL TRASH_SYMBOL FROM DATATEXT
//..удаление лишних символов(точки, запятые и др.) и установление единого регистра
			char[] text = s5.toCharArray();
			ArrayList<Character> list = new ArrayList<Character>();
			String s = "";
			for(int i = 0; i < text.length; i++) {
				text[i] = Character.toLowerCase(text[i]);
				if(text[i] != '.' && text[i] != ',' && text[i] != '"' ) list.add(text[i]);
			}
			for(int i = 0; i < list.size(); i++){
				s += list.get(i);	
			}
	return s;
}

public void names(){
	char[] text = s_file.toCharArray();
	
	
//	for(int i = 2; i < text.length; i++){
//		ch = text[i];
//		
//		if(Character.isUpperCase(ch) && text[i-2] != '.'){
//			
//			//System.out.println(ch);
//		}
//	}
	HashSet<String> set = new HashSet<String>();
	String s = "";
	String last = "";
	String[] text2 = s_file.split(" ");
	char ch = ' ';
	boolean b = true;
	for(int ii = 0; ii < text2.length; ii++){
		s = text2[ii];
		if(ii > 0)last = text2[ii - 1];
		char[] word = s.toCharArray();
		char[] lst = last.toCharArray();
			for(int k = 0; k < word.length; k++){
				b = true;
				ch = word[k];
				if(Character.isUpperCase(ch)){
						for(int j = 0; j < lst.length; j++){
							if(lst[j] == '.'){b = false;break;}
						}
						if(b == true){
					//System.out.println(s);
					set.add(getClear_text(s));
					break;
					}
				}
			}
	}
	//OUTPUT
	for(String element : set){
		System.out.println(element);
	}
}

public void numbers(){
	String s = "";
	String last = "";
	String[] text2 = s_file.split(" ");
	char ch = ' ';
	boolean b = true;
	for(int ii = 0; ii < text2.length; ii++){
		s = text2[ii];
		if(ii > 0)last = text2[ii - 1];
		char[] word = s.toCharArray();
		char[] lst = last.toCharArray();
			for(int k = 0; k < word.length; k++){
				b = true;
				ch = word[k];
				if(Character.isDigit(ch)){
						
					System.out.println(s);
					
					break;
					
				}
			}
	}
}

public void text_structure(){
//..TEXT_STRUCTURE TYPE ONE
	String s = getClear_text(s_file);
	
	String[] text = s.split(" ");			//..*PART FROM VOCABULARY_METHOD
	HashSet<String> set = new HashSet<String>();
	for(int i = 0; i < text.length; i++) {
		set.add(text[i]);
	}
//**********************************************************************
	ArrayList<String> list = new ArrayList<String>();
	for(String d : text){
		list.add(d);
	}
	//System.out.println("size list: " + list.size());
	HashMap<String, Integer> map = new HashMap<String, Integer>();
	int countt = 0;
	for(String tes : set){
		
			for(String tsil : list){
				if(tes.equals(tsil))countt++;
				
			}
			
			//System.out.println(tes + " | " + countt);
			map.put(tes, countt);
			countt = 0;
	}
	ArrayList<String> list2 = new ArrayList<String>();
	String list2a = "";
	//****while
	int big = 0;
	while(map.size() != 0)
	{
	for(HashMap.Entry<String, Integer> google : map.entrySet()){
		//System.out.println(google.getKey() + " | " + google.getValue());
		//map.remove(key, value);
		if(big < google.getValue())big = google.getValue();
		
	}
	
	for(HashMap.Entry<String, Integer> google2 : map.entrySet()){
		if(google2.getValue() == big){
			list2a = google2.getKey() + " | " + google2.getValue();
			list2.add(list2a);
			map.remove(google2.getKey(), google2.getValue());
			big = 0;
			break;
	}
	}
//	big = 0;
	}
	System.out.println("++++++++++++++++++++++++");
	for(String gg : list2){
		System.out.println(gg);
	}
//******************************************************************************
}

public void text_structure2(){
//..TEXT_STRUCTURE TYPE TWO
	ArrayList<String> clonset = new ArrayList<String>();
	ArrayList<String> clonset2 = new ArrayList<String>();
//	for(String element : set){
//		clonset.add(element);
//		
//	}
	//System.out.println("size" + clonset.size());
	clonset2 = clonset;
	String ss = "";
	String s3 = "";
	int count = 0;
	///+++++++++++++++++++++++++++++++++++
	for(int i = 0; i < clonset.size(); i++){
		ss = clonset.get(i);
			for(int ii = i; ii < clonset.size(); ii++){
				
			}
		
	}
	///+++++++++++++++++++++++++++++++++++
	/*
	//////////////////////******
//	for(int y = 0; y < clonset.size(); y++){
//		ss = clonset.get(y);
//				for(int i = 0; i < clonset2.size(); i++){
//					if(ss.equals(clonset2.get(i)))
//					{
//						clonset.remove(y);
//						System.out.println(ss + "1" + clonset2.get(i));
//					}
//				}
//	}
//	ss="";
//	System.out.println(clonset.size());
//	System.out.println(clonset2.size());
//	System.out.println(set.size());
	//////////////////////********
	for(int i = 0; i < clonset.size(); i++){
		ss = clonset.get(i);
		int a = ss.length() - 2;
		int b = ss.length() + 2;
			//System.out.println(ss + " diapason: " + a + " " + b);
		for(int k = 0; k < clonset2.size(); k++){
			
			s3 = clonset2.get(k);
			s3.length();
			//System.out.println(count++);
						String a1 = delete_last(ss);
						String b1 = delete_two_last(ss);
						String c1 = delete_last(s3);
						String d1 = delete_two_last(s3);
					if( s3.length() > 3 && a < s3.length() && s3.length() < b){
						
						//1
						
						//
			
//							//delete last
//							//and delete two last
							if(ss.equals(c1) || ss.equals(a1)  || ss.equals(b1) ||ss.equals(d1)){
								System.out.println("22"  + ss + " | " + s3);//break;
								
								//System.out.println(ss + ", "+ s3+ ", "+ a1+ ", "+ b1+ ", "+ c1+ ", "+ d1+ ", ");
								//System.out.println(count++);//break;
							}
							if(d1.equals(ss)){
								
							}
//							
//							
//						
//						//2
//						
							//delete last
							//and delete two last
							
							if(s3.equals(a1)){
								System.out.println("55"  + ss + " | " + s3);//break;
								for(int x = 0; x < clonset2.size(); x++){
									if(s3.equals(clonset2.get(x))){
										clonset2.remove(x);
									}
								}
								//System.out.println("3");//break;
							}
//							if(a1.equals(c1) && s3.equals(ss) == false){
//								System.out.println("44"  + ss + " | " + s3);//break;
//							}
							
							
							
						
					}
					
			}
	}
	
	
	*/
	
	//************************************************************
	
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
