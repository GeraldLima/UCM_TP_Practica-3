package instruction.conditionals;

import instruction.assignments.Term;
import bytecode.conditionalJumps.ConditionalJumps;
import bytecode.conditionalJumps.IfEq;
import elements.LexicalParser;

/**
 * Clase que representa el operador =
 */
public class Equal extends Condition {

	/**
	 * Constructora por defecto
	 */
	public Equal(){
		super();
	}
	
	/**
	 * Constructora con parametros
	 * @param t1, primer termino
	 * @param t2, segundo termino
	 */
	public Equal(Term t1, Term t2){
		super(t1,t2);
	}
	
	
	@Override
	protected ConditionalJumps compileOp() {
		
		return new IfEq(0);
	}


	@Override
	protected Condition parseOp(Term t1, String op, Term t2, LexicalParser parser) {
		
		if(op.equals("=")){
			parser.increaseProgramCounter();
			return new Equal(t1,t2);
		}
		else
			
			return null;
	}

}
