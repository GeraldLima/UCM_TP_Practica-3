package comandos;

import control.Engine;


public interface Command {
	
	abstract public boolean execute(Engine engine);
	abstract public Command parse(String[ ] s);
	abstract public String textHelp();
	
}
