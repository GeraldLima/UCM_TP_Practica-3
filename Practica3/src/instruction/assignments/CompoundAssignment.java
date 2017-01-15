package instruction.assignments;

import instruction.Instruction;

import bytecode.arithmetics.Add;
import bytecode.arithmetics.Div;
import bytecode.arithmetics.Mul;
import bytecode.arithmetics.Sub;
import bytecode.oneParameterInstructions.Store;
import elements.Compiler;
import elements.LexicalParser;
import exceptions.ArrayException;

/**
 *
 */
public class CompoundAssignment implements Instruction {
	private String varName;
	private String operator;
	private Term t1;
	private Term t2;

	
	/**
	 * Constructor por defecto
	 */
	public CompoundAssignment(){
		
	}
	
	/**
	 * Constructora con parametros
	 * @param varName, nombre de la variable
	 * @param op, operando aritmetico
	 * @param term1, primer termino
	 * @param term2, segundo termino
	 */
	public CompoundAssignment(String varName, String op, Term term1, Term term2){
		
		this.varName = varName;
		this.operator = op;
		this.t1 = term1;
		this.t2 = term2;
		
	}
	
	
	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		
		if(words.length != 5){
			return null;
		}
		
		else{
			
		if(words[0].length() != 1){ //el nombre de la variable solo puede tener longitud 1
			return null;
		}
		
		if(!words[1].equals("=")){ //si no es de tipo asignacion 
			return null;
		}
		
		///////////////////////////////////////
		String varName = words[0]; //nombre de la variable en la pos 0
		Term term1 = TermParser.parse(words[2]);
		
		String op = words[3];
		
		Term term2 = TermParser.parse(words[4]);
		
		if(term1 == null || term2 == null){
			if (op != "+" || op != "-" || op != "*" || op != "/")
				return null;
		}
			
		lexParser.increaseProgramCounter();
		/////////////////////////////////////////////////

		return new CompoundAssignment(varName, op, term1, term2);
	}
		
}

	@Override
	public void compile(Compiler compiler) throws ArrayException {
		
		//cargamos byteCodes en compiler que han sido generados en t1 y t2
		compiler.addByteCode(t1.compile(compiler));
		compiler.addByteCode(t2.compile(compiler));
		
		
		//ByteCode bytecodeAux = null;
			
		//segun el operador se aniade una arimeticologica u otra	
		if (operator == "+")
			//bytecodeAux = new Add();
		compiler.addByteCode(new Add());
		
		else if (operator == "-")
			//bytecodeAux = new Sub();
		compiler.addByteCode(new Sub());
		
		else if (operator == "/")
			//bytecodeAux = new Div();
		compiler.addByteCode(new Div());
		
		else if (operator == "*")
			//bytecodeAux = new Mul();
		compiler.addByteCode(new Mul());
		
		//compiler.addByteCode(bytecodeAux);
		
		int index = compiler.getIndex(varName);
		compiler.addByteCode(new Store(index));
		
	}

	public String getVarName() {
		return varName;
	}

	public void setVarName(String varName) {
		this.varName = varName;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Term getT1() {
		return t1;
	}

	public void setT1(Term t1) {
		this.t1 = t1;
	}

	public Term getT2() {
		return t2;
	}

	public void setT2(Term t2) {
		this.t2 = t2;
	}

	
	
}
