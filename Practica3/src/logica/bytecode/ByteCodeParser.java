package logica.bytecode;

import logica.bytecode.arithmetics.Add;
import logica.bytecode.arithmetics.Div;
import logica.bytecode.arithmetics.Mul;
import logica.bytecode.arithmetics.Sub;
import logica.bytecode.conditionalJumps.IfEq;
import logica.bytecode.conditionalJumps.IfLe;
import logica.bytecode.conditionalJumps.IfLeq;
import logica.bytecode.conditionalJumps.IfNeq;
import logica.bytecode.oneParameterInstructions.Goto;
import logica.bytecode.oneParameterInstructions.Load;
import logica.bytecode.oneParameterInstructions.Push;
import logica.bytecode.oneParameterInstructions.Store;


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
