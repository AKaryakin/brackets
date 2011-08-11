import java.math.BigInteger;
import java.text.NumberFormat;

import sp.bracket.Checker;
import sp.bracket.ParallelChecker;
import sp.bracket.SequenceGenerator;
import sp.bracket.SequencePrinter;
import sp.bracket.SimpleChecker;


public class Main {
	
	/**
	 * Test
	 */
	public static void main(String[] args) {
		SequenceGenerator generator = new SequenceGenerator(20);
		Checker simpleChecker = new SimpleChecker();
		Checker parallelChecker = new ParallelChecker(6);
		int size = generator.getSequenceSize();
		for(int i = 0; i < size; ++i){
			char[] sequence = generator.next();
			boolean result = parallelChecker.check(sequence);
			if(result != simpleChecker.check(sequence))
				throw new RuntimeException("mismatch");
			if(result)
				SequencePrinter.print(sequence);
		}
	}
}
