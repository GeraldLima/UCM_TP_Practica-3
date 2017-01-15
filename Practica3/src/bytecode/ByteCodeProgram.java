package bytecode;


/**
 * Clase que representa el programa actual
 */
public class ByteCodeProgram {

	private static final int TAM = 1;
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
	public void aniadirInstruccion(ByteCode inst){
		
		if (program[TAM-1] != null) {
			ByteCode [] programAux = new ByteCode[pos*2];		
			copiarDatos(programAux);
		}				
		program[pos] = inst;
		pos = pos + 1;
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
	private void copiarDatos(ByteCode[] prog){
		for (int i = 0; i < program.length; i++) {
			prog[i] = program[i];
		}
		program = prog;
	}
	
	
	/**
	 * Metodo que se encarga de meter una instruccion en una posicion
	 * @param instr
	 * @param pos
	 */
	public void colocarInstrEnPos(ByteCode instr, int pos){
		this.program[pos] = instr;
	}
	
	
	/**
	 * Metodo que devuelve la instruccion enesima del programa
	 * @param enesima, instruccion
	 * @return devuelve la instruccion enesima
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
