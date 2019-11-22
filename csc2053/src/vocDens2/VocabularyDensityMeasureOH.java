//---------------------------------------------------------------------------
// VocabularyDensityMeasureOH.java       by Christopher Stitt
//
// Measures the overhead time from the VocabularyDensityMeasure programs.
//---------------------------------------------------------------------------
package vocDens2;

import java.io.*;
import java.util.*;

public class VocabularyDensityMeasureOH {

	public static void main(String[] args) throws IOException {
		final long start = System.currentTimeMillis();
		
		String fname = args[0];
		int numWords = 0;
		double dens;
		HashMap<String,Integer> map = new HashMap<>();
		
		FileReader file = new FileReader(fname);
		Scanner scan = new Scanner(file);
		scan.useDelimiter("[^a-zA-Z']+");
		
		while (scan.hasNext()) {
			scan.next().toLowerCase();
		}
		
		dens = ((double) numWords) / map.size();
		System.out.println("Analyzed file " + fname);
		System.out.println("\n\tTotal words:  " + numWords);
		System.out.println("\tUnique words: " + map.size());
	    System.out.printf("\n\tVocabulary density: %.2f", dens);
	    
	    final long end = System.currentTimeMillis();
	    System.out.println("\nmilliseconds: " + (end-start));
	}
}