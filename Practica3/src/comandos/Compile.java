package comandos;

import control.Engine;
import exceptions.ArrayException;
import exceptions.LexicalAnalysisException;
//TODO falta
public class Compile implements Command {

	@Override
	public boolean execute(Engine engine) throws LexicalAnalysisException, ArrayException {
		engine.compile();
		return false;
	}

	@Override
	public Command parse(String[] s) {
		
		return CommandParser.parse(s[0]);
	}

	@Override
	public String textHelp() {
		// TODO Auto-generated method stub
		return null;
	}

}
