package logica.instruction;

import comandos.LexicalParser;
import exceptions.ArrayException;
import logica.term.Term;

public class CompoundAssignment implements Instruction {
	private String varName;
	private String operator;
	private Term t1;
	private Term t2;

	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void compile(Compiler compiler) throws ArrayException {
		// TODO Auto-generated method stub
		
	}

}
