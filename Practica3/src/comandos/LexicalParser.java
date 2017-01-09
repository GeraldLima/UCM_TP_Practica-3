package comandos;

import exceptions.LexicalAnalysisException;
import logica.instruction.Instruction;
import logica.instruction.ParserInstruction;

public class LexicalParser {

	private SourceProgram sProgram;
	private int programCounter;
	
	public void lexicalParser(ParsedProgram pProgram, String stopKey) throws LexicalAnalysisException{
		boolean stop = false;
		
		while (programCounter < sProgram.getNumeroInstrucciones()){
			String instr = sProgram.getInstruction(programCounter);
			if (instr.equalsIgnoreCase(stopKey))
				stop = true;
			else {
				Instruction instruction = ParserInstruction.parse(instr, this);
				//añadir instruccion
			}
		}
	}
	public void increaseProgramCounter(){
		programCounter++;
	}
	
	
}
