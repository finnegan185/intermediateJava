package Discussions;

import java.util.ArrayList;

public class GenericCollection {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		@SuppressWarnings({"rawtypes" })
		ArrayList nonGenAl = new ArrayList();
		ArrayList<Character> genCharAl = new ArrayList<Character>();
		
		genCharAl.add('f');
		genCharAl.add('i');
		genCharAl.add('n');
		genCharAl.add(6);	
		genCharAl.add('e');
		
		nonGenAl.add(5.34);
		nonGenAl.add(5);
		nonGenAl.add(2.0);
		nonGenAl.add('e');
		nonGenAl.add("superduper");

	}
}
