package Discussions;

public class SecondComputation {
	private static int recursionCount;
	private static int iterativeCount;
	
	public static void main(String[] args) {
//		System.out.println(computeRecursion(0));
//		System.out.println(computeRecursion(1));
//		System.out.println(computeRecursion(2));
//		System.out.println(computeRecursion(3));
//		System.out.println(computeRecursion(4));
//		System.out.println(computeRecursion(5));
//		System.out.println(computeRecursion(6));
//		System.out.println(computeRecursion(7));
//		
//		System.out.println(computeIterative(0));
//		System.out.println(computeIterative(1));
//		System.out.println(computeIterative(2));
//		System.out.println(computeIterative(3));
//		System.out.println(computeIterative(4));
//		System.out.println(computeIterative(5));
//		System.out.println(computeIterative(6));
//		System.out.println(computeIterative(7));
		for(int i = 0; i <= 10; i++) {
			computeRecursion(i);
			computeIterative(i);
			System.out.println("n: " + i + " || Recursion Efficiency: " + getEfficiency(false) + 
					" || Iterative Efficiency: " + getEfficiency(true));
		}
	}
	
	public static int computeRecursion(int num) throws NumberFormatException {
		if (num < 0) {
			throw new NumberFormatException();
		}
		recursionCount = 0;
		return actualRecursion(num);
	}
	private static int actualRecursion(int num) {
		if(num == 0) {
			recursionCount++;
			return 0;
		} else {
			recursionCount++;
			return (5*actualRecursion(num-1)) - (2*actualRecursion(num-1)) + 8;
		}
	}
	
	public static int computeIterative(int num) throws NumberFormatException {
		if (num < 0) {
			throw new NumberFormatException();
		}
		iterativeCount=0;
		int computedNum = 0;
		int prevNum1 = 0;
		for(int i = 0; i <= num; i++) {
			if(i==0) {
				computedNum = 0;
				iterativeCount++;
				continue;
			}
			prevNum1 = computedNum;
			computedNum = 5*prevNum1 - 2*prevNum1 + 8;
			iterativeCount++;
		}
		return computedNum;
	}
	public static int getEfficiency(boolean iterative) {
		if(iterative) {
			return iterativeCount;
		} else {
			return recursionCount;
		}
	}
	
	public static int getEfficiency(boolean iterative, int num) {
		if(iterative) {
			computeIterative(num);
			return iterativeCount;
		} else {
			computeRecursion(num);
			return recursionCount;
		}
	}
}

