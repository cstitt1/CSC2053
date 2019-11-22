package vocDens;

import java.io.*;

public class MeasureDriver {

	public static void main(String[] args) throws IOException {
		String[] input = {"C:\\Users\\cstit\\Desktop\\VocDen0.txt"};
		
		System.out.println("ArrayCollection: ");
		VocabularyDensityMeasureAC.main(input);
		System.out.println("\nSortedArrayCollection: ");
		VocabularyDensityMeasure.main(input);
		System.out.println("\nArrayList: ");
		VocabularyDensityMeasureAL.main(input);
	}
}