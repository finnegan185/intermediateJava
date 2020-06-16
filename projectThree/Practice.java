package projectThree;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Practice {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("red");
		list.add("red");
		list.add("red");
		list.add("red");
		System.out.println(Arrays.toString(list.toArray()));
		String element = "red";
		for (int i = list.size() - 1; i >= 0; i--)
		   if (list.get(i).equals(element))
		       list.remove(element);
		System.out.println(Arrays.toString(list.toArray()));
	}
	
	   public static int countDown(int n, int result)
	   {
	       if (n == 0)
	           return 0;
	       else
	    	   System.out.print(n + result);
	           return countDown(n - 1, n + result);
	   }
}
