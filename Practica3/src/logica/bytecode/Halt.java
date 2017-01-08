package logica.bytecode;

import logica.CPU;

public class Halt extends ByteCode {

	@Override
	public boolean execute(CPU cpu) {
	
		return cpu.halt();
	}

	@Override
	public ByteCode parse(String[] s) {
		if(s.length != 1 || !s[0].equalsIgnoreCase("HALT")) 
			return null;
		else 
			return new Halt();
	}
	
	
	public String toString(){ 
		return "HALT"; 
	}
	

}
