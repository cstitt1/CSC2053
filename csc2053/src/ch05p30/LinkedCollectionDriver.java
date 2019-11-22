//----------------------------------------------------------------
//LinkedCollectionDriver.java			by Christopher Stitt
//
//Used to implement and test the methods added to LinkedCollection.java for
//Problem 30abc of Chapter 5
//----------------------------------------------------------------
package ch05p30;

public class LinkedCollectionDriver {

	public static void main(String[] args) {
		LinkedCollection<String> tester = new LinkedCollection<String>();
		tester.add("cat");
		tester.add("dog");
		tester.add("cat");
		tester.add("fish");
		tester.add("fish");
		tester.add("cat");
		
		//5.30a -- toString() method
		System.out.println("Expected: <cat, fish, fish, cat, dog, cat>");
		System.out.println("Result:   "+tester.toString()+"\n");
		
		//5.30b --  count(T target)
		System.out.println("Fish -- Expected: 2       Found: "+tester.count("fish"));
		System.out.println("Cat --- Expected: 3       Found: "+tester.count("cat"));
		System.out.println("Dog --- Expected: 1       Found: "+tester.count("dog"));
		System.out.println("Rock -- Expected: 0       Found: "+tester.count("rock")+"\n");
		
		//5.30c -- removeAll(T target)
		tester.removeAll("cat"); //begin and end and general cases
		System.out.println("Remove All for 'cat':");
		System.out.println("Expected: <fish, fish, dog>");
		System.out.println("Result:   "+tester+"\n");
		
		tester.removeAll("fish"); //repeated consecutive case
		System.out.println("Remove All for 'fish':");
		System.out.println("Expected: <dog>");
		System.out.println("Result:   "+tester+"\n");
		
		tester.removeAll("dog"); //singular element case
		System.out.println("Remove All for 'dog':");
		System.out.println("Expected: <>");
		System.out.println("Result:   "+tester);
	}
}