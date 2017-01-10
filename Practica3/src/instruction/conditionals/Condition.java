package instruction.conditionals;

import instruction.term.Term;
import bytecode.conditionalJumps.ConditionalJumps;
import elements.LexicalParser;
import exceptions.ArrayException;

public class Condition {
	private Term t1;
	private Term t2;
	private ConditionalJumps condition;
	
	public Condition parse(String t1, String op, String t2,	LexicalParser parser){
		return null;
	}
	public void compile(Compiler compiler) throws ArrayException{
		
	}
	//Otros métodos abstractos

}
