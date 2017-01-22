package comandos;

import exceptions.ArrayException;

public class SourceProgram {
	

	private static final int TAM = 50;
	private String[] sProgram;
	private int pos;
	
		
	/**
	 * Constructora de la clase
	 */
	public  SourceProgram(){
		this.inicializa();
	}
	
	
	
	/**
	 * Metodo que se encarga de aniadir una instruccion
	 * @param inst, instruccion a aniadir
	 * @throws ArrayException 
	 */
	public void aniadirInstruccion(String inst) throws ArrayException{
		
		/*if (sProgram[TAM-1] != null) {
			String [] programAux = new String[pos*2];		
			copiarDatos(programAux);
		}	*/
		
		
		try{
			
		sProgram[pos] = inst;
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
		sProgram = new String[TAM]; //array para guardar las lineas del fichero, cada lines del fichero la guarda en una posicion del array
		pos = 0;
	}
	
	
	/**
	 * Metodo que se encarga de copiar los datos
	 * @param prog
	 */
	/*private void copiarDatos(String[] prog){
		for (int i = 0; i < sProgram.length; i++) {
			prog[i] = sProgram[i];
		}
		sProgram = prog;
	}*/
	
	
	/**
	 * Metodo que devuelve la instruccion enesima del programa
	 * @param enesima, instruccion
	 * @return devuelve la instruccion enesima
	 * @throws ArrayException 
	 */
	public String devolverString(int pos){
		
	
			return sProgram[pos];
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
	
			s = s + "Programa fuente almacenado: " + System.getProperty("line.separator");
	  
		for (int i = 0; i < getPosicion(); i++){
			
		    String instruccion = devolverString(i); //devuelvo la instruccion en dicha posicion
		  
		     s = s + i + ": " + instruccion + System.getProperty("line.separator");			
		}
					
		return s;
		
		
		
	}



	
	
}
