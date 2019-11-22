package vocDens;

import java.io.*;
import java.util.*;

public class VocabularyDensityMeasureSAL {

	public static void main(String[] args) throws IOException {
		final long start = System.currentTimeMillis();
		
		String fname = "C:\\Users\\cstit\\Desktop\\VocDen3.txt";//args[0];
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
			//Code to keep the ArrayList ordered and use Binary Search
			if(list.isEmpty() || list.get(list.size()-1).compareTo(word) < 0) {
				list.add(word);
			} else if (word.compareTo(list.get(0)) < 0) {
				list.add(0, word);
			} else {
				boolean found = false;
				int loc = -2, first = 0, last = list.size()-1, mid;
				
				while (!found && loc == -2) {
					mid = (first + last)/2;
					if (list.get(mid).equals(word)) {
						found = true;
					} else if (first >= last) {
						loc = mid;
						if (list.get(mid).compareTo(word) < 0) {
							loc++;
						}
					} else if (list.get(mid).compareTo(word) < 0) {
						first = mid+1;
					} else {
						last = mid-1;
					}
				}
				
				if (!found) {
					list.add(loc,word);
				}
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