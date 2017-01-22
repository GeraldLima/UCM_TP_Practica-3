package bytecode.oneParameterInstructions;

import elements.CPU;
import bytecode.ByteCode;

public class Goto extends ByteCodeOneParameter{

	public Goto(){
		
	}
	
	public Goto(int param){
		super(param);
	}
	

	@Override
	public void execute(CPU cpu) {
		
		if(this.param < cpu.getSizeProgram()){ //si esta dentro del programa
			cpu.setProgramCounter(param);	
		}
		
	}	

	@Override
	protected ByteCode parseAux(String string1, String string2) {
		
		if(string1.equalsIgnoreCase("GOTO")){
			try{
			int param = Integer.parseInt(string2);
			return new Goto(param);
			}
			catch(NumberFormatException e){
				System.out.println("EXCEPCION: Formato numerico incorrecto");
			}
		}
		
		return null;
	}	

	@Override
	protected String toStringAux() {
		
		return "GOTO";
	}

	

}
