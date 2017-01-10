package exceptions;


public class BadFormatByteCode extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private String infoError = " ";
	
public BadFormatByteCode (String s){
	
	
		 this.infoError = s;
	}
	
public String toString(){
	
		return this.infoError;	
	}
}
