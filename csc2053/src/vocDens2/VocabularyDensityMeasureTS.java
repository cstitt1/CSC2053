//---------------------------------------------------------------------------
// VocabularyDensityMeasureTS.java       by Christopher Stitt
//
// Displays the number of total words, unique words in the input text file,
// and the resulting vocabulary density using a TreeSet to hold each unique value.
// Input file indicated by a command line argument.
//---------------------------------------------------------------------------
package vocDens2;

import java.io.*;
import java.util.*;

public class VocabularyDensityMeasureTS {

	public static void main(String[] args) throws IOException {
		final long start = System.currentTimeMillis();
		
		String fname = args[0];
		int numWords = 0;
		double dens;
		TreeSet<String> tree = new TreeSet<>();
		
		FileReader file = new FileReader(fname);
		Scanner scan = new Scanner(file);
		scan.useDelimiter("[^a-zA-Z']+");
		
		while (scan.hasNext()) {
			numWords++;
			tree.add(scan.next().toLowerCase());
		}
		
		dens = ((double) numWords) / tree.size();
		System.out.println("Analyzed file " + fname);
		System.out.println("\n\tTotal words:  " + numWords);
		System.out.println("\tUnique words: " + tree.size());
	    System.out.printf("\n\tVocabulary density: %.2f", dens);
	    
	    final long end = System.currentTimeMillis();
	    System.out.println("\nmilliseconds: " + (end-start));
	}
}