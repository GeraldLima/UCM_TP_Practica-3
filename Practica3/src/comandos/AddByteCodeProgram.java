package comandos;

import control.Engine;

//TODO CLASE QUE NO SE REFLEJA.. daba error pork habia que cambiar el extends por implements
public class AddByteCodeProgram implements Command{

	@Override
	public void execute(Engine engine) {
		
		 engine.readByteCodeProgram();
	}

	@Override
	public Command parse(String[] s) {
		if (s.length != 1 || !s[0].equalsIgnoreCase("BYTECODE")) 
			return null;
		else 
			return new AddByteCodeProgram();
	}

	@Override
	public String textHelp() {
		return "BYTECODE: Permite introducir un programa " +
				System.getProperty("line.separator");
	}

	
	public String toString(){
		return "BYTECODE";
	}
}
