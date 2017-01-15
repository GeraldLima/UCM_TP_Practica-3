package instruction.assignments;

import instruction.Instruction;
import bytecode.oneParameterInstructions.Store;
import elements.Compiler;
import elements.LexicalParser;
import exceptions.ArrayException;


/**
 * Clase que representa una asignacion simple
 */
public class SingleAssignment implements Instruction{

	private String varName;
	private Term rhs;
	
	/**
	 * Constructor por defecto
	 */
	public SingleAssignment(){
		
	}
	
	/**
	 * Constructor con parametros
	 * @param varName, nombre de la variable
	 * @param rhs, termino
	 */
	public SingleAssignment(String varName, Term rhs){
		this.varName = varName;
		this.rhs = rhs;
		
	}
	
	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		
		if (words.length != 3)
			return null;
		
		else{
			
			if(words[0].length() != 1){ //solo puede tener longitud 1 ejemplo numero = 1; no numero dos = 1;
				return null;
			}
			
			if(!words[1].equals("=")){ //si no es de tipo asignacion 
				return null;
			}
			
			String varName = words[0]; //el nombre de la variable esta en la pos 0
			Term term = TermParser.parse(words[2]); // el termino que puede ser un numero o una variable
			
			if(term == null ){
				return null;
			}
			 
			lexParser.increaseProgramCounter();
			return new SingleAssignment(varName, term);
		}
		
	}
	
	
	@Override
	public void compile(Compiler compiler) throws ArrayException {
		
		int index = compiler.getIndex(varName);		
		compiler.addByteCode(rhs.compile(compiler)); //genera el bytecode generado por term
		compiler.addByteCode(new Store(index));
		
	}

	public String getVarName() {
		return varName;
	}

	public void setVarName(String varName) {
		this.varName = varName;
	}

	public Term getRhs() {
		return rhs;
	}

	public void setRhs(Term rhs) {
		this.rhs = rhs;
	}

	


}
