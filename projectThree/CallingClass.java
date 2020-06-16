package projectThree;

public class CallingClass {
	public static void main(String[] args) {
		int fun = Computation.computeIterative(5);
		int superFun = Computation.computeRecursion(5);
		System.out.println("fun is: " + fun + ".    superFun is: " + superFun);
		System.out.println("fun efficiency is: " + Computation.getEfficiency(true) + ".    superFun efficiency is: " + Computation.getEfficiency(false));
	}
//	System.out.println("Recursion of 0: " + computeRecursion(0) + " should be 0. Recusion Count: " + recursionCount);
//	System.out.println("Recursion of 1: " + computeRecursion(1) + " should be 1. Recusion Count: " + recursionCount);
//	System.out.println("Recursion of 2: " + computeRecursion(2) + " should be 2. Recusion Count: " + recursionCount);
//	System.out.println("Recursion of 3: " + computeRecursion(3) + " should be 5. Recusion Count: " + recursionCount);
//	System.out.println("Recursion of 4: " + computeRecursion(4) + " should be 12. Recusion Count: " + recursionCount);
//	System.out.println("Recursion of 5: " + computeRecursion(5) + " should be 29. Recusion Count: " + recursionCount);
//	System.out.println("Recursion of 6: " + computeRecursion(6) + " should be 70. Recusion Count: " + recursionCount);
//	System.out.println("Recursion of 7: " + computeRecursion(7) + " should be 169. Recusion Count: " + recursionCount);
//	System.out.println("Recursion of 8: " + computeRecursion(8) + " should be 408. Recusion Count: " + recursionCount);
//	System.out.println("Recursion of 9: " + computeRecursion(9) + " should be 985. Recusion Count: " + recursionCount);
//	
//	System.out.println("Iterative of 0: " + computeIterative(0) + " should be 0. Iterative Count: " + iterativeCount + "\n");
//	iterativeCount = 0;
//	System.out.println("Iterative of 1: " + computeIterative(1) + " should be 1. Iterative Count: " + iterativeCount + "\n");
//	iterativeCount = 0;
//	System.out.println("Iterative of 2: " + computeIterative(2) + " should be 2. Iterative Count: " + iterativeCount + "\n");
//	iterativeCount = 0;
//	System.out.println("Iterative of 3: " + computeIterative(3) + " should be 5. Iterative Count: " + iterativeCount + "\n");
//	iterativeCount = 0;
//	System.out.println("Iterative of 4: " + computeIterative(4) + " should be 12. Iterative Count: " + iterativeCount + "\n");
//	iterativeCount = 0;
//	System.out.println("Iterative of 5: " + computeIterative(5) + " should be 29. Iterative Count: " + iterativeCount + "\n");
//	iterativeCount = 0;
//	System.out.println("Iterative of 6: " + computeIterative(6) + " should be 70. Iterative Count: " + iterativeCount + "\n");
//	iterativeCount = 0;
//	System.out.println("Iterative of 7: " + computeIterative(7) + " should be 169. Iterative Count: " + iterativeCount + "\n");
//	iterativeCount = 0;
//	System.out.println("Iterative of 8: " + computeIterative(8) + " should be 408. Iterative Count: " + iterativeCount + "\n");
//	iterativeCount = 0;
//	System.out.println("Iterative of 9: " + computeIterative(9) + " should be 985. Iterative Count: " + iterativeCount + "\n");
//	iterativeCount = 0;
}
