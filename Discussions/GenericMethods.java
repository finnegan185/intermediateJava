package Discussions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class GenericMethods {

	public static void main(String[] args) {
		//One Dimension array find min
		Integer[] numsForMin = new Integer[15];
		Random randy = new Random();
		
		for (int i=0;i<numsForMin.length;i++) {
			numsForMin[i] = randy.nextInt(50);
		}
		System.out.println("Find Minimum Number: \n");
		System.out.println(Arrays.toString(numsForMin));
		System.out.println("\nMinimum number is: " + minNum(numsForMin));
		
		//Two Dimension array find max
		Integer[][] numsForMax = new Integer[5][5];
		for (int row=0;row<numsForMax.length;row++) {
			for (int col=0;col<numsForMax[row].length;col++) {
				numsForMax[row][col] = randy.nextInt(50);
			}
		}
		//Decided to use a string builder to print out 2d array in a stacked format instead of laid out
		StringBuilder sb = new StringBuilder();
		for(Integer[] row : numsForMax){
		    sb.append(Arrays.toString(row)).append('\n');
		}
		String maxArray = sb.toString();
		
		System.out.println("\n--------------------------\nFind Maximum Number: \n");
		System.out.println(maxArray);
		System.out.println(maxNum(numsForMax));
		
		//ArrayList for remove duplicates
		ArrayList<Integer> daList = new ArrayList<Integer>();
		for(int i=0;i<20;i++) {
			daList.add(randy.nextInt(8));
		}
		
		System.out.println("\n--------------------------\nRemove Duplicate Values: \n");
		System.out.println("Original ArrayList: \n" + Arrays.toString(daList.toArray()));
		System.out.println("\nArrayList without Duplicates:\n" + removeDuplicates(daList));
	}
	
	public static<E extends Comparable<E>> E minNum(E[] list) {
		E min = list[0];
		for(E s: list) {
			if(min.compareTo(s) > 0) {
				min = s;
			}
		}
		return min;
	}

	public static<E extends Comparable<E>> E maxNum(E[][] list) {
		E max = list[0][0];
		for (int row=0;row<list.length;row++) {
			for (int col=0;col<list[row].length;col++) {
				if(max.compareTo(list[row][col]) < 0) {
					max = list[row][col];
				}
			}
		}
		
		return max;
	}
	
	public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list){
		//Used the .stream() method for the first time. Pretty interesting.
		ArrayList<E> noDupes = (ArrayList<E>) list.stream()
													.distinct()
													.collect(Collectors.toList());
		return noDupes;
		
	}
}
