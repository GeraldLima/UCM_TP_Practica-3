package instruction.conditionals;

import bytecode.conditionalJumps.ConditionalJumps;
import instruction.Instruction;
import comandos.ParsedProgram;
import elements.Compiler;
import elements.LexicalParser;
import exceptions.ArrayException;
import exceptions.LexicalAnalysisException;

public class IfThen implements Instruction {
	
	private Condition condition;
	private ParsedProgram body;
	
	/**
	 * Constructora por defecto
	 */
	public IfThen(){
		
	}
	
	/**
	 * Constructora con parametros
	 */
	public IfThen(Condition cd, ParsedProgram ifBody){
		this.condition = cd;
		this.body = ifBody;
	}
	
	
	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) throws LexicalAnalysisException, ArrayException {
				
		if(words.length != 4){
			return null;
		}
		
		else{
			
			if(!words[0].equals("if")){
				return null;		
			}
				
		Condition cond = ConditionParser.parse(words[1], words[2], words[3], lexParser);
		ParsedProgram ifbody = new ParsedProgram();
		lexParser.lexicalParser(ifbody, "ENDIF");
		lexParser.increaseProgramCounter();
		
		return new IfThen(cond, ifbody);
		}
	}

	//TODO completado
	@Override
	public void compile(Compiler compiler) throws ArrayException {
		
		this.condition.compile(compiler); 
		compiler.compile(this.body);
		ConditionalJumps cj = this.condition.conditionalJ;
		int n = compiler.getSizeBcProgram();
		cj.setN(n);
				
	}



}
