package logica.bytecode.conditionalJumps;

import logica.bytecode.ByteCode;

//SUBCIMA MENOR o IGUAL QUE LA CIMA
public class IfLeq extends ConditionalJumps{

	public IfLeq(){
		
	}
	
	public IfLeq(int j){
		super(j);
	}

	
	@Override
	protected boolean compare(int n1, int n2) {
		
		return (n1 <= n2);
	}
	
	@Override
	protected ByteCode parseAux(String string1, String string2) {
		
		if(string1.equalsIgnoreCase("IFLEQ")){
			int param = Integer.parseInt(string2);
			return new IfLeq(param);
		}
		
		return null;
	}

	@Override
	protected String toStringAux() {
		
		return "IFLEQ";
	}

	

}
