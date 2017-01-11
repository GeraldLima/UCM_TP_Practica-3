package comandos;

import java.io.FileNotFoundException;

import control.Engine;
import exceptions.ArrayException;
import exceptions.BadFormatByteCodeException;
import exceptions.DivisionByZeroException;
import exceptions.ExecutionErrorException;
import exceptions.LexicalAnalysisException;
import exceptions.StackException;


public interface Command {
	
	abstract public boolean execute(Engine engine) throws /*java.io.*/FileNotFoundException, LexicalAnalysisException, 
									ArrayException, BadFormatByteCodeException, StackException, ExecutionErrorException;
	abstract public Command parse(String[ ] s);
	abstract public String textHelp();
	
}
