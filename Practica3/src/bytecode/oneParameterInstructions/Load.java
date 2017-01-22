package bytecode.oneParameterInstructions;

import elements.CPU;
import exceptions.StackException;
import bytecode.ByteCode;

public class Load extends ByteCodeOneParameter{

	
	public Load(){
		
	}
	
	public Load(int param){
		super(param);
	}


	@Override
	public void execute(CPU cpu)throws StackException{
		
		
		try{
			
			int valor = cpu.read(param);
			cpu.push(valor);
			cpu.increaseProgramCounter();
		}
		
		catch(Exception e){
			throw new StackException(System.getProperty("line.separator") + "EXCEPCION-bytecode " + toString() + ": Tamaño de la pila insuficiente");
		}
	}

	@Override
	protected ByteCode parseAux(String string1, String string2) {
		
		if(string1.equalsIgnoreCase("LOAD")){
			try{
			int param = Integer.parseInt(string2);
			return new Load(param);
			}
			catch(NumberFormatException e){
				System.out.println("EXCEPCION: Formato numerico incorrecto");
			}
		}
		
		return null;
	}
	
	@Override
	protected String toStringAux() {
		
		return "LOAD";
	}

}
