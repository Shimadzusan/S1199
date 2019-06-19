package service;

public class Final_instance implements Finalable {
	public static boolean logic = false;
	public static int con;
	public static int dis;
	public static int not;
	public static int impl;
	
	@Override		
	public void set_logic (boolean logic) {
		this.logic = logic;
	}

}

interface Finalable {

	void set_logic(boolean logic);
	
}
