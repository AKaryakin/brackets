package sp.bracket;

public class SimpleChecker implements Checker{

	public boolean check(char[] sequence){
		int count = 0;
		for(char c: sequence){
			if (LEFT_BRACKET == c) 
				count += 1; 
			else 
				count -= 1;
			if(count < 0) return false;
		}
		return count == 0;
	}
}
