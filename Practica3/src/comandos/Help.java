package comandos;

import control.Engine;

public class Help implements Command{

	@Override
	public void execute(Engine engine) {
		
	 engine.mostrarAyuda();
	}

	@Override
	public Command parse(String[] s) {
		if(s.length != 1 || !s[0].equalsIgnoreCase("HELP")) 
			return null;
		else 
			return new Help();
	}

	@Override
	public String textHelp() {
		
		return "HELP: muestra la ayuda correspondiente a los comandos" + System.getProperty("line.separator");
	}
	
	public String toString(){
		return "HELP";
	}

}
