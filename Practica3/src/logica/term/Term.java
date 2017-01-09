package logica.term;

import logica.bytecode.ByteCode;

public interface Term {
	Term parse(String term);
	ByteCode compile(Compiler compiler);

}
