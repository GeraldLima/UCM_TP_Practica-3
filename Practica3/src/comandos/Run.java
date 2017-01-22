package comandos;

import control.Engine;
import exceptions.ArrayException;
import exceptions.ExecutionErrorException;

public class Run implements Command{

	@Override
	public void execute(Engine engine) throws ExecutionErrorException, ArrayException {
		
		 engine.run();
	}

	@Override
	public Command parse(String[] s) {
		if(s.length != 1 || !s[0].equalsIgnoreCase("RUN")) 
			return null;
		else 
			return new Run();
	}

	@Override
	public String textHelp() {
	
		return "RUN: Ejecuta el programa" + System.getProperty("line.separator");
	}

	public String toString(){
		return "RUN";
	}
}
