package exceptions;

public class StackException extends StackOverflowError {

	/**
	 * 
	 */

	private String infoError = " ";
	
	public StackException (String s){
		
		 this.infoError = s;
	}
	
	public String toString(){
	
		return this.infoError;	
	}
}
