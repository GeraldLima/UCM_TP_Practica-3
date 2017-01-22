package bytecode.oneParameterInstructions;

import elements.CPU;
import exceptions.StackException;
import bytecode.ByteCode;

public class Store extends ByteCodeOneParameter{

	public Store(){
		
	}
	
	public Store(int param){
		super(param);
	}


	@Override
	public void execute(CPU cpu) throws StackException{
		
			try{
				
			int valor = cpu.pop();
			cpu.write(param, valor);
			cpu.increaseProgramCounter();
			
			}
			catch(Exception e){
				
				throw new StackException(System.getProperty("line.separator") + "EXCEPCION-bytecode " + toString() + " Tamaño de la pila insuficiente");
			}
			

	}

	@Override
	protected ByteCode parseAux(String string1, String string2) {
		
		if(string1.equalsIgnoreCase("STORE")){
			try{
			int param = Integer.parseInt(string2);
			return new Store(param);
			}
			catch(NumberFormatException e){
				System.out.println("EXCEPCION: Formato numerico incorrecto");
			}
		}
		
		return null;
	}	

	@Override
	protected String toStringAux() {
		
		return "STORE";
	}
	
}
