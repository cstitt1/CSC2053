//----------------------------------------------------------------
//ArrayCollectionDriver.java			by Christopher Stitt
//
//Used to implement and test the methods added to ArrayCollection.java for
//Problem 8abc of Chapter 5
//----------------------------------------------------------------

package ch05p08;

public class ArrayCollectionDriver {

	public static void main(String[] args) {
		ArrayCollection<String> tester = new ArrayCollection<String>();
		tester.add("cat");
		tester.add("dog");
		tester.add("cat");
		tester.add("fish");
		tester.add("fish");
		tester.add("cat");
		
		//5.8a -- toString() method
		System.out.println("Expected: [cat, dog, cat, fish, fish, cat]");
		System.out.println("Result:   "+tester.toString()+"\n");
		
		//5.8b --  count(T target)
		System.out.println("Fish -- Expected: 2       Found: "+tester.count("fish"));
		System.out.println("Cat --- Expected: 3       Found: "+tester.count("cat"));
		System.out.println("Dog --- Expected: 1       Found: "+tester.count("dog")+"\n");
		
		//5.8c -- removeAll(T target)
		tester.removeAll("cat");
		System.out.println("Expected: [fish, dog, fish]");
		System.out.println("Result:   "+tester);
	}
}