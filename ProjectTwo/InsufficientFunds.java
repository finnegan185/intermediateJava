package ProjectTwo;

public class InsufficientFunds extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InsufficientFunds() {

	}

	public InsufficientFunds(String e) {
		super(e);

	}

	public InsufficientFunds(Throwable e) {
		super(e);

	}

	public InsufficientFunds(String arg0, Throwable arg1) {
		super(arg0, arg1);

	}

	public InsufficientFunds(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
