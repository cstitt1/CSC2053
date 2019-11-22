//----------------------------------------------------------------
//AnagramCounting.java			by Christopher Stitt
//
//Used to implement BigInteger into anagramcounting problem for Kattis
//----------------------------------------------------------------
package anagramcount;

import java.util.Scanner;
import java.io.*;
import java.math.BigInteger;

public class AnagramCounting
{
 
   public static void main (String[] args) throws IOException
   {    
     Scanner scan = new Scanner (System.in);  
//     Scanner scan = new Scanner (new File("sample.txt"));
 
     String word;
     
     int size = (int)'z' - (int)'A' + 1;
     int[] counts;
     int low = (int)'A';
     
     BigInteger result;
     
     while (scan.hasNext())
     {
       // get word and character counts
       counts = new int[size];
       word = scan.nextLine();
       for (int i = 0; i < word.length(); i++)
       {
         counts[(int)word.charAt(i) - low]++;
       }
       
       // calculate length!
       result = new BigInteger(""+word.length());
       for (int i = word.length() - 1; i > 1; i--)
         result = result.multiply(new BigInteger(""+i));

       // divide by repeats
       for (int c = 0; c < size; c++)
         for (int i = counts[c]; i > 1; i--)
           result = result.divide(new BigInteger(""+i));
       System.out.println(result);          
     }
     
     scan.close();
   }
}