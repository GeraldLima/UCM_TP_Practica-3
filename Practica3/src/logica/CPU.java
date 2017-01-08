package logica;

import logica.bytecode.ByteCode;
import logica.bytecode.ByteCodeProgram;

/**
 * Clase que representa la unidad de procesamiento de la maquina
 */
public class CPU {

	private Memory memory = new Memory();;
	private OperandStack stack = new OperandStack();	
	private boolean terminado = false;
	private ByteCodeProgram bcProgram = new ByteCodeProgram();
	private int programCounter = 0;
	
	/**
	 * Constructora de la clase
	 */
	public CPU(ByteCodeProgram bp){
	
		this.bcProgram = bp;
		
	}
	

	
	/**
	 * Metodo que se encarga de procesar todas instrucciones que tiene el programa
	 * @return true si todo ha ido correctamente
	 */
	public boolean run(){
		
		boolean ok = true;
		
		this.programCounter = 0;
		
		while (this.programCounter < bcProgram.getPosicion() && (ok) && (!terminado)) {
			
			int contAux = this.programCounter;
			ByteCode bc = bcProgram.getByteCode(this.programCounter);
			
			if (!bc.execute(this)){// salir del bucle
				ok = false;
			}
			
			if(contAux == this.programCounter){
				this.increaseProgramCounter();
			}
			
		}
		return ok;
	}
	
	public boolean push(int elem){
	
		return this.stack.push(elem);
	}
	
	
	public int pop() { 
		return this.stack.pop(); 
	}
	
	
	public boolean halt() { 
		return this.terminado = true;
	}
	
	public boolean out() {
		
		boolean ok = true;
			
		System.out.println(System.getProperty("line.separator") + "La cima de la pila es: " + stack.getCima());
				
		return ok;
	}
	
	
	public int read(int pos) {
		
		return this.memory.read(pos);		
	}
	
	public boolean write(int pos, int valor) {		
	
		return this.memory.write(pos, valor);
	}

	public void increaseProgramCounter() {
		this.programCounter++;
		
	}

	public void setProgramCounter(int param) {
		
		 this.programCounter = param;		
	}
	
	public boolean pilaLlena(){
		return this.stack.pilaLlena();
	}
	
	public boolean pilaVacia(){
		return this.stack.pilaVacia();
	}
	
	public boolean isTerminado() {
		return terminado;
	}	
	
	public int getSizeStack(){
		return stack.getDimensionPila();
	}
	
	public int getSizeProgram(){
		return bcProgram.getPosicion();
	}
	
		
	/**
	 * Metodo que muestra la informacion de la CPU
	 */
	public String toString(){
		String s = System.getProperty("line.separator") +
		"Estado de la CPU: " + System.getProperty("line.separator") +
		" Memoria: " + this.memory + System.getProperty("line.separator") +
		" Pila: " + this.stack + System.getProperty("line.separator");
		return s;
	}
	
}
