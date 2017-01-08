package logica.bytecode.oneParameterInstructions;

import logica.CPU;
import logica.bytecode.ByteCode;

public class Push extends ByteCodeOneParameter{

	public Push(){
		
	}
	
	public Push(int param){
		super(param);
	}


	@Override
	public boolean execute(CPU cpu) {
		
		return cpu.push(param);
	}	

	@Override
	protected ByteCode parseAux(String string1, String string2) {
		
		if(string1.equalsIgnoreCase("PUSH")){
			int param = Integer.parseInt(string2);
			return new Push(param);
		}
		
		return null;
	}	

	@Override
	protected String toStringAux() {
		
		return "PUSH";
	}

}
