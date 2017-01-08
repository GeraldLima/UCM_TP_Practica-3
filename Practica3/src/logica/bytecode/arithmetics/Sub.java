package logica.bytecode.arithmetics;

import logica.bytecode.ByteCode;

public class Sub extends Arithmetics{


	@Override
	protected int executeAux(int valor1, int valor2) {
		
		return valor2 - valor1;
	}
	
	@Override
	protected ByteCode parseAux(String s) {
		
		if(s.equalsIgnoreCase("SUB")){
			return new Sub();
		}
		else return null;
	}
	
	public String toString(){
		return "SUB";
	}

}
