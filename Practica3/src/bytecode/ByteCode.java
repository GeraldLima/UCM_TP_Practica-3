package bytecode;

import elements.CPU;
import exceptions.DivisionByZeroException;
import exceptions.StackException;


public interface ByteCode {
	
	public void execute(CPU cpu) throws DivisionByZeroException, StackException;
	public ByteCode parse(String[ ] s);
}
