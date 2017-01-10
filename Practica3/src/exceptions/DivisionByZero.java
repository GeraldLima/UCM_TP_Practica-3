package exceptions;

public class DivisionByZero {
	
	private String infoError = " ";
	
public DivisionByZero (String s){
	
	
		 this.infoError = s;
	}
	
public String toString(){
	
		return this.infoError;	
	}

}
