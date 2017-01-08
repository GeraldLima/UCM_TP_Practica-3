package logica.bytecode.conditionalJumps;

import logica.CPU;
import logica.bytecode.oneParameterInstructions.ByteCodeOneParameter;

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
			
			if(compare(n2, n1)){
				
				cpu.increaseProgramCounter();
			}
			else{
				cpu.setProgramCounter(this.param);
			}
			
			
			return true;
		}
		
		return false;
	}

	
	abstract protected boolean compare(int n1, int n2);
}
