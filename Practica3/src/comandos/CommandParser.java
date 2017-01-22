package comandos;

/**
 * Clase que se encarga de parsear los comandos
 */
public class CommandParser {
	
	private final static Command[] commands ={
		new Help(), 
		new Quit(), 
		new ReplaceBC(), 
		new Run(), 
		new Load(""),
		new AddByteCodeProgram(),
		new Compile()
	};
	
	
	public static Command parse(String line) {
		// eliminar blancos innecesarios igual que en la Práctica_1 1ine = line.trim();
		// descomponer line en palabras
		
		line = line.trim();
		String[] words = line.split(" +");	
	
		
		boolean encontrado = false;		
		Command comando  = null;
		
		
		int i=0;
		while (i < commands.length && !encontrado){	
			comando = commands[i].parse(words);		
			if (comando !=null){
				encontrado = true;
			}
			else {
				i++;
			}
		}
		return comando;
	}
	
	
	public static void showHelp() {
		
		for (int i=0; i < CommandParser.commands.length; i++)
			System.out.println(CommandParser.commands[i].textHelp());
	}


	public static Command[] getCommands() {
		return commands;
	}

	
	
}
