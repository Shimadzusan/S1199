package test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;

import org.junit.Test;

import service.Hamma;

public class HammaTest {

	@Test
	public void number_test() {
//тестирую метод numbers(); ...
		Hamma element = new Hamma("ывжадоывдлоа ывдж2лаоывдлоа ывждлаывждо 5 жывлдаожывло 95 важло");
		HashSet result = element.numbers();
		HashSet<String> set = new HashSet<String>();
       
			assertEquals(3, result.size());
	}
	
	@Test
	public void number_test_two() {
		Hamma element = new Hamma("ывжадоывдлоа ывдж2лаоывдлоа ывждлаывждо 5 жывлдаожывло 95 важло 11");
		HashSet result = element.numbers();
		HashSet<String> set = new HashSet<String>();
       
			assertEquals(4, result.size());
	}
	
	@Test
	public void get_clear_text() {
		Hamma element = new Hamma();
		String result = element.getClear_text("как он сказал, мирной и Безопасной.");
		String expected = "как он сказал мирной и безопасной";
       
			assertEquals(result, expected);
	}

}
