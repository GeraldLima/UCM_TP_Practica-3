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
//TODO COMPLETADA

/**
 *Clase que se encarga del analisis lexico
 */
public class LexicalParser {

	private SourceProgram sProgram;
	private int programCounter;
	
	/**
	 * Constructora
	 */
	public LexicalParser(){
		
	}

	/**
	 * Clase que se encarga de inicializar el programa fuente
	 * @param sProgram, programa fuente
	 */
	public void inicializar(SourceProgram sProgram){
		this.sProgram = sProgram;
		this.programCounter = 0;
	}
	
	/**
	 * Metodo que se encarga  realizar el analisis lexico
	 * @param pProgram, programa parseado
	 * @param stopKey, centinela
	 * @throws LexicalAnalysisException, excepcion
	 */
	public void lexicalParser(ParsedProgram pProgram, String stopKey) throws LexicalAnalysisException{
		boolean stop = false;
		
		while (programCounter < sProgram.getPosicion() && (!stop)){
			String line = sProgram.devolverString(programCounter);
			
			if (line.equalsIgnoreCase(stopKey))
				stop = true;
			
			else {
				Instruction instruction = ParserInstruction.parse(line, this); //te convierte la linea en la instruccion correspondiente
				if(instruction != null){
					pProgram.aniadirInstruccion(instruction);
					increaseProgramCounter();
				}
				
			}
			
		}
	}
	
	/**
	 * Metodo que se encarga de incrementar el contador
	 */
	public void increaseProgramCounter(){
		programCounter++;
	}
	
	
}
