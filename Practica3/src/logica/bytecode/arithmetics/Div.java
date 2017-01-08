package logica.bytecode.arithmetics;

import logica.bytecode.ByteCode;

public class Div extends Arithmetics{


	@Override
	protected int executeAux(int valor1, int valor2) {
			
		int resul = 0;

		if(valor1 == 0){
			System.out.print("");
		}
		
		else{			
			resul = valor2 / valor1;			
		}			
		return resul;
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
