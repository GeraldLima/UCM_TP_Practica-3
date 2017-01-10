package instruction.term;

import bytecode.ByteCode;

public interface Term {
	Term parse(String term);
	ByteCode compile(Compiler compiler);

}
