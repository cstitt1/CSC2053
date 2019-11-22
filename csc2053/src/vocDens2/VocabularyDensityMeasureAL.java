//---------------------------------------------------------------------------
// VocabularyDensityMeasureAL.java       by Christopher Stitt
//
// Displays the number of total words, unique words in the input text file,
// and the resulting vocabulary density using an ArrayList to hold each unique value.
// Input file indicated by a command line argument.
//---------------------------------------------------------------------------
package vocDens2;

import java.io.*;
import java.util.*;

public class VocabularyDensityMeasureAL {
	public static void main(String[] args) throws IOException {
		final long start = System.currentTimeMillis();
		
		String fname = args[0];
		String word;
		int numWords = 0;
		double dens;
		ArrayList<String> list = new ArrayList<>();
		
		FileReader file = new FileReader(fname);
		Scanner scan = new Scanner(file);
		scan.useDelimiter("[^a-zA-Z']+");
		
		while (scan.hasNext()) {
			word = scan.next();
			word = word.toLowerCase();
			numWords++;
			if (!list.contains(word)) {
				list.add(word);
			}
		}
		
		dens = ((double) numWords) / list.size();
		System.out.println("Analyzed file " + fname);
		System.out.println("\n\tTotal words:  " + numWords);
		System.out.println("\tUnique words: " + list.size());
	    System.out.printf("\n\tVocabulary density: %.2f", dens);
	    
	    final long end = System.currentTimeMillis();
	    System.out.println("\nmilliseconds: " + (end-start));
	}
}