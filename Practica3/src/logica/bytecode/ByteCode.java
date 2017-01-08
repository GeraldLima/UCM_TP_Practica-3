package logica.bytecode;

import logica.CPU;


public interface ByteCode {
	
	abstract public boolean execute(CPU cpu);
	abstract public ByteCode parse(String[ ] s);
}
