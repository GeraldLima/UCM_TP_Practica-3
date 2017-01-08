package logica.bytecode.oneParameterInstructions;

import logica.CPU;
import logica.bytecode.ByteCode;

public class Goto extends ByteCodeOneParameter{

	public Goto(){
		
	}
	
	public Goto(int param){
		super(param);
	}
	

	@Override
	public boolean execute(CPU cpu) {
	
		boolean ok = false;
		
		if(this.param < cpu.getSizeProgram()){ //si esta dentro del programa
			cpu.setProgramCounter(param);
			ok = true;		
		}
		
		return ok;
	}	

	@Override
	protected ByteCode parseAux(String string1, String string2) {
		
		if(string1.equalsIgnoreCase("GOTO")){
			int param = Integer.parseInt(string2);
			return new Goto(param);
		}
		
		return null;
	}	

	@Override
	protected String toStringAux() {
		
		return "GOTO";
	}

	

}
