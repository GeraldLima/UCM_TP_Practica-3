package bytecode;

import bytecode.arithmetics.Add;
import bytecode.arithmetics.Div;
import bytecode.arithmetics.Mul;
import bytecode.arithmetics.Sub;
import bytecode.conditionalJumps.IfEq;
import bytecode.conditionalJumps.IfLe;
import bytecode.conditionalJumps.IfLeq;
import bytecode.conditionalJumps.IfNeq;
import bytecode.oneParameterInstructions.Goto;
import bytecode.oneParameterInstructions.Load;
import bytecode.oneParameterInstructions.Push;
import bytecode.oneParameterInstructions.Store;


/**
 * Clase que se encarga de parsear los byteCode
 */



public class ByteCodeParser {
	
	
	private final static ByteCode[] byteCodes ={
		new Add(), 
		new Div(), 
		new Mul(),
		new Sub(),
		new Halt(),
		new Out(),
		new Load(),
		new Push(),
		new Store(),
		new Goto(),
		new IfEq(),
		new IfLe(),
		new IfLeq(),
		new IfNeq(),
		};
	
	
	public static ByteCode parse(String line) {
		// eliminar blancos innecesarios igual que en la Práctica 1ine = line.trim();
		// descomponer line en palabras
		
		line.trim();
		String[] words = line.split(" +");	
	
		
		boolean encontrado = false;		
		ByteCode byteCode  = null;
		
		
		int i=0;
		while (i < byteCodes.length && !encontrado){
		
			byteCode = byteCodes[i].parse(words);
			
			if (byteCode !=null){
				encontrado = true;
			}
			else {
				i++;
			}
		}
		return byteCode;
	}
	
	
}
