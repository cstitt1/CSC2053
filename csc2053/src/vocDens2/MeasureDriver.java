package vocDens2;

import java.io.*;

public class MeasureDriver {

	public static void main(String[] args) throws IOException {
		for (int i = 1; i <= 4; i++) {
			String file = "C:\\Users\\cstit\\Desktop\\VD2-"+i+".txt";
			String[] input = {file};
			
			System.out.println("ArrayCollection: ");
			VocabularyDensityMeasureAC.main(input);
			System.out.println("\nSortedArrayCollection: ");
			VocabularyDensityMeasure.main(input);
			System.out.println("\nArrayList: ");
			VocabularyDensityMeasureAL.main(input);
			
			System.out.println("--------------------------------------------------------");
			
			System.out.println("Library TreeSet: ");
			VocabularyDensityMeasureTS.main(input);
			System.out.println("\nTextbook HMap: ");
			VocabularyDensityMeasureHM.main(input);
			System.out.println("\nLibrary TreeMap: ");
			VocabularyDensityMeasureTM.main(input);
			System.out.println("\nLibrary HashMap: ");
			VocabularyDensityMeasureHaM.main(input);
			
			System.out.println("--------------------------------------------------------");
			
			System.out.println("Overhead Time: ");
			VocabularyDensityMeasureOH.main(input);
			
			System.out.println("--------------------------------------------------------");
			System.out.println("--------------------------------------------------------");
			System.out.println("--------------------------------------------------------");
		}
	}
}