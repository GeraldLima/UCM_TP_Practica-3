package exceptions;


public class LexicalAnalysisException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String infoError = " ";
	
public LexicalAnalysisException (String s){
	
	
		 this.infoError = s;
	}
	
public String toString(){
	
		return this.infoError;	
	}
}
