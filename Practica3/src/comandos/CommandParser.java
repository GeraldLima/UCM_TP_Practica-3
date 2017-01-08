package comandos;

/**
 * Clase que se encarga de parsear los comandos
 */
public class CommandParser {


	
	private final static Command[] commands ={
		new Help(), 
		new Quit(), 
		new Reset(),
		new ReplaceBC(), 
		new Run(), 
		new AddByteCodeProgram()
	};
	
	
	public static Command parse(String line) {
		// eliminar blancos innecesarios igual que en la Práctica_1 1ine = line.trim();
		// descomponer line en palabras
		
		line.trim();
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

	
	
	
	
	
	
	
	
	
	
	
/*
	public static Command parse(String line) {
	
		String palabras[] = line.split(" +");

		Command comando = null;

		if (palabras.length == 1) {//si la longitud del comando es 1


			if (palabras[0].equalsIgnoreCase("help")) {

				comando = new Command(ENUM_COMMAND.HELP);
			}

			else if (palabras[0].equalsIgnoreCase("quit")) {

				comando = new Command(ENUM_COMMAND.QUIT);
			}

			else if (palabras[0].equalsIgnoreCase("run")) {

				comando = new Command(ENUM_COMMAND.RUN);

			}

			else if (palabras[0].equalsIgnoreCase("reset")) {

				comando = new Command(ENUM_COMMAND.RESET);
			}
		}

		else if (palabras.length == 2) {//si la longitud del comando es 2


			if (palabras[0].equalsIgnoreCase("newinst")) {

				ByteCode bc = ByteCodeParser.parse(palabras[1]);
				if (bc != null)
					comando = new Command(ENUM_COMMAND.NEWINST, bc);

			}
			else if(palabras[0].equalsIgnoreCase("replace")){
				
				if (isNum(palabras[1])){
					int numero = Integer.parseInt(palabras[1]);					
					comando = new Command(ENUM_COMMAND.REPLACE, numero);
				}
			}
		}

		else if (palabras.length == 3) {//si la longitud del comando es 3

			if (palabras[0].equalsIgnoreCase("newinst")) {

				ByteCode bc = ByteCodeParser.parse(palabras[1] + " " + palabras[2]);
				if (bc != null)
					comando = new Command(ENUM_COMMAND.NEWINST, bc);
			}
		}
		
		return comando;

	}*/
	
	
	/*private static boolean isNum(String s){
		return (s.matches("[+-]?\\d*(\\.\\d+)?") && s.equals("") == false);
	}*/
	
}
