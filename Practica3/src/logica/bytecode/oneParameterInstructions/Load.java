package logica.bytecode.oneParameterInstructions;

import logica.CPU;
import logica.bytecode.ByteCode;

public class Load extends ByteCodeOneParameter{

	
	public Load(){
		
	}
	
	public Load(int param){
		super(param);
	}


	@Override
	public boolean execute(CPU cpu) {
	
		boolean ok = false;
		
			int valor = cpu.read(param);
			cpu.push(valor);
			ok = true;		
		
		return ok;
	}

	@Override
	protected ByteCode parseAux(String string1, String string2) {
		
		if(string1.equalsIgnoreCase("LOAD")){
			int param = Integer.parseInt(string2);
			return new Load(param);
		}
		
		return null;
	}
	
	@Override
	protected String toStringAux() {
		
		return "LOAD";
	}

}
