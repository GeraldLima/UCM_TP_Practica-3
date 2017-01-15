package exceptions;

@SuppressWarnings("serial")
public class ArrayException extends Exception {

	/**
	 * 
	 */
	
	private String infoError = " Violacion de array";
	
	public ArrayException (String s){
			
		 this.infoError = s;
	}
		
	public String toString(){
	
		return this.infoError;	
	}
}
