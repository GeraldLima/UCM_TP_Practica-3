package comandos;

import control.Engine;

public class Reset extends Command{

	@Override
	public boolean execute(Engine engine) {
			
		return engine.reset();
	}

	@Override
	public Command parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase("RESET"))
			return new Reset();
		else 
			return null;
	}

	@Override
	public String textHelp() {
		return "RESET: Vacia el programa actual " +
				System.getProperty("line.separator");
	}

	public String toString(){
		return "RESET";
	}
}
