package main;

import control.Engine;
import exceptions.ArrayException;
import exceptions.BadFormatByteCodeException;
import exceptions.ExecutionErrorException;
import exceptions.LexicalAnalysisException;
import exceptions.StackException;


/**
 * 
 * @author Gerald L. and Andrea Salami
 * 
 * Clase principal
 *
 */
public class Main {
	
	public static void main(String args[]) throws StackException, ExecutionErrorException, LexicalAnalysisException, ArrayException, BadFormatByteCodeException{
		
		Engine engine = new Engine();
		engine.start();
	}

}
