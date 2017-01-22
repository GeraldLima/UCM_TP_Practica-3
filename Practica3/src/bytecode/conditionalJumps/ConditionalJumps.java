package bytecode.conditionalJumps;

import elements.CPU;
import exceptions.StackException;
import bytecode.oneParameterInstructions.ByteCodeOneParameter;

public abstract class ConditionalJumps extends ByteCodeOneParameter{

	public ConditionalJumps(){
		
	}
	
	public ConditionalJumps(int param){
		super(param);
	}
	
	@Override
	public void execute(CPU cpu) throws StackException{

		if(this.param <= cpu.getSizeProgram()){
			
			try{
				
			int n1 = cpu.pop(); //cima
			int n2 = cpu.pop(); //subcima
			
			if(compare(n2, n1))
				
				cpu.increaseProgramCounter();
			
			else
				cpu.setProgramCounter(this.param);
			
			}
				catch(Exception e){
					throw new StackException(System.getProperty("line.separator") + "EXCEPCION-bytecode " + toString() + " Tamaño de la pila insuficiente");
				}
			
			
		}
	
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
