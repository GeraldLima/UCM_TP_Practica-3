package instruction.term;

import bytecode.ByteCode;

public class Variable implements Term {

	private String varName;
	
	public Variable(String term) {
		// TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		return null;
	}
	public String toString(){
		return varName;
	}

}
