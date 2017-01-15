package instruction.conditionals;

import instruction.assignments.Term;
import bytecode.conditionalJumps.ConditionalJumps;
import bytecode.conditionalJumps.IfLe;
import elements.LexicalParser;

/**
 * Clase que representa el operador <
 */
public class Less extends Condition {

	/**
	 * Constructor por defecto
	 */
	public Less(){
		super();
	}
	
	/**
	 * Constructor con parametros
	 * @param t1, primer termino
	 * @param t2, segundo termino
	 */
	public Less(Term t1, Term t2){
		super(t1,t2);
	}
	
	
	@Override
	protected ConditionalJumps compileOp() {
		
		return new IfLe(0);
	}


	@Override
	protected Condition parseOp(Term t1, String op, Term t2, LexicalParser parser) {
		
		if(op.equals("<")){
			parser.increaseProgramCounter();
			return new Less(t1,t2);
		}
		else
			
			return null;
	}

}
