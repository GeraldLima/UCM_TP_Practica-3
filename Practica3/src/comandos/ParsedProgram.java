package comandos;

import instruction.Instruction;

public class ParsedProgram {
	
	
	private static final int TAM = 1;
	private Instruction[] pProgram;
	private int pos;
	
		
	/**
	 * Constructora de la clase
	 */
	public ParsedProgram(){
		this.inicializa();
	}
	
	
	
	/**
	 * Metodo que se encarga de aniadir una instruccion
	 * @param inst, instruccion a aniadir
	 */
	public void aniadirInstruccion(Instruction inst){
		
		if (pProgram[TAM-1] != null) {
			Instruction [] programAux = new Instruction[pos*2];		
			copiarDatos(programAux);
		}				
		pProgram[pos] = inst;
		pos = pos + 1;
	}	
	
	
	/**
	 * Metodo que inicializa el programa
	 */
	public void inicializa(){
		pProgram = new Instruction[TAM]; //array para guardar las lineas del fichero, cada lines del fichero la guarda en una posicion del array
		pos = 0;
	}
	
	
	/**
	 * Metodo que se encarga de copiar los datos
	 * @param prog
	 */
	private void copiarDatos(Instruction[] prog){
		for (int i = 0; i < pProgram.length; i++) {
			prog[i] = pProgram[i];
		}
		pProgram = prog;
	}
	
	
	/**
	 * Metodo que devuelve la instruccion enesima del programa
	 * @param enesima, instruccion
	 * @return devuelve la instruccion enesima
	 */
	public Instruction devolverString(int pos){  //devolver instriccion
		return pProgram[pos];
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
		
		for (int i = 0; i < getPosicion(); i++){
			
		    Instruction instruccion = devolverString(i); //devuelvo la instruccion en dicha posicion
		    
		     s = s + i + ": " + instruccion + System.getProperty("line.separator");			
		}
					
		return s;
	}

	
}
