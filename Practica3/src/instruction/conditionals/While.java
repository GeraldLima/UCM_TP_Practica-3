package instruction.conditionals;

import instruction.Instruction;
import bytecode.conditionalJumps.ConditionalJumps;
import bytecode.oneParameterInstructions.Goto;
import comandos.ParsedProgram;
import elements.Compiler;
import elements.LexicalParser;
import exceptions.ArrayException;
import exceptions.LexicalAnalysisException;


public class While implements Instruction {
	
	private Condition condition;
	private ParsedProgram whileBody;

	public While(){
		
	}
	
	public While(Condition cond, ParsedProgram body) {
		
		this.condition = cond;
		this.whileBody = body;
	}

	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) throws LexicalAnalysisException {

		if(words.length != 4){
			return null;
		}
		
		else{
			
			if(!words[0].equals("while")){
				return null;		
			}
		
			Condition cond = ConditionParser.parse(words[1], words[2], words[3], lexParser);
			ParsedProgram wBody = new ParsedProgram();
			lexParser.lexicalParser(wBody, "ENDWHILE");
			lexParser.increaseProgramCounter();
		
			return new While(cond, wBody);
		}
	}
	
	
	@Override
	public void compile(Compiler compiler) throws ArrayException {
		
		int m = compiler.getSizeBcProgram(); //la m es pa posicion del while
		this.condition.compile(compiler); //creo el bytecode de salto y lo meto en el array
		compiler.compile(this.whileBody); //creo bytecode del cuerpo y lo meto en el array
		compiler.addByteCode(new Goto(m)); //para repetir el bucle meto en goto en el array
		ConditionalJumps cj = this.condition.conditionalJ;
		int n = compiler.getSizeBcProgram(); //se modifica la posicion cuando se sale del while
		cj.setN(n);
		
		
	
		
	}


	
	
	
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
