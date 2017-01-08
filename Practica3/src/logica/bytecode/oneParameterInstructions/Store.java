package logica.bytecode.oneParameterInstructions;

import logica.CPU;
import logica.bytecode.ByteCode;

public class Store extends ByteCodeOneParameter{

	public Store(){
		
	}
	
	public Store(int param){
		super(param);
	}


	@Override
	public boolean execute(CPU cpu) {
	
		boolean ok = false;
		
		if(!cpu.pilaVacia()){
			
			int valor = cpu.pop();
			cpu.write(param, valor);
			ok = true;
		}
		
	return ok;
		
		

	}

	@Override
	protected ByteCode parseAux(String string1, String string2) {
		
		if(string1.equalsIgnoreCase("STORE")){
			int param = Integer.parseInt(string2);
			return new Store(param);
		}
		
		return null;
	}	

	@Override
	protected String toStringAux() {
		
		return "STORE";
	}
	
}
