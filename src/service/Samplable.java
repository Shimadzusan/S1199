package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

public interface Samplable {
		 
		 void set_text(String text);
		 String get_text();
//switches 
		 void set_name(boolean name);
		 boolean get_name();
		 
		 void set_number(boolean number);
		 boolean get_number();
		 
		 void set_logic(boolean logic);
		 boolean get_logic();
		 
		 void set_retoric(boolean retoric);
		 boolean get_retoric();
		 
		 void set_text_structure(boolean text_structure);
		 boolean get_text_structure();
//processing
		 void set_name_data(HashSet number_data);
		 HashSet get_name_data();
		 
		 void set_number_data(HashSet number_data);
		 HashSet get_number_data();
		 
		 void set_logic_data(HashMap logic_data);
		 HashMap get_logic_data();
		 
		 void set_text_structure_data(ArrayList text_structure_data);
		 ArrayList get_text_structure_data();
		 
//		 void set_text_structure_data(TreeMap text_structure_data);
//		 TreeMap get_text_structure_data();
		 
		
		 
}

