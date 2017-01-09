package comandos;

import control.Engine;

public class ReplaceBC implements Command{

	
	private int pos;
	
	public ReplaceBC(){
		
	}
	
	public ReplaceBC(int pos){
		this.pos = pos;
	}
	
		
	@Override
	public boolean execute(Engine engine) {
		
		return engine.replace(this.pos);
	}

	@Override
	public Command parse(String[] s) {
		if(s.length != 2 || !s[0].equalsIgnoreCase("REPLACE")) 
			return null;
						
		else 
			return new ReplaceBC(Integer.parseInt(s[1]));
	}

	@Override
	public String textHelp() {
		
		return "REPLACE N: Reemplaza la instruccion N por la solicitada al usuario" + 
				System.getProperty("line.separator");
	}

	
	public String toString(){
		return "REPLACE";
	}
	
	
}
