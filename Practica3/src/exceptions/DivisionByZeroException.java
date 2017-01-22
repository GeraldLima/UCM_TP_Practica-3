package exceptions;

public class DivisionByZeroException extends ExecutionErrorException {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public DivisionByZeroException (String s){	
	
		super(s);
	}
	
	public String toString(){
	
		return super.toString();	
	}

}
