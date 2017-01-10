package exceptions;

import java.util.concurrent.ExecutionException;


public class ExecutionError extends ExecutionException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String infoError = " ";
	
public ExecutionError (String s){
	
	
		 this.infoError = s;
	}
	
public String toString(){
	
		return this.infoError;	
	}
}
