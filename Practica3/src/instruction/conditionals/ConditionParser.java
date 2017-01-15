package instruction.conditionals;

import elements.LexicalParser;

/**
 * Clase que se encarga de parsear las condiciones
 */
public class ConditionParser {

	/**
	 * Constructora
	 */
	public ConditionParser(){
		
	}
	
	/**
	 * Array de condiciones
	 */
	private final static Condition[] conditions = {
			new Less(), new LessEq(), new Equal(),
			new NotEqual()
	};
	
	
	/**
	 * Metodo que se encarga de parsear las condiciones
	 * @param t1, primer termino
	 * @param op, operando
	 * @param t2, segundo termino
	 * @param lexParser, analizador lexico
	 * @return condition, la devuelve parseada
	 */
	public static Condition parse(String t1, String op, String t2, LexicalParser lexParser) {
		
		int i=0;
		boolean encontrado = false;	
		
		Condition condition  = null;
		
		while (i < conditions.length && !encontrado){	
			condition = conditions[i].parse(t1, op, t2, lexParser);	
			
			if (condition !=null){
				encontrado = true;
			}
			else {
				i++;
			}
		}
		return condition;
		
	}
	
	

}
