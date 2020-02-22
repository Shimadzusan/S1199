package service;

public class Thing {
	int value;
	String key;
	
	public Thing(String k, int v) {
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
