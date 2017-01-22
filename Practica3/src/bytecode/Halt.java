package bytecode;

import elements.CPU;

public class Halt implements ByteCode {

	@Override
	public void execute(CPU cpu) {
	
		cpu.halt();
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
