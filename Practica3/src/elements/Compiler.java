package elements;

import javax.management.openmbean.ArrayType;

import bytecode.ByteCode;
import bytecode.ByteCodeProgram;
import comandos.ParsedProgram;
import exceptions.ArrayException;
import instruction.Instruction;

//TODO falta
public class Compiler {

	private ByteCodeProgram bcProgram;
	private String[] varTable;
	private int numVariables;
	
	public Compiler(){
		
	}

	
	//TODO 
	//TODO
	//TODO aniadido creo q va a getIndex!!!
	public int addVariable(String varName){
		boolean encontrado = false;
		int i=0;
		while (i < bcProgram.getPosicion()-1 && !encontrado){
			if (varName == varTable[i]){
				encontrado = true;
				return i;
			}
			else
				i++;
		}
		if (!encontrado)
			i= -1;
		return i;
	}
	public int getSizeProgram(){
		return bcProgram.getPosicion();
	}
	
	public void addByteCode(ByteCode bc) {
		// TODO Auto-generated method stub
		
	}
	
	public int getIndex(String varName) {
		// TODO Auto-generated method stub
		return 0;
	}
	public void initialize(ByteCodeProgram bcProgram){
		//TODO what..?¿?
	}
	public void compile(ParsedProgram pProgram) throws ArrayException{
		int i=0;
		try{
			Instruction instruction;
			while (i < pProgram.getPosicion()){
				instruction = pProgram.devolverString(i);
				instruction.compile(this);
				i++;
			}
		}catch (ArrayException e){
			System.err.println("Error de compilacion. Clase Compile");
		}
	}
}
