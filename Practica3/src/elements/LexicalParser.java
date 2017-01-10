package elements;

import instruction.Instruction;
import instruction.ParserInstruction;
import comandos.ParsedProgram;
import comandos.SourceProgram;
import exceptions.LexicalAnalysisException;

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
