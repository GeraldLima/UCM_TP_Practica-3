package instruction.term;

public class TermParser {
	
	private final static Term[] terms = {
			new Variable(""), new Number(0)
	};

	public static Term parse(String cadTermino) {
		Term trm;
		for (Term term : terms) {
			trm = term.parse(cadTermino);
			if (trm != null)
				return trm;
		}
		return null;
	}

}
