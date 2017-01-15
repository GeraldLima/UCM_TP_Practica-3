package instruction;

import elements.LexicalParser;
import exceptions.LexicalAnalysisException;
import instruction.assignments.CompoundAssignment;
import instruction.assignments.SingleAssignment;
import instruction.conditionals.IfThen;
import instruction.conditionals.While;


//TODO COMPLETA

/**
 * Clase que se encarga de parsear las instrucciones
 */
public class ParserInstruction {

	/**
	 * 
	 */
	private final static Instruction[] instructions = {
		
			new SingleAssignment(), new CompoundAssignment(),
			new Write(), new Return(), new While(), new IfThen()
	};
	

	/**
	 * Metodo que parsea las instrucciones
	 * @param instr, instruccion que recibe
	 * @param lexicalParser
	 * @return insterucion, que es la instrucion correctamente parseada
	 * @throws LexicalAnalysisException 
	 */
	public static Instruction parse(String line, LexicalParser lexicalParser) throws LexicalAnalysisException {
		
		int i = 0;
		boolean encontrado = false;	
		Instruction instruction = null;
		line.trim();
		//line.trim();
		
		String[] words = line.split(" +");
		//words = words + line.split(" +");	
	
		while (i < instructions.length && !encontrado){	
			instruction = instructions[i].lexParse(words, lexicalParser);	
			
			if (instruction !=null){
				encontrado = true;
			}
			else {
				i++;
			}
		}
		return instruction;		
		
	}

}
