package exceptions;



public class ExecutionErrorException extends Exception {

	
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	private String infoError = " Fallo de ejecucion";
	
	public ExecutionErrorException (String s){	
	
		 this.infoError = s;
	}
	
	public String toString(){
	
		return this.infoError;	
	}
}
