package exceptions;

@SuppressWarnings("serial")
public class ArrayException extends Exception {

	/**
	 * 
	 */
	
	private String infoError = " ";
	
	public ArrayException (String s){
			
		 this.infoError = s;
	}
		
	public String toString(){
	
		return this.infoError;	
	}
}
