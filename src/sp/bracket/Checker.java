package sp.bracket;

public interface Checker {
	char LEFT_BRACKET = '0';
	char RIGHT_BRACKET = '1';
	
	boolean check(char[] sequence);
}
