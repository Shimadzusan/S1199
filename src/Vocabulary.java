	import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.Map;
import java.util.Scanner;

	//FRAMEWORK
	//КЛАСС ДЛЯ ОБРАЩЕНИЙ К ФАКТУРЕ В БАЗЕ ДАННЫХ
	//ЗАПРОС...
	//ОТВЕТ...
	public class Vocabulary {
		static ArrayList lot_db = new ArrayList();//lot_db ...IS LOT OF DATA BASE
		public static ArrayList hierarchy = new ArrayList(); //(GRADUATION)
		
		public static void main(String[] args) throws ClassNotFoundException, SQLException {

	System.out.println("*... I am F_work");
			
	//---------------------MODUL TO CONNECT DATA BASE-----------------------------------------//
//					
//					Conn20 conn = new Conn20();
//					conn.Conn();
//					conn.CreateDB();
//					lot_db = conn.ReadDB();
//					//conn.WriteDB(WRITING WE MAKE DISCONNECT);
//					conn.CloseDB();
					
	//---------------------------------------------------------------------------------------//
	//String primary = "In threatening tariffs on as much as $450 billion worth of Chinese goods, the administration is betting that Beijing will blink first. It’s a risky gamble by a White House that appears ready to forgo diplomatic negotiations in favor of punishing tariffs that could pinch consumers and companies on both sides of the Pacific.The approach fulfills a frequent campaign promise by Mr. Trump. But it has spooked companies, investors and markets, which are increasingly worried that the United States has no other strategy to resolve a stalemate with China over its trade practices. Several rounds of trade talks with top Chinese officials in Washington and Beijing produced little agreement, and no additional official negotiations are scheduled, administration officials said. On Tuesday, Mr. Trump suggested he was ready for a fight, saying China would no longer take advantage of the United States.";	
	String primary = read();
	
	String lower = primary.toLowerCase();
	ArrayList first = new ArrayList();
	String s5 = "";
	char[] alpha_text = lower.toCharArray();
		for(int i = 0; i < alpha_text.length; i++){
			if(alpha_text[i] != '.' && alpha_text[i] != ','){
				s5 = s5 + alpha_text[i];
			}
		}
		
		String[] text5 = s5.split(" ");
		
		for(int i = 0; i < text5.length; i++){
			first.add(text5[i]);
		}
		//OutPUT result
		
//		for(Object i: first){
//			System.out.println(i);
//		}
//		
		
		lot_db = first;
		for(Object i : lot_db){
			System.out.println(i);
			
		}
	//OUTPUT: lot_db!!!!
	//----------------------------------------------------------------------------------------//
	System.out.println("Begin!");
	System.out.println("Размер исходного множества из Data Base: " + lot_db.size());
	System.out.println();

//	ArrayList threed = new ArrayList();
//	threed = lot_db;
//	System.out.println(threed.size()+" I am threed!!");
	//--------------------------------СЛОВАРНЫЙ ЗАПАС------------------------------------------//
	

				ArrayList second_list = new ArrayList();
				second_list = vocabulary(lot_db);
				//ДАЛЕЕ МЫ СРАВНИВАЕМ lot_db И second_list, И ПОЛУЧАЕМ КОЛИЧЕСТВО УПОТРЕБЛЕНИЙ
				//vocabulary_plus();//THIS VERSION IS AVAILABLE (UNAVAILABLE)
				
				
				System.out.println("----------------------------------------");
				//
//							//Conn20 conn = new Conn20();
//							conn.Conn();
//							conn.CreateDB();
//							lot_db = conn.ReadDB();
//							//conn.WriteDB(WRITING WE MAKE DISCONNECT);
//							conn.CloseDB();
//							//
				ArrayList first2 = new ArrayList();
				for(int i = 0; i < text5.length; i++){
					first2.add(text5[i]);
				}
				lot_db = first2;
				
				System.out.println(lot_db.size()+ "way?? size 130??");
				System.out.println("second_list size: " + second_list.size()+" |size of first: " + first.size());
				vocabulary_stucture(lot_db, second_list);
				///
				System.out.println("************************************************************");
				for(Object i: hierarchy){
					System.out.println(i);
				}
	/////////////////////////////////////////////////////////////////////////////////////////////////////
				//------------------------------------------
				System.out.println();
				System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				ArrayList target = new ArrayList();//ВХОДЯЩИЕ ДАННЫЙ ДЛЯ ПРОЦЕДЦРЫ
				ArrayList target5 = new ArrayList();//РЕЗУЛЬТАТ, ВЫХОДЯЩИЕ ДАННЫЕ
//				String ax = "12*xxx";
//				String ay = "8*yyy";
//				String az = "42*zzz";
//				String az1 = "142*zzz";
//				String az2 = "2*zzz";
//				target.add(az2);
//				target.add(ax);
//				target.add(ay);
//				target.add(az);
//				target.add(az1);
				target = hierarchy;
				
				
				//-------------------------------------------
				while(target.size() != 0){
				String sss = "";
				int xxx = 0;
				int zzz = -1;
				int z5 = -1;
				for(int i = 0; i < target.size(); i++ ){
					String s = (String) target.get(i);
						//extract number
						char [] array100 = s.toCharArray();
						
							for(int i2 = 0; i2 < array100.length; i2++){
								if(Character.isDigit(array100[i2])){
									
									sss = sss + array100[i2];
									xxx = Integer.parseInt(sss);
								}
								
							}
					//System.out.println("My Try: " + xxx);
														
											if (zzz < xxx){
															
															zzz = xxx;
															z5 = i;
															
														}
								
								xxx = 0;
								sss = "";
								
				}
				//System.out.println("самое большое число: " + zzz + " координаты этого числа: " + z5);
				// ДОБАВЛЯЕМ В НОВЫЙ МАССИВ!!!
				target5.add(target.get(z5));
				target.remove(z5);
				
				//END OF WHILE!!!
			}
				for(Object i: target5){
					System.out.println(i);
				}
				
				//-------------------------------------------
	/////////////////////////////////////////////////////////////////////////////////////////////////////
				
				
	//----------------------------------------------------------------------------------------//
			
		}
		public static void vocabulary_stucture(ArrayList lot_db, ArrayList second_list) {
				int count = 0;
				System.out.println(lot_db.size());
				System.out.println(second_list.size());
		for(int i = 0; i < second_list.size(); i++){
			String w = (String) second_list.get(i);
				
				for(int i2 = 0; i2 < lot_db.size(); i2++){
					String w2 = (String) lot_db.get(i2);
						
					if(w.equals(w2)){
							count++;
						}
					
				}
				System.out.println(w + "|| упоминается: " + count);
				String graduation = count + "*" + w;
				hierarchy.add(graduation);
				count = 0;
		}
			
		}
	//-------------------------------OUR METHODS----------------------------------------------//
		
		public static ArrayList vocabulary(ArrayList a) {
			//-------------------------------------------|
			int z = 0;			//COUNT
			boolean swch = true; //SIMPLE SWITH
	System.out.println("Исходный размер массива: " + a.size());
			
	//---------------------------------------------------------------------------------------------------//
	//FIRST CYCLE...
			for (int i = 0; i < a.size(); i++) {
		           String w = (String) a.get(i);
		           			
		           //-----SECOND CYCLE
		           			for(int i2 = 0; i2 < a.size(); i2++){
		           				String w2 = (String) a.get(i2);
		           		
										if(swch == true){
											if(w.equals(w2)){
												swch = false;
												//для первого случая!
											}
			           					}
										else{
											//для всех следующих случаев!
											if(w.equals(w2)){
												a.remove(i2);
												z++;
											}					
										}
		           			}	
		           	//----- END SECOND CYCLE
		           swch = true; //ПЕРЕКЛЮЧАЕМ В ИСХОДНЫЙ РЕЖИМ
		           }
	//---------------------------------------------------------------------------------------------------//		
	System.out.println(z+ "...было удалений(совпадений)");
	System.out.println("Размер массива после обработки: " + a.size());
	System.out.println("Следовательно, словарный запас равен: " + a.size());
	System.out.println("total output:");
			
//			for(Object i:a){
//				System.out.println(i);
//			}

			ArrayList b = new ArrayList();
				b = a;
	System.out.println("Operation vocabulary is done...");
			return b;
			
		}
	//-----------------------------------------------------------------------------------------//
		private static void vocabulary_plus() {
					int x = 1;
					int z = 1;
					
	ArrayList <Object>list70 = new ArrayList<Object>();
			
			for(int i = 0; i < lot_db.size(); i++){
								String q = (String) lot_db.get(i);
								
									for(int i2 = lot_db.size()-1; i2 > 0; i2--){
										String q2 = (String) lot_db.get(i2);
										if(q.equals(q2)){
											x++;
											lot_db.remove(i2);
											
											
//												if(x > 4){
//													System.out.println(q2);
//												}
											
										}
										
									}
									//list50.remove(i);
									
									//System.out.println(x + " ... |" + q +"|  size: "+ list50.size()+ " z: " + z);
									x=0;
									z++;
									list70.add(q);
									
			}
			
			int z2 = 0;
			//for <each>
			 for (Object i:list70) {
				 z2++;
		           System.out.println(i+" / " + z2);
		           }
			
		}
		
		
		private static String read(){
			File main_text = new File("C:\\Users\\Stalin\\workspace\\S1199\\text.txt");
			Scanner scan_main_text = null;
		
			try {
			scan_main_text = new Scanner(main_text);
			} 

			catch (FileNotFoundException e) {
			e.printStackTrace();
			}
			 
			String s_file = ""; 
			while(scan_main_text.hasNextLine()){		
			s_file += scan_main_text.nextLine();
			//scan_main_text.close();
			}
			System.out.println(s_file);
			return s_file;

			//System.out.println();
			//System.out.println("the number from time_file: " + s_file + " ...format <STRING>;");

			//////////////////////////////////////////////////////////////////////////////////////
		}

	}


