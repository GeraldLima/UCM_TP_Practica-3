package bytecode;

import elements.CPU;
import exceptions.StackException;


public class Out implements ByteCode {

	@Override
	public void execute(CPU cpu) throws StackException{
		
		try{
		 cpu.out();
		 cpu.increaseProgramCounter();
		}
		catch(Exception e){
			throw new StackException(System.getProperty("line.separator") + "EXCEPCION-bytecode " + toString() + " :Tamaño de la pila insuficiente");
		}
	}

	@Override
	public ByteCode parse(String[] s){
		
		if(s.length != 1 || !s[0].equalsIgnoreCase("OUT")) 
			return null;
		else 
			return new Out();
	}

	
	public String toString(){
		return "OUT";
	}
}
