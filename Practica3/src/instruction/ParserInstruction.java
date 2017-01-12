package instruction;

import elements.LexicalParser;
import instruction.conditionals.IfThen;
import instruction.conditionals.While;
import instruction.term.CompoundAssignment;
import instruction.term.SingleAssignment;

public class ParserInstruction {

	private final static Instruction[] instructions = {
			new SingleAssignment(), new CompoundAssignment(),
			new Write(), new Return(), new While(), new IfThen(),
			//new Equal(), new NotEqual(), new Less(), new LessEq()
	};
	
	
	
	
	//TODO copiar del parser de comando ¿?¿ PORQUE COPIAR!!!
	
	public static Instruction parse(String instr, LexicalParser lexicalParser) {
		// TODO Auto-generated method stub
		return null;
	}

}
