package instruction.conditionals;

import instruction.Instruction;
import comandos.ParsedProgram;
import elements.Compiler;
import elements.LexicalParser;
import exceptions.ArrayException;
import exceptions.LexicalAnalysisException;

public class While implements Instruction {
	
	private Condition condition;
	private ParsedProgram whileBody;

	public While(Condition cond, ParsedProgram whileBody2) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) throws LexicalAnalysisException {
		Condition cond = ConditionParser.parse(words[1], words[2], words[3], lexParser);
		ParsedProgram wBody = new ParsedProgram();
		lexParser.lexicalParser(wBody, "ENDWHILE");
		lexParser.increaseProgramCounter();
		
		return new While(cond, whileBody);
	}

	@Override
	public void compile(Compiler compiler) throws ArrayException {
		// TODO Auto-generated method stub
		
	}



}
