package ProjectTwo;
/* File: InsufficientFundsException.java
 * Author: Zachary Finnegan
 * Date: 6 February 2019
 * Purpose: Custom exception that is thrown when an account doesn't have enough funds for the withdrawal or transfer request.
 */
public class InsufficientFundsException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public InsufficientFundsException() {

	}

	public InsufficientFundsException(String e) {
		super(e);

	}

	public InsufficientFundsException(Throwable e) {
		super(e);

	}

	public InsufficientFundsException(String arg0, Throwable arg1) {
		super(arg0, arg1);

	}

	public InsufficientFundsException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}
}
