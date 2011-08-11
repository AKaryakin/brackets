package sp.bracket;

public class SequencePrinter {
	public static void print(char[] sequence){
		for(int i = 0; i < sequence.length; ++i){
			if(Checker.LEFT_BRACKET == sequence[i]) 
				sequence[i] = '(';
			else
				sequence[i] = ')';
		}
		System.out.println(sequence);
	}
}
