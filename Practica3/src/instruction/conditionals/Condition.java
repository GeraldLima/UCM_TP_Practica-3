package instruction.conditionals;

import instruction.term.Term;
import bytecode.conditionalJumps.ConditionalJumps;
import elements.Compiler;
import elements.LexicalParser;
import exceptions.ArrayException;

public abstract class Condition {
	private Term t1;
	private Term t2;
	protected ConditionalJumps conditionalJ;
	
	public Condition(){
		
	}
	public Condition(Term t1, Term t2){
		
	}
	
	Condition parse(String t1, String op, String t2,	LexicalParser parser){
		return null;
	}
	void compile(Compiler compiler) throws ArrayException{
		//TODO FALTA
	}
	protected abstract ConditionalJumps compileOp();
	protected abstract Condition parseOp(String t1, String op, String t2,	LexicalParser parser);
	//Otros métodos abstractos

}
