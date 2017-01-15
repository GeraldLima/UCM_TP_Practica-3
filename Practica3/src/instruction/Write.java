package instruction;

import bytecode.Out;
import bytecode.oneParameterInstructions.Load;
import elements.Compiler;
import elements.LexicalParser;
import exceptions.ArrayException;


public class Write implements Instruction {

	private String varName;
	
	/**
	 * Constructor por defecto
	 */
	public Write(){
		
	}
	
	/**
	 * Constructor con parametros
	 * @param varName, nombre de la variable
	 */
	public Write(String varName){
		this.varName = varName;
	}
	
	
	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		
		if(words.length != 2){
			return null;
		}
		
		else{
			if(!words[0].equals("write")){
				return null;
			}
			
			String varName = words[1];
			lexParser.increaseProgramCounter();
			
			return new Write(varName);
		}		
	}

	@Override
	public void compile(Compiler compiler) throws ArrayException {
		int indice = compiler.getIndex(varName);
		compiler.addByteCode(new Load(indice));
		compiler.addByteCode(new Out());		
		
	}

	public String getVarName() {
		return varName;
	}

	public void setVarName(String varName) {
		this.varName = varName;
	}


	
}
