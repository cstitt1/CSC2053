package vocDens;

import java.io.*;
import java.util.*;
import ch05.collections.*;

public class VocabularyDensityMeasureAC {

	public static void main(String[] args) throws IOException {
		final long start = System.currentTimeMillis();
		
		final int CAPACITY = 210000;   // capacity of collection
	    String fname = args[0];      // input file of text
	    String word;                 // current word
	    int numWords = 0;            // total number of words
	    double density;              // vocabulary density

	    CollectionInterface<String> words = new ArrayCollection<String>(CAPACITY);

	    // Set up file reading
	    FileReader fin = new FileReader(fname);
	    Scanner wordsIn = new Scanner(fin);
	    wordsIn.useDelimiter("[^a-zA-Z']+");  // delimiters are nonletters,'

	    while (wordsIn.hasNext())      // while more words to process
	    {
	      word = wordsIn.next();          
	      word = word.toLowerCase();
	      if (!words.contains(word))
	        words.add(word);
	      numWords++;
	    }
	  
	    density = (double)numWords/words.size();
	    System.out.println("Analyzed file " + fname);
	    System.out.println("\n\tTotal words:  " + numWords);
	    if (words.size() == CAPACITY)
	      System.out.println("\tUnique words: at least " + words.size());
	    else
	    {
	      System.out.println("\tUnique words: " + words.size());
	      System.out.printf("\n\tVocabulary density: %.2f", density);
	    }
	    
	    final long end = System.currentTimeMillis();
	    System.out.println("\nmilliseconds: " + (end-start));
	}
}