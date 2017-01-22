package comandos;

import control.Engine;
import exceptions.ArrayException;
import exceptions.BadFormatByteCodeException;

public class ReplaceBC implements Command{

	
	private int pos;
	
	public ReplaceBC(){
		
	}
	
	public ReplaceBC(int pos){
		this.pos = pos;
	}
	
		
	@Override
	public void execute(Engine engine) throws ArrayException, BadFormatByteCodeException{
		
		engine.replace(this.pos);
	}

	@Override
	public Command parse(String[] s) {
		
		try{
					
		if(s.length != 2 || !s[0].equalsIgnoreCase("REPLACEBC")) 
			return null;
						
		else 
			return new ReplaceBC(Integer.parseInt(s[1]));
		}
		
		catch(NumberFormatException e){
			System.out.println("EXCEPCION: Formato numerico incorrecto...");
			return null;
		}
	}

	@Override
	public String textHelp() {
		
		return "REPLACEBC N: Reemplaza la instruccion N por la solicitada al usuario" + 
				System.getProperty("line.separator");
	}

	
	public String toString(){
		return "REPLACEBC";
	}
	
	
}
