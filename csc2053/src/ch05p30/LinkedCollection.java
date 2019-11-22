//---------------------------------------------------------------------------
// LinkedCollection.java          by Dale/Joyce/Weems               Chapter 5
//								  Edited by Christopher Stitt
//
// Implements the CollectionInterface using a linked collection.
// Null elements are not allowed. Duplicate elements are allowed.
// One constructor is provided, one that creates an empty collection.
//
// Edited to add toString(), count(), and removeAll() methods for 5.30abc
//---------------------------------------------------------------------------

package ch05p30;

import support.LLNode;

public class LinkedCollection<T> implements CollectionInterface<T>  
{
  protected LLNode<T> head;       // head of the linked list
  protected int numElements = 0;  // number of elements in this collection

  // set by find method
  protected boolean found;        // true if target found, else false
  protected LLNode<T> location;   // node containing target, if found
  protected LLNode<T> previous;   // node preceding location

  public LinkedCollection()
  {
    numElements = 0;
    head = null;
  }

  public boolean add(T element)
  // Adds element to this collection.
  {
    LLNode<T> newNode = new LLNode<T>(element);
    newNode.setLink(head);
    head = newNode;
    numElements++;
    return true;
  }

  protected void find(T target)
  // Searches the collection for an occurence of an element e such that
  // e.equals(target). If successful, sets instance variables
  // found to true, location to node containing e, and previous
  // to the node that links to location. If not successful, sets 
  // found to false.
  {
    location = head;
    found = false;

    while (location != null) 
    {
      if (location.getInfo().equals(target))  // if they match
      {
       found = true;
       return;
      }
      else
      {
        previous = location;
        location = location.getLink();
      }
    }
  }

  public int size()
  // Returns the number of elements on this collection. 
  {
    return numElements;
  }

  public boolean contains (T target)
  // Returns true if this collection contains an element e such that 
  // e.equals(target); otherwise, returns false.
  {
    find(target);
    return found;
  }

  public boolean remove (T target)
  // Removes an element e from this collection such that e.equals(target)
  // and returns true; if no such element exists, returns false.
  {
    find(target);
    if (found)
    {
      if (head == location)     
        head = head.getLink();    // remove first node
      else
        previous.setLink(location.getLink());  // remove node at location

      numElements--;
    }
    return found;
  }

  public T get(T target)
  // Returns an element e from this collection such that e.equals(target);
  // if no such element exists, returns null.
  {
    find(target);    
    if (found)
      return location.getInfo();
    else
      return null;
  }
    
  public boolean isEmpty()
  // Returns true if this collection is empty; otherwise, returns false.
  {
    return (numElements == 0);  
  }

  public boolean isFull()
  // Returns true if this collection is full; otherwise, returns false.
  {
    return false;  // Linked implementation is never full
  }  
  
  public String toString() {
	  //Returns a String object representing this linked-list collection.
	  //5.30a
	  String str = "<";
	  
	  LLNode<T> loc;
	  for (loc = head; loc != null && loc.getLink() != null; loc = loc.getLink()) {
		  str += loc.getInfo().toString() + ", ";
	  }
	  
	  if (numElements != 0) {
		  str += loc.getInfo().toString();
	  }
	  
	  return str+">";
  }
  
  public int count(T target) {
	  //Returns a count of the number of elements that match target such that for element e
	  //e.equals(target) returns true.
	  //5.30b
	  
	  int count = 0;
	  
	  for (LLNode<T> loc = head; loc != null; loc = loc.getLink()) {
		  if (loc.getInfo().equals(target)) {
			  count++;
		  }
	  }
	  
	  return count;
  }
  
  public void removeAll(T target) {
	  //Removes all of the elements that match target such that for element e, e.equals(target) returns true.
	  //5.30c
	  LLNode<T> prev = head;
	  boolean move = false;
	  
	  for (LLNode<T> loc = head; loc != null; loc = loc.getLink()) {
		  if (loc != head) {
			  move = true;
		  }
		  
		  if (loc == head && loc.getInfo().equals(target)) {
			  head = head.getLink();
			  numElements--;
			  prev = head;
		  } else if (loc.getInfo().equals(target)) {
			  prev.setLink(loc.getLink());
			  numElements--;
			  if (loc.getLink() != null) {
				  loc = loc.getLink();
			  }
		  }
		  
		  if (move) {
			  prev = prev.getLink();
		  }
	  }
  }
}