package control;
import java.io.File;


import java.io.FileNotFoundException;
import java.util.Scanner;

import bytecode.ByteCode;
import bytecode.ByteCodeParser;
import bytecode.ByteCodeProgram;
import comandos.Command;
import comandos.CommandParser;
import comandos.ParsedProgram;
import comandos.SourceProgram;
import elements.CPU;
import elements.LexicalParser;
import exceptions.ArrayException;
import exceptions.BadFormatByteCodeException;
import exceptions.ExecutionErrorException;
import exceptions.LexicalAnalysisException;
import exceptions.StackException;
import elements.Compiler;
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
	//TODO ANIADIDO
	private Compiler compiler;
	private LexicalParser lexicalParser;
	private SourceProgram sProgram;
	private ParsedProgram pProgram;
	private ByteCodeProgram bcProgram;
	//private boolean end;
	/**
	 * Constructora de la clase
	 */
	public Engine(){
		
		end = false;
		program = new ByteCodeProgram();
		in = new Scanner(System.in);
		sProgram = new SourceProgram();
		pProgram = new ParsedProgram();
		bcProgram = new ByteCodeProgram();
		lexicalParser = new LexicalParser();
		compiler = new Compiler();
		lexicalParser = new LexicalParser();
		cpu = new CPU(bcProgram);
	}
	
	
	/**
	 * Metodo que se encarga del control de la aplicacion
	 * @throws BadFormatByteCodeException 
	 * @throws ArrayException 
	 * @throws LexicalAnalysisException 
	 * @throws ExecutionErrorException 
	 * @throws StackException 
	 * @throws FileNotFoundException 
	 */
	public void start(){	
			
		String line = "";
		
		do {		
			
			System.out.print("> ");	
			line = in.nextLine();
			line = line.trim();
			
			try{
				
				Command comando = CommandParser.parse(line);
		
				if (comando == null) {
					
					System.out.println("Error: Comando incorrecto");
				} 
				
				else {
					
					System.out.println("Comienza la ejecución de " + comando);
					comando.execute(this);
						
				}
				
				if(end){
					
					System.out.println("Fin de la ejecucion....");	
					in.close();
				}
					
			}
					
			catch(FileNotFoundException e){
				System.out.println("EXCEPCION: Fichero no encontrado...");
			}
			
			catch(ExecutionErrorException e){
				System.out.println("EXCEPCION: Error en la ejecucion del bytecode " + e.toString());
			}
			
			catch(ArrayException e){
				System.out.println("EXCEPCION: Error de acceso en la posicion" + e.toString() + " del array");
			}
			
			catch(LexicalAnalysisException e){
				System.out.println("EXCEPCION: Error de parseo en el programa fuente en la linea" + e.toString());
			}
			
			catch(BadFormatByteCodeException e){
				System.out.println("EXCEPCION: Error de formato del bytecode introducido");
			}
			
			
			
		}while(!end);
		
	
		
		
		
	}
	
	
	/**
	 * Metodo que se encarga de la ejecucion del comando run
	 * @return true si se ha ejecutado correctamente y false en caso contrario
	 * @throws ExecutionErrorException 
	 */
	public void run() throws ExecutionErrorException, ArrayException{	
			
		cpu.run();
				
		System.out.println("El estado de la maquina tras ejecutar el programa es: ");
		System.out.println(cpu);
						
		System.out.println();
		cpu = new CPU(bcProgram);
			
		System.out.println(this.sProgram);	
		System.out.println(this.bcProgram);
	}
	
	
	
	
	/**
	 * Metodo que se encarga de reemplazar una instruccion por otra
	 * @param repl, numero de instruccion que quiero reemplazar
	 * @throws ArrayException 
	 * @throws BadFormatByteCodeException 
	 */
	public void replace(int repl) throws ArrayException, BadFormatByteCodeException{

		String str = "";	

		ByteCode codByte;

		
		if(repl < bcProgram.getPosicion()){
			
			System.out.print("\nNuevo Bytecode: ");	
			str = this.in.nextLine();
			str = str.trim();	
			
			codByte = ByteCodeParser.parse(str);
			
			if (codByte != null)		
				bcProgram.colocarInstrEnPos(codByte, repl);
			else
				throw new BadFormatByteCodeException("");	
	}
		else
			throw new ArrayException(" " + repl);
			
			
		System.out.println();
		System.out.println(this.sProgram);
		System.out.println(this.bcProgram);
	 
}	
	/**
	 * Metodo queue sirve para salir del programa
	 */
	public boolean quit(){
		return end = true;
	}	
	
	
	/**
	 * Metodo que se encarga de mostrar la ayuda
	 * @return true si se ha mostrado la ayuda
	 */
	public void mostrarAyuda(){
		
		System.out.println();
		CommandParser.showHelp();

	}
	
	
	/**
	 * Metodo que se encarga de leer las instrucciones introducidas
	 * @return true, si se han leido correctamente y false en caso contrario
	 * @throws ArrayException 
	 */	
	public boolean readByteCodeProgram() throws ArrayException{
		
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
	
	
	
	public void compile() throws LexicalAnalysisException, ArrayException {
		
		pProgram.inicializa();
		bcProgram.inicializa();
		System.out.println(this.sProgram);
		
		try {
			
			this.lexicalAnalysis();
			this.generateByteCode();
			System.out.println(this.bcProgram);
		}
		
		catch (LexicalAnalysisException e){
			throw e;
		}
		
		catch(ArrayException e){
			throw e;
		}
	}
	
	
	private void lexicalAnalysis() throws LexicalAnalysisException, ArrayException {
			
		
		lexicalParser.inicializar(sProgram);
		lexicalParser.lexicalParser(pProgram, "end");
	}
	
	
	private void generateByteCode() throws ArrayException {
					
		compiler.Inicialize(bcProgram);
		compiler.compile(pProgram);
	}

	
	
	public void loadFich(String nombre) throws FileNotFoundException, ArrayException{
		
		Scanner sc = new Scanner(new File(nombre));
		String line = ""; //lee cada linea
		
		 sProgram.inicializa();
		 pProgram.inicializa();
		 bcProgram.inicializa();
		
			try{
				while(sc.hasNextLine()){
				line = sc.nextLine();
				sProgram.aniadirInstruccion(line);
			}
		}
			catch(ArrayException e){
				throw e;
			}
		
			sc.close();
			
		System.out.println(this.sProgram);
		//mostrarProgramaFuente();
		
	}
	
	
	
}

