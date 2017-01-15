package comandos;

import control.Engine;
import exceptions.ArrayException;
import exceptions.LexicalAnalysisException;



//TODO COMPLETADA
public class Compile implements Command {

	public Compile(){
		
	}
	
	@Override
	public void execute(Engine engine) throws LexicalAnalysisException, ArrayException { //de tipo void
		engine.compile();
		
	}

	@Override
	public Command parse(String[] s) {
		if(s.length != 1  || !s[0].equalsIgnoreCase("COMPILE")) 
			return null;
						
		else 
			return new Compile();
	}

	@Override
	public String textHelp() {
		
		return "COMPILE: realiza el analisis lexico del programa fuente" + System.getProperty("line.separator");
	}

	//TODO
	public String toString(){
		 return "COMPILE";
	}
}
