package logica.bytecode;

import logica.CPU;

public class Out extends ByteCode {

	@Override
	public boolean execute(CPU cpu) {
		
		return cpu.out();
	}

	@Override
	public ByteCode parse(String[] s) {
		if(s.length != 1 || !s[0].equalsIgnoreCase("OUT")) 
			return null;
		else 
			return new Out();
	}

	
	public String toString(){
		return "OUT";
	}
}
