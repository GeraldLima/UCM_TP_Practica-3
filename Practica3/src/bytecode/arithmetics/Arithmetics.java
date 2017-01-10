package bytecode.arithmetics;

import elements.CPU;
import bytecode.ByteCode;

public abstract class Arithmetics implements ByteCode{

	@Override
	public boolean execute(CPU cpu) {
		
		int elem1, elem2, resul;		
		boolean ok = false;
		
		if(cpu.getSizeStack() >= 2){
			elem1 = cpu.pop();
			elem2 = cpu.pop();
			resul = executeAux(elem1, elem2);
			cpu.push(resul);
			ok = true;			
		}
		
		return ok;
	}

	@Override
	public ByteCode parse(String[] s) {
		
		if(s.length == 1){
			return this.parseAux(s[0]);
		}
		
		else return null;
	}

	//TODO ojo!!!
	public String toString(){
		return toString();
	}
	
	abstract protected int executeAux(int valor1, int valor2);

	abstract protected ByteCode parseAux(String s);
		
	
	
	
}
