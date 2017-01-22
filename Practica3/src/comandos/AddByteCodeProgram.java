package comandos;

import control.Engine;
import exceptions.ArrayException;

public class AddByteCodeProgram implements Command{

	@Override
	public void execute(Engine engine) throws ArrayException {
		
		 engine.readByteCodeProgram();
	}

	@Override
	public Command parse(String[] s) {
		if (s.length != 1 || !s[0].equalsIgnoreCase("BYTECODE")) 
			return null;
		else 
			return new AddByteCodeProgram();
	}

	@Override
	public String textHelp() {
		return "BYTECODE: Permite introducir un programa " +
				System.getProperty("line.separator");
	}

	
	public String toString(){
		return "BYTECODE";
	}
}
