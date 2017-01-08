package control;
import java.util.Scanner;

import comandos.Command;
import comandos.CommandParser;
import logica.CPU;
import logica.bytecode.ByteCode;
import logica.bytecode.ByteCodeParser;
import logica.bytecode.ByteCodeProgram;

/**
 * Clase (Controlador) que se encarga del control de toda la aplicacion
 *
 */
public class Engine {	

	private ByteCodeProgram	program;
	private boolean end;
	private Scanner in;
	private CPU cpu;
	private final static String MARCAFIN = "end";

	/**
	 * Constructora de la clase
	 */
	public Engine(){
		
		end = false;
		program = new ByteCodeProgram();
		in = new Scanner(System.in);
		
	}
	
	
	/**
	 * Metodo que se encarga del control de la aplicacion
	 */
	public void start() {	
			
		this.end = false;
		String line = "";
		
		while (!end) {		
			
			System.out.print("> ");
		
			Command comando = null;
			line = in.nextLine();
			line = line.trim();
			comando = CommandParser.parse(line);
		
		if (comando == null) {
			
			System.out.println("Error: Comando incorrecto");
		} 
		else {
			
			System.out.println("Comienza la ejecución de " + comando);
			
			if (!comando.execute(this))
			
				System.out.println("Error: Ejecucion incorrecta del comando");
		}
		
		if (this.program.getPosicion() != 0)
			System.out.println();
			System.out.println("Programa almacenado: " + System.getProperty("line.separator"));
			System.out.println(this.program);
		}
		
		System.out.println("Fin de la ejecucion....");
		in.close();
		
		
	}
	
	
	/**
	 * Metodo que se encarga de la ejecucion del comando run
	 * @return true si se ha ejecutado correctamente y false en caso contrario
	 */
	public boolean run(){	
	
		boolean ok = true;
		
		ok = cpu.run();
		
			if(ok){
				System.out.println("El estado de la maquina tras ejecutar el programa es: ");
				System.out.println(cpu);
			}
			
			System.out.println();
			cpu = new CPU(program);
			
		return ok;	
	}
	
	
	
	/**
	 * Metodo que se encarga de reinicializar el array de programa por defecto y su contador
	 */
	public boolean reset(){
		
		boolean ok = true;
		program.inicializa();
		return ok;
	}
	
	
	/**
	 * Metodo que se encarga de reemplazar una instruccion por otra
	 * @param repl, numero de instruccion que quiero reemplazar
	 */
	public boolean replace(int repl){

		boolean ok = false;
		String str = "";	

		ByteCode codByte;
		
		
		do{			
			System.out.print("\nNueva instruccion: ");	
			str = this.in.nextLine();
			str = str.trim();
			//palabras = str.split(" ");
			
			codByte = ByteCodeParser.parse(str);
	
			if (codByte != null){			
				program.colocarInstrEnPos(codByte, repl);
				ok = true;
			}
			
		}while(codByte == null);
		
		return ok;
	}
	 
	
	/**
	 * Metodo wue sirve para salir del programa
	 */
	public boolean quit(){
		return end = true;
	}	
	
	
	/**
	 * Metodo que se encarga de mostrar la ayuda
	 * @return true si se ha mostrado la ayuda
	 */
	public boolean mostrarAyuda(){
		
		System.out.println();
		CommandParser.showHelp();
		return true;
	}
	
	
	/**
	 * Metodo que se encarga de leer las instrucciones introducidas
	 * @return true, si se han leido correctamente y false en caso contrario
	 */	
	public boolean readByteCodeProgram(){
		
		boolean correcto = true;
		String line = "";
		ByteCode byteCode;
		//program.inicializa(); //para que no se comporte como reset
		cpu = new CPU(program); //porque cada vez que utilizamos el comando bytecode se reinicia el programa
					
		System.out.println("Introduce el bytecode. Una instruccion por linea: ");
		System.out.println();
		
		do {			
			line = in.nextLine().toLowerCase();
			line = line.trim();
			//line.split(" ");
			
			if(!line.equals(MARCAFIN)){ //si no introducimos end
				
				byteCode = ByteCodeParser.parse(line); //parsea				
				
				while(((byteCode == null) && (!line.equals(MARCAFIN)))){ //si el comando es incorrecto
					System.out.println("Instruccion incorrecta. Vuelva a intentarlo: "); //error 
					
					line = in.nextLine().toLowerCase(); //y vuelve a leer
					line = line.trim();
					
					if(!line.equals(MARCAFIN)) //si no es end 
						byteCode = ByteCodeParser.parse(line); //parsea						
					
				}
					
				if(!line.equals(MARCAFIN)) //si no es end
					this.program.aniadirInstruccion(byteCode); //aniade					
							
			}							
		
		} while (!line.equalsIgnoreCase("end"));		
		
		return correcto;			
	}
			
}

