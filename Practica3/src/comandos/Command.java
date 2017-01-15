package comandos;

import java.io.FileNotFoundException;

import control.Engine;
import exceptions.ArrayException;
import exceptions.BadFormatByteCodeException;
import exceptions.ExecutionErrorException;
import exceptions.LexicalAnalysisException;
import exceptions.StackException;


public interface Command {
	//TODO ahora el ejecute es de tipo void
	abstract public void execute(Engine engine) throws FileNotFoundException, LexicalAnalysisException, 
									ArrayException, BadFormatByteCodeException, StackException, ExecutionErrorException;
	abstract public Command parse(String[ ] s);
	abstract public String textHelp();
	
}
