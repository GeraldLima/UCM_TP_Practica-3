package instruction.conditionals;

import instruction.Instruction;
import bytecode.conditionalJumps.ConditionalJumps;
import comandos.ParsedProgram;
import elements.Compiler;
import elements.LexicalParser;
import exceptions.ArrayException;

public class IfThen implements Instruction {
	
	private Condition condition;
	private ParsedProgram ifThenBody;
	
	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void compile(Compiler compiler) throws ArrayException {
		ConditionalJumps conditionalJ;
		condition.compile(compiler);
		compiler.compile(ifThenBody);
		conditionalJ = condition.conditionalJ;
		int num = compiler.getSizeProgram();
		//conditionalJ.setN(num);
		//TODO algo falla comentario notas
	}



}
