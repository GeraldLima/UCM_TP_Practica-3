package instruction;

import elements.Compiler;
import elements.LexicalParser;
import exceptions.ArrayException;

public class Write implements Instruction {

	private String varName;
	
	
	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
			
		return null;
	}

	@Override
	public void compile(Compiler compiler) throws ArrayException {
		// TODO Auto-generated method stub
		
	}


}
