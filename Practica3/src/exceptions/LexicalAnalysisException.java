package exceptions;


@SuppressWarnings("serial")
public class LexicalAnalysisException extends Exception {

	/**
	 * 
	 */

	private String infoError = " ";
	
	public LexicalAnalysisException (String s){	
	
		 this.infoError = s;
	}
	
	public String toString(){
	
		return this.infoError;	
	}
}
