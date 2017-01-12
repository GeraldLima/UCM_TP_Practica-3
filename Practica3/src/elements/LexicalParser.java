package elements;

import instruction.Instruction;
import instruction.ParserInstruction;
import comandos.ParsedProgram;
import comandos.SourceProgram;
import exceptions.LexicalAnalysisException;


/*recorre el array sprogram k hay una linea en cada pos del array, 
consigo la primera si es igual al centinela entonces true y termino
y si no , pues tenemos k meter un aline en el pProgram
se encarga del control d convertir el string a instruccion 
	ejemplo x = 5 lo convierte en una simple asignacion
*/
public class LexicalParser {

	private SourceProgram sProgram;
	private int programCounter;
	
	public LexicalParser(){
		
	}

	public void inicilaizar(SourceProgram sProgram){
		this.sProgram = sProgram;
		this.programCounter = 0;
	}
	
	public void lexicalParser(ParsedProgram pProgram, String stopKey) throws LexicalAnalysisException{
		boolean stop = false;
		
		while (programCounter < sProgram.getPosicion() && (!stop)){
			String instr = sProgram.devolverString(programCounter);
			
			if (instr.equalsIgnoreCase(stopKey))
				stop = true;
			
			else {
				Instruction instruction = ParserInstruction.parse(instr, this); //te convierte la linea en la instruccion correspondiente
				if(instruction != null){
					pProgram.aniadirInstruccion(instruction);
				}
				
			}
			
		}
	}
	public void increaseProgramCounter(){
		programCounter++;
	}
	
	
}
