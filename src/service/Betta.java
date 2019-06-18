package service;

import java.util.ArrayList;

public class Betta {
	String main_text = "";
	boolean logic;
	
	public Betta(String web_text, boolean lg) {
		this.main_text = web_text;
		this.logic = lg;
		if(this.logic == true) {
			Buffer.logic = true;
			vocab_of_retoric();
			
		}
		else {
			Buffer.logic = false;
		}
		
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
			
			Buffer.con = con;
			Buffer.dis = dis;
			Buffer.not = not;
			Buffer.impl = impl;
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
