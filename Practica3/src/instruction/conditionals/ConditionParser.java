package instruction.conditionals;

import elements.LexicalParser;

public class ConditionParser {

	private final static Condition[] conditions = {
			new Less(), new LessEq(), new Equal(),
			new NotEqual()
	};
	
	public static Condition parse(String string, String string2,
			String string3, LexicalParser lexParser) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
