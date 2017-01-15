package exceptions;

public class StackException extends StackOverflowError {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	private String infoError = "Violacion de pila";
	
	public StackException (String s){
		
		 this.infoError = s;
	}
	
	public String toString(){
	
		return this.infoError;	
	}
}
