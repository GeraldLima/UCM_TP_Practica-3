package exceptions;

import java.util.concurrent.ExecutionException;


@SuppressWarnings("serial")
public class ExecutionErrorException extends ExecutionException {

	/**
	 * 
	 */

	private String infoError = " ";
	
	public ExecutionErrorException (String s){	
	
		 this.infoError = s;
	}
	
	public String toString(){
	
		return this.infoError;	
	}
}
