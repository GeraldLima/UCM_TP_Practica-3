package comandos;

import control.Engine;

public class Quit implements Command{

	@Override
	public boolean execute(Engine engine) {
		
		return engine.quit();
	}

	@Override
	public Command parse(String[] s) {
		if(s.length != 1 || !s[0].equalsIgnoreCase("QUIT")) 
			return null;
		else 
			return new Quit();
	}

	@Override
	public String textHelp() {
		
		return "QUIT: Cierra la aplicacion" + System.getProperty("line.separator");
	}	
	
	public String toString(){
		return "QUIT";
	}

}
