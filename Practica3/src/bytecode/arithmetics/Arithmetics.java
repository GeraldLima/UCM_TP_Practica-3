package bytecode.arithmetics;

import elements.CPU;
import exceptions.DivisionByZeroException;
import exceptions.StackException;
import bytecode.ByteCode;

public abstract class Arithmetics implements ByteCode{

	@Override
	public void execute(CPU cpu) throws DivisionByZeroException,StackException {
		
		int elem1, elem2, resul;		
		
		try{
			
			elem1 = cpu.pop();
			elem2 = cpu.pop();
			resul = executeAux(elem1, elem2);
			cpu.push(resul);
			cpu.increaseProgramCounter();
		
		}
		
		catch(DivisionByZeroException e){
			throw e;
		}
		
		catch(Exception e){
			throw new StackException(System.getProperty("line.separator") + "EXCEPCION-bytecode " + toString() + ": Tamaño de la pila insuficiente");
		}
	}

	@Override
	public ByteCode parse(String[] s) {
		
		if(s.length == 1){
			return this.parseAux(s[0]);
		}
		
		else return null;
	}

	
	abstract protected int executeAux(int valor1, int valor2) throws DivisionByZeroException, StackException;

	abstract protected ByteCode parseAux(String s);
		
	
	
	
}
