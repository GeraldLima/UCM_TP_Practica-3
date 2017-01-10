package bytecode;

import elements.CPU;


public interface ByteCode {
	
	abstract public boolean execute(CPU cpu);
	abstract public ByteCode parse(String[ ] s);
}
