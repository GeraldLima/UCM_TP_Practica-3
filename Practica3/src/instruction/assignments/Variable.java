package instruction.assignments;

import bytecode.ByteCode;
import bytecode.oneParameterInstructions.Load;
import elements.Compiler;

/**
 * Clase que representa una variable
 */
public class Variable implements Term {

	private String varName;
	
	/**
	 * constructor con parametros
	 * @param term, nombre de la variable
	 */
	public Variable(String term) {
		this.varName = term;
	}
	

	@Override
	public Term parse(String term) {
		
		if (term.length() != 1)
			return null;
		
		else{
			
			char name = term.charAt(0); //lo convierte a char pork sino no se puede hacer la comparacion
			
			if ('a' <= name && name <= 'z')
				
				return new Variable(term);
			else
				return null;
		}
	}

	
	@Override
	public ByteCode compile(Compiler compiler) {
		
		int index = compiler.getIndex(this.varName); //index indice que ocupala la variable en la tabla
		return new Load(index);
	}
	
	
	public String toString(){
		return varName;
	}

}
