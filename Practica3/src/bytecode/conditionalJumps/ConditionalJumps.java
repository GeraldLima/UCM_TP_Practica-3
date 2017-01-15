package bytecode.conditionalJumps;

import elements.CPU;
import bytecode.oneParameterInstructions.ByteCodeOneParameter;

public abstract class ConditionalJumps extends ByteCodeOneParameter{

	public ConditionalJumps(){
		
	}
	
	public ConditionalJumps(int param){
		super(param);
	}
	
	@Override
	public boolean execute(CPU cpu) {

		if(cpu.getSizeStack() >= 2 && this.param < cpu.getSizeProgram()){
			
			int n1 = cpu.pop(); //cima
			int n2 = cpu.pop(); //subcima
			
			if(compare(n2, n1/*, cpu*/)){
				
				cpu.increaseProgramCounter();
			}
			else{
				cpu.setProgramCounter(this.param);
			}
			
			
			return true;
		}
		
		return false;
	}
	
	/**
	 * Metodo que modifica el valor del salto
	 * @param n, parametro que recibe
	 */
	public void setN(int n){
		super.setN(n);
	}
	
	abstract protected boolean compare(int n1, int n2/*, CPU cpu*/);
}
