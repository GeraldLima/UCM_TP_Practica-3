package bytecode.arithmetics;

import exceptions.StackException;
import bytecode.ByteCode;

public class Mul extends Arithmetics{


	@Override
	protected int executeAux(int valor1, int valor2) throws StackException{
		
		return valor1 * valor2;
	}

	@Override
	protected ByteCode parseAux(String s) {
		
		if(s.equalsIgnoreCase("MUL")){
			return new Mul();
		}
		else return null;
	}

	public String toString(){
		return "MUL";
	}
}
