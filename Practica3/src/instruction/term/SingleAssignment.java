package instruction.term;

import instruction.Instruction;
import bytecode.ByteCode;
import bytecode.oneParameterInstructions.Store;
import comandos.Compile;
import elements.Compiler;
import elements.LexicalParser;
import exceptions.ArrayException;

public class SingleAssignment implements Instruction{

	private String varName;
	private Term rhs;
	
	
	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		if (words.length != 3)
			return null;
		else{
			Compiler compiler = new Compiler();
			//ByteCode b1 = rhs.compile(compiler); da error no se pork
			int index = compiler.getIndex(varName);
			ByteCode bc = new Store(index);
			//compiler.addByteCode(b1);
			////////
			
			lexParser.increaseProgramCounter(); //se incrementa el contador cada vez que ya haya una instruccion
			//incrementa el array del sprogram
			Term term = TermParser.parse(words[2]); ///el parse del termino te convierte el string en un objeto termino pork cuando
			
		}
		return null;
		//new simplraidsjdife(varname, rsh)
	}
	
	
	@Override
	public void compile(Compiler compiler) throws ArrayException {
		// TODO Auto-generated method stub
		
	}


}
