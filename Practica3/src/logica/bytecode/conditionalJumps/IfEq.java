package logica.bytecode.conditionalJumps;

import logica.bytecode.ByteCode;

public class IfEq extends ConditionalJumps{
	
	public IfEq(){
		
	}
	
	public IfEq(int j){
		super(j);
	}

	
	@Override
	protected boolean compare(int n1, int n2) {
		
		return (n1 == n2);
	}
	
	@Override
	protected ByteCode parseAux(String string1, String string2) {
		
		if(string1.equalsIgnoreCase("IFEQ")){
			int param = Integer.parseInt(string2);
			return new IfEq(param);
		}
		
		return null;
	}

	@Override
	protected String toStringAux() {
		
		return "IFEQ";
	}

	

}
