package bytecode.arithmetics;

import exceptions.DivisionByZeroException;
import exceptions.StackException;
import bytecode.ByteCode;

public class Div extends Arithmetics{


	@Override
	protected int executeAux(int valor1, int valor2) throws DivisionByZeroException , StackException{
			
			try{
			return valor2 / valor1;			
			}
			catch(Exception e){
				
				throw new DivisionByZeroException(System.getProperty("line.separator") + "EXCEPCION-bytecode " + toString() + ": Division por cero");
			}
	}

	
	@Override
	protected ByteCode parseAux(String s) {
		
		if(s.equalsIgnoreCase("DIV")){
			return new Div();
		}
		else return null;
	}
	
	public String toString(){
		return "DIV";
	}
	
}
