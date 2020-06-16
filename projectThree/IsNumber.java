/* File:	IsNumber.java
 * Author:	Zack Finnegan
 * Date:	4/27/2019
 * Purpose: Kept adding isNumber method to my classes so I decided to just make it a class so the method would only be in one place.
 * 			Reduce redundancy.
 */

package projectThree;

public class IsNumber {
	public static boolean isNumber(String number) {
		try {
			Integer.parseInt(number);
			return true;
		} catch(NumberFormatException e) {
			return false;
		}
	}
}
