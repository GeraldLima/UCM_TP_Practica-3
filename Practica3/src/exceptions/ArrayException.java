package exceptions;

public class ArrayException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String infoError = " ";
	
public ArrayException (String s){
		
		 this.infoError = s;
	}
	
public String toString(){
	
		return this.infoError;	
	}
}
