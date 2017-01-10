package instruction.term;

import instruction.Instruction;
import bytecode.ByteCode;
import bytecode.oneParameterInstructions.Store;
import comandos.Compile;
import elements.Compiler;
import elements.LexicalParser;
import exceptions.ArrayException;

public class SingleAssignment implements Instruction{

	private String varName;
	private Term rhs;
	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		if (words.length != 3)
			return null;
		else{
			Compiler compiler = new Compiler();
			//ByteCode b1 = rhs.compile(compiler); da error no se pork
			int index = compiler.getIndex(varName);
			ByteCode bc = new Store(index);
			//compiler.addByteCode(b1);
			////////
			Term term = TermParser.parse(words[2]);
			lexParser.increaseProgramCounter();
		}
		return null;
	}
	@Override
	public void compile(java.lang.Compiler compiler) throws ArrayException {
		// TODO Auto-generated method stub
		
	}


}
