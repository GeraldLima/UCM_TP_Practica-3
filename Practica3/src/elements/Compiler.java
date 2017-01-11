package elements;

import bytecode.ByteCode;
import bytecode.ByteCodeProgram;
import comandos.ParsedProgram;
import exceptions.ArrayException;
import instruction.Instruction;

public class Compiler {

	private ByteCodeProgram bcProgram;
	private String[] varTable;
	private int numVariables;
	
	public Compiler(){
		
	}

	public void addByteCode(ByteCode bc) {
		// TODO Auto-generated method stub
		
	}
	public int addVariable(String varName){
		return 0;
	}
	public int getSizeProgram(){
		return bcProgram.getPosicion();
	}

	public int getIndex(String varName) {
		// TODO Auto-generated method stub
		return 0;
	}
	public void initialize(ByteCodeProgram bcProgram){
		
	}
	public void compile(ParsedProgram pProgram) throws ArrayException{
		int i=0;
		Instruction instruction;
		while (i < pProgram.getPosicion()){
			instruction = pProgram.devolverString(i);
			instruction.compile(this);
			i++;
		}
	}
}
