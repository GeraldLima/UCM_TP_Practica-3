package instruction.conditionals;

import instruction.assignments.Term;
import instruction.assignments.TermParser;
import bytecode.conditionalJumps.ConditionalJumps;
import elements.Compiler;
import elements.LexicalParser;
import exceptions.ArrayException;

//TODO COMPLETADA
public abstract class Condition {
	
	private Term term1;
	private Term term2;
	protected ConditionalJumps conditionalJ; //para la compilacion
	
	public Condition(){
		
	}
	
	public Condition(Term t1, Term t2){
		this.term1 = t1;
		this.term2 = t2;
	}
	
	
	public Condition parse(String t1, String op, String t2, LexicalParser parser){
		
		this.term1 = TermParser.parse(t1);
		this.term2 = TermParser.parse(t2);
		
		if(t1 == null || t2 == null){
			return null;
		}
		
		return parseOp(this.term1, op, this.term2, parser);
	}
		
	
	void compile(Compiler compiler) throws ArrayException{
		compiler.addByteCode(term1.compile(compiler));
		compiler.addByteCode(term2.compile(compiler));
		this.conditionalJ = compileOp();
		compiler.addByteCode(conditionalJ);
	}
	
	
	protected abstract ConditionalJumps compileOp();
	
	protected abstract Condition parseOp(Term t1, String op, Term t2, LexicalParser parser);


}
