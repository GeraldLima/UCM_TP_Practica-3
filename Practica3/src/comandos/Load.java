package comandos;

import java.io.FileNotFoundException;

import control.Engine;


//hacer su parse
public class Load implements Command {

	private String nombre;
	
	public Load(String nomFich){
		this.nombre = nomFich;
	}
	
	
	@Override
	public boolean execute(Engine engine) throws FileNotFoundException {
		// TODO Auto-generated method stub
		 return engine.loadFich(nombre);
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
		
		return "LOAD FICH: Carga un fichero" + System.getProperty("line.separator");
	}
	
	public String toString(){
		return "LOAD " + nombre;
	}

}
