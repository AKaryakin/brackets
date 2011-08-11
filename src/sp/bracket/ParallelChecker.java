package sp.bracket;

public class ParallelChecker implements Checker{
	private final int chankSize;
	
	public ParallelChecker(int chankSize){
		this.chankSize = chankSize;
	}

	@Override
	public boolean check(char[] sequence) {
		char[][] chanks = split(sequence, chankSize);
		MapResult[] results = new MapResult[chanks.length];
		for(int i = 0; i < chanks.length; ++i){
			MapResult result = new MapResult();
			results[i] = result;
			for(char c: chanks[i]){
				if(LEFT_BRACKET == c)
					result.addLeft();
				else
					result.addRight();
			}
		}
		
		int leftWithoutMatch = 0;
		for(MapResult result: results){
			leftWithoutMatch -= result.getRightWithoutMatch();
			if(leftWithoutMatch < 0) return false;
			leftWithoutMatch += result.getLeftWithoutMatch();
		}
		return leftWithoutMatch == 0;
	}
	
	private char[][] split(char[] src, int size){
		final int numberFullChanks = src.length / size;
		final int lastChankSize = src.length % size;
		final int numberChanks = (lastChankSize == 0) ? numberFullChanks : numberFullChanks + 1;
		
		char[][] chanks = new char[numberChanks][];
		for(int i = 0; i < chanks.length; ++i){
			if((i + 1) <= numberFullChanks)
				chanks[i] = new char[size];
			else 
				chanks[i] = new char[lastChankSize];
			System.arraycopy(src, i * size, chanks[i], 0, chanks[i].length);
		}
		return chanks;
	}

}

class MapResult{
	private int leftWithoutMatch;
	private int rightWithoutMatch;
	
	public void addRight(){
		if(leftWithoutMatch > 0) 
			leftWithoutMatch -= 1;
		else
			rightWithoutMatch += 1;
	}
	
	public void addLeft(){
		leftWithoutMatch += 1;
		
	}

	public int getLeftWithoutMatch() {
		return leftWithoutMatch;
	}

	public int getRightWithoutMatch() {
		return rightWithoutMatch;
	}
}
