package logica.bytecode.conditionalJumps;

import logica.bytecode.ByteCode;

//SUBCIMA MENOR QUE LA CIMA
public class IfLe extends ConditionalJumps{

	public IfLe(){
		
	}
	
	public IfLe(int j){
		super(j);
	}

	
	@Override
	protected boolean compare(int n1, int n2) {
		
		return (n1 < n2);
	}

	@Override
	protected ByteCode parseAux(String string1, String string2) {
		
		if(string1.equalsIgnoreCase("IFLE")){
			int param = Integer.parseInt(string2);
			return new IfLe(param);
		}
		
		return null;
	}

	@Override
	protected String toStringAux() {
		
		return "IFLE";
	}

	

}
