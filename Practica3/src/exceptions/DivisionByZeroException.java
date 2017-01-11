package exceptions;

public class DivisionByZeroException {
	
	
	private String infoError = " ";
	
	public DivisionByZeroException (String s){	
	
		 this.infoError = s;
	}
	
	public String toString(){
	
		return this.infoError;	
	}

}
