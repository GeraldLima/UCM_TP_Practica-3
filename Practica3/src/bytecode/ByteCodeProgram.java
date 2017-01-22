package bytecode;

import exceptions.ArrayException;


/**
 * Clase que representa el programa actual
 */
public class ByteCodeProgram {

	private static final int TAM = 50;
	private ByteCode[] program;
	private int pos;
		
	/**
	 * Constructora de la clase
	 */
	public  ByteCodeProgram(){
		this.inicializa();
	}
	
	
	
	/**
	 * Metodo que se encarga de aniadir una instruccion
	 * @param inst, instruccion a aniadir
	 */
	public void aniadirInstruccion(ByteCode inst)throws ArrayException{
		
		/*if (program[TAM-1] != null) {
			ByteCode [] programAux = new ByteCode[pos*2];		
			copiarDatos(programAux);
		}*/
		
		try{
			program[pos] = inst;
			pos = pos + 1;
		}
		catch(Exception e){
			throw new ArrayException(" " + this.getPosicion());
		}
	}	
	
	
	/**
	 * Metodo que inicializa el programa
	 */
	public void inicializa(){
		program = new ByteCode[TAM];
		pos = 0;
	}
	
	
	/**
	 * Metodo que se encarga de copiar los datos
	 * @param prog
	 */
	/*private void copiarDatos(ByteCode[] prog){
		for (int i = 0; i < program.length; i++) {
			prog[i] = program[i];
		}
		program = prog;
	}*/
	
	
	/**
	 * Metodo que se encarga de meter una instruccion en una posicion
	 * @param instr
	 * @param pos
	 * @throws ArrayException 
	 */
	public void colocarInstrEnPos(ByteCode instr, int pos) throws ArrayException{
		try{
			
			this.program[pos] = instr;
		}
		catch(Exception e){
			
			throw new ArrayException(" " + this.getPosicion());
		}
	}
	
	
	/**
	 * Metodo que devuelve la instruccion enesima del programa
	 * @param enesima, instruccion
	 * @return devuelve la instruccion enesima
	 * @throws  
	 */
	public ByteCode getByteCode(int enesima){ 
		
		return program[enesima];
		
	}
	
	
	/**
	 * Metodo que devuelve el tamanio actual del programa
	 * @return devuelve la posicion final
	 */
	public int getPosicion() {
		return this.pos;
	}
	
	public void setPosicion(int posicion) {
		this.pos = posicion;
	}
	
	
	/**
	 * Metodo muestra la informacion del programa principal
	 */
	public String toString(){		
		
	String s = "";
		s = s + "Programa ByteCode almacenado:" + System.getProperty("line.separator");
		
		for (int i = 0; i < getPosicion(); i++){
			
		    ByteCode instruccion = getByteCode(i); //devuelvo la instruccion en dicha posicion
		    
		     s = s + i + ": " + instruccion + System.getProperty("line.separator");			
		}
					
		return s;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
