package instruction.assignments;

import bytecode.ByteCode;
import elements.Compiler;

public interface Term {
	
	Term parse(String term);
	ByteCode compile(Compiler compiler);

}
