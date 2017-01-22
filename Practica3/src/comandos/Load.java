package comandos;

import java.io.FileNotFoundException;

import control.Engine;
import exceptions.ArrayException;


public class Load implements Command {

	private String nombre;
	
	public Load(String nomFich){
		this.nombre = nomFich;
	}
	
	
	@Override
	public void execute(Engine engine) throws FileNotFoundException, ArrayException {
		
		 engine.loadFich(nombre);
	}

	@Override
	public Command parse(String[] s) {
		if(s.length != 2 || !s[0].equalsIgnoreCase("LOAD")) 
			return null;
		else 
			return new Load(s[1]);
	}

	@Override
	public String textHelp() {
		
		return "LOAD FICH: Carga el fichero de nombre FICH como programa fuente" + System.getProperty("line.separator");
	}
	
	public String toString(){
		return "LOAD " + nombre;
	}

}
