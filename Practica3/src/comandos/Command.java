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
	
	abstract public void execute(Engine engine) throws FileNotFoundException, LexicalAnalysisException, 
									ArrayException, BadFormatByteCodeException, StackException, ExecutionErrorException, DivisionByZeroException;
	abstract public Command parse(String[ ] s);
	abstract public String textHelp();
	
}
