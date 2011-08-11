package sp.bracket;

public class SequenceGenerator {
	private final int length;
	private long counter = ((long) 1 << 62) - 1;
	
	public SequenceGenerator(int length){
		this.length = length;
	}
	
	public char[] next(){
		counter += 1;
		String str = Long.toString(counter, 2);
		str = str.substring(str.length() - length);
		return str.toCharArray();
	}
	
	public int getSequenceSize(){
		return (int) 1 << length;
	}

}
