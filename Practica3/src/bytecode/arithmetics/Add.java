package bytecode.arithmetics;

import exceptions.StackException;
import bytecode.ByteCode;

public class Add extends Arithmetics{
	
	
	@Override
	protected int executeAux(int valor1, int valor2)throws StackException {
		
		return valor2 + valor1;
	}
	
	@Override
	protected ByteCode parseAux(String s) {
	
		if(s.equalsIgnoreCase("ADD")){
			return new Add();
		}
		else return null;
	}

	public String toString(){
		return "ADD";
	}

	

}
