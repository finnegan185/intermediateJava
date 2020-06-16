/* File: Computation.java
 * Author: Zachary Finnegan
 * Date: 2/20/2019
 * Purpose: Backend to the RecursionGUI that holds the iterative and recursive methods for
 * computing the values in the sequence 0,1,5,12,29. The number of iterations is compared
 * against the number of recursion calls to see which is more efficient in the RecursionGUI
 */

package projectThree;

public class Computation {
	private static int recursionCount;
	private static int iterativeCount;
	
	public static void main(String[] args) {
		
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
		} else if(num == 1) {
			recursionCount++;
			return 1;
		} else {
			recursionCount++;
			return 2*actualRecursion(num-1) + actualRecursion(num-2);
		}
	}
	
	public static int computeIterative(int num) throws NumberFormatException {
		if (num < 0) {
			throw new NumberFormatException();
		}
		iterativeCount=0;
		int computedNum = 0;
		int prevNum1 = 0;
		int prevNum2 = 0;
		for(int i = 0; i <= num; i++) {
			if(i==0) {
				iterativeCount++;
				continue;
			} else if(i==1) {
				prevNum2 = 1;
				computedNum = 2*prevNum1 + prevNum2;
				iterativeCount++;
				continue;
			}
			prevNum2 = prevNum1;
			prevNum1 = computedNum;
			computedNum = 2*prevNum1 + prevNum2;
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
