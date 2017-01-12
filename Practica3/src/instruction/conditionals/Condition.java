package instruction.conditionals;

import instruction.term.Term;
import instruction.term.TermParser;
import bytecode.conditionalJumps.ConditionalJumps;
import elements.Compiler;
import elements.LexicalParser;
import exceptions.ArrayException;

//TODO falta
public abstract class Condition {
	private Term term1;
	private Term term2;
	protected ConditionalJumps conditionalJ;
	
	public Condition(){
		
	}
	public Condition(Term t1, Term t2){
		
	}
	
	Condition parse(String t1, String op, String t2, LexicalParser parser){
		term1 = TermParser.parse(t1);
		term2 = TermParser.parse(t2);
		//TODO falta
		//conditionalJ.parse(parser.)
		return null;
		
	}
	void compile(Compiler compiler) throws ArrayException{
		//TODO FALTA
	}
	protected abstract ConditionalJumps compileOp();
	protected abstract Condition parseOp(String t1, String op, String t2, LexicalParser parser);
	//Otros métodos abstractos

}
