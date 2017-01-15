package instruction.assignments;

import bytecode.ByteCode;
import bytecode.oneParameterInstructions.Push;
import elements.Compiler;

//TODO COMPLETADA
public class Number implements Term {
	
	private int num;
	
	/**
	 * Constructor con parametros
	 * @param n numero que recibe
	 */
	public Number (int n){
		
		this.num = n;
	}

	
	@Override
	public Term parse(String term) {
		
		try{
			int numero = Integer.parseInt(term);
			return new Number(numero);
		}
		catch(NumberFormatException e){
			System.out.println("EXCEPCION: Formato numerico incorrecto...");
			return null;
		}
	}

	@Override
	public ByteCode compile(Compiler compiler) {
		
		return new Push(num);
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}

	public String toString(){
		
		String s = String.valueOf(num);
				
		return s;
	}
}
