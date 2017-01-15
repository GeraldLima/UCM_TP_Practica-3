package bytecode.oneParameterInstructions;

import bytecode.ByteCode;

public abstract class ByteCodeOneParameter implements ByteCode{

	protected int param;

	public ByteCodeOneParameter(){
		
	}
	
	public ByteCodeOneParameter(int p){ 
		this.param = p; 
	}
	
	
	@Override
	public ByteCode parse(String[] words) {
		
		if (words.length != 2)
			return null;
		
		else			
			return this.parseAux(words[0], words[1]);
	}
	
	
	public String toString(){
		
		return this.toStringAux() + " " + this.param;
	
	}
	
	public void setN(int n){
		this.param = n;
	}
	
	abstract protected ByteCode parseAux(String string1, String string2);
	abstract protected String toStringAux();
	
	
	
	
}
