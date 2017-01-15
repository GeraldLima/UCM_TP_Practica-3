package instruction;

import bytecode.Halt;
import elements.Compiler;
import elements.LexicalParser;
import exceptions.ArrayException;



//TODO clase return falta compile

/**
 * Clase que representa la instruccion Return
 */
public class Return implements Instruction {

	/**
	 * Constructor por defecto
	 */
	public Return(){
		
	}
	
	
	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		
		if(words.length != 1)
			return null;
		
		else{
			
			if(!words[0].equals("return")){
				return null;
			}
			
			lexParser.increaseProgramCounter();
			return new Return();
		}
		
	}

	@Override
	public void compile(Compiler compiler) throws ArrayException {
		
		compiler.addByteCode(new Halt());
		
	}



}
