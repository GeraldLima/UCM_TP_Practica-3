package logica.instruction;

import comandos.Compile;
import comandos.LexicalParser;
import exceptions.ArrayException;
import logica.bytecode.ByteCode;
import logica.bytecode.oneParameterInstructions.Store;
import logica.term.Term;
import logica.term.TermParser;

public class SingleAssignment implements Instruction {

	private String varName;
	private Term rhs;
	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		if (words.length != 3)
			return null;
		else{
			Compiler compiler = new Compiler();
			ByteCode b1 = rhs.compile(compiler)
			int index = compiler.getIndex(varName);
			ByteCode bc = new Store(index);
			compiler.addByteCode(b1);
			////////
			Term term = TermParser.parse(words[2]);
			lexParser.increaseProgramCounter();
		}
		return null;
	}

	@Override
	public void compile(Compiler compiler) throws ArrayException {
		// TODO Auto-generated method stub
		
	}

}
