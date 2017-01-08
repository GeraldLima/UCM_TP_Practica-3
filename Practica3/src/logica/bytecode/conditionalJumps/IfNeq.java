package logica.bytecode.conditionalJumps;

import logica.bytecode.ByteCode;

//SUBCIMA DISTINTO CIMA
public class IfNeq extends ConditionalJumps{

	public IfNeq(){
		
	}
	
	public IfNeq(int j){
		super(j);
	}

	
	@Override
	protected boolean compare(int n1, int n2) {
		
		return (n1 != n2);
	}
	
	@Override
	protected ByteCode parseAux(String string1, String string2) {
		
		if(string1.equalsIgnoreCase("IFNEQ")){
			int param = Integer.parseInt(string2);
			return new IfNeq(param);
		}
		
		return null;
	}

	@Override
	protected String toStringAux() {
		
		return "IFNEQ";
	}

	
}
