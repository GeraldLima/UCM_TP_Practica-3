package elements;

import bytecode.ByteCode;

import bytecode.ByteCodeProgram;
import comandos.ParsedProgram;
import exceptions.ArrayException;
import instruction.Instruction;

//TODO completada
public class Compiler {

	private static final int DIM = 50;
	private ByteCodeProgram bcProgram;
	private String[] varTable;
	private int numVariables;
	
	public Compiler(){
		
	}

	public void Inicialize(ByteCodeProgram bcProgram){
		this.bcProgram = bcProgram;
		this.varTable = new String[DIM];
		this.numVariables = 0;
	}

	public void compile(ParsedProgram pProgram) throws ArrayException{
		
		int i = 0;
		
		try{
			
			while(i < pProgram.getPosicion()){
				Instruction inst = pProgram.devolverString(i);
				inst.compile(this);
				i++;
			}
		}
		catch(ArrayException e){	
			throw e;
		}
	}
	
	/**
	 * Metodo que se encarga de aniadir una instruccion ByteCode
	 * @param b, instruccion a añadir
	 * @throws ArrayException
	 */
	public void addByteCode(ByteCode b) throws ArrayException{
		bcProgram.aniadirInstruccion(b);
	}
	
	
	
	public int getIndex(String varName){
		
		int i = 0;
		boolean encontrado = false;
		
		while(i < numVariables && !encontrado){
			
			if(varTable[i].equals(varName)){
				encontrado = true;
			}
			
			i++;
		}
		
		if(encontrado)
			return i - 1;
		
		
		else{
			
			i = this.addVariable(varName);
			return i;
		}
	}
	
	
	public int addVariable(String varName){
	
		this.varTable[this.numVariables] = varName;
		this.numVariables++;
		
		return this.numVariables - 1;
	}
	
	public int getSizeBcProgram(){
		return bcProgram.getPosicion();
	}
	
	
	public int indexOf(java.lang.String varName){
		return 0;
	}
	
	
	
	
	
	
	
}
