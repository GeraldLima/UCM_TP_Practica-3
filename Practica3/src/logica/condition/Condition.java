package logica.condition;

import comandos.LexicalParser;
import exceptions.ArrayException;
import logica.bytecode.conditionalJumps.ConditionalJumps;
import logica.term.Term;

public class Condition {
	private Term t1;
	private Term t2;
	private ConditionalJumps condition;
	
	public Condition parse(String t1, String op, String t2,	LexicalParser parser){
		return null;
	}
	public void compile(Compiler compiler) throws ArrayException{
		
	}
	//Otros m�todos abstractos

}
