package service;

import java.util.HashMap;
import java.util.HashSet;

public class Sample implements Samplable {
	String text;
	public static Samplable sample;
	
	boolean name, number, logic, retoric, text_structure;
	
	HashSet name_data;
	HashSet number_data;
	HashMap logic_data;
	
	
	@Override
	public void set_number_data(HashSet number_data) {
		this.number_data = number_data;
		
	}
	@Override
	public HashSet get_number_data() {
		return this.number_data;
	}
	
	@Override
	public void set_logic_data(HashMap logic_data) {
		this.logic_data = logic_data;
	}
	@Override
	public HashMap get_logic_data() {
		return this.logic_data;
	}
//-------------------------------------------------------------------------
	@Override
	public void set_text(String text) {
		this.text = text;
	}

	@Override
	public String get_text() {
		return this.text;
	}

	@Override
	public void set_name(boolean name) {
		this.name = name;
	}

	@Override
	public boolean get_name() {
		return this.name;
	}

	@Override
	public void set_number(boolean number) {
		this.number = number;
	}

	@Override
	public boolean get_number() {
		return this.number;
	}

	@Override
	public void set_logic(boolean logic) {
		this.logic = logic;
	}

	@Override
	public boolean get_logic() {
		return this.logic;
	}

	@Override
	public void set_retoric(boolean retoric) {
		this.retoric = retoric;
	}

	@Override
	public boolean get_retoric() {
		return this.retoric;
	}

	@Override
	public void set_text_structure(boolean text_structure) {
		this.text_structure = text_structure;
	}

	@Override
	public boolean get_text_structure() {
		return this.text_structure;
	}
	

}
