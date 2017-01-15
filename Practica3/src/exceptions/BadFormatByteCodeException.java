package exceptions;


@SuppressWarnings("serial")
public class BadFormatByteCodeException extends Exception {

	/**
	 * 
	 */
	
	private String infoError = "Fallo de formato de instruccion ";
	
	public BadFormatByteCodeException (String s){	
	
		 this.infoError = s;
	}
	
	public String toString(){
	
		return this.infoError;	
	}
}
