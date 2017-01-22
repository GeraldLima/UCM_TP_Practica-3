package elements;

import exceptions.ExecutionErrorException;
import exceptions.StackException;
import bytecode.ByteCode;
import bytecode.ByteCodeProgram;

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
	 * @throws  
	 */
	public void run() throws ExecutionErrorException{
		
		this.programCounter = 0;
		
		while (this.programCounter < bcProgram.getPosicion()  && (!terminado)) {
			
			try{
				
				ByteCode bc = bcProgram.getByteCode(this.programCounter);
				bc.execute(this);
			}
			
			catch(ExecutionErrorException e){
				throw new ExecutionErrorException(this.programCounter + e.toString());
			}
		}
		
	}
	
	public void push(int elem) throws StackException{
	
		this.stack.push(elem);
	}
	
	
	public int pop() throws StackException{ 
		return this.stack.pop(); 
	}
	
	
	public boolean halt() { 
		return this.terminado = true;
	}
	
	public void out() throws StackException{
			
		int valor = stack.pop();
		System.out.println(System.getProperty("line.separator") + "Consola: " + valor);
				
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
