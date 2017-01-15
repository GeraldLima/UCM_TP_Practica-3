	package instruction;

import elements.Compiler;
import elements.LexicalParser;
import exceptions.ArrayException;
import exceptions.LexicalAnalysisException;

public interface Instruction {
	
	
	Instruction lexParse(String[] words, LexicalParser lexParser) throws LexicalAnalysisException;
	void compile(Compiler compiler) throws ArrayException;
}
