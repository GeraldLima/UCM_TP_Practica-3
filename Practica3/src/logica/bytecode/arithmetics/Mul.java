package logica.bytecode.arithmetics;

import logica.bytecode.ByteCode;

public class Mul extends Arithmetics{


	@Override
	protected int executeAux(int valor1, int valor2) {
		
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
