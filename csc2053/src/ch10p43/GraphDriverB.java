//----------------------------------------------------------------------------
// GraphDriverB.java            by Chris Stitt                For Chapter 10.43b
//
// Tests each feature of the GraphADT class created in 10.43a.
//----------------------------------------------------------------------------
package ch10p43;

public class GraphDriverB {

	public static void main(String[] args) {
		//Check 1: Initializing using base case, isEmpty, isFull, addVertex
		GraphADT<Integer> graph = new GraphADT<>();
		boolean empty = graph.isEmpty();
		for (int i = 0; i < 50; i++) {
			graph.addVertex(i);
		}
		boolean full = graph.isFull();
		System.out.println("Check 1: "+((empty && full)?"Success!":"Failure!"));
		
		//Check 2: Initializing using maxV
		graph = new GraphADT<>(5);
		empty = graph.isEmpty();
		for (int i = 0; i < 5; i++) {
			graph.addVertex(i);
		}
		full = graph.isFull();
		System.out.println("Check 2: "+((empty && full)?"Success!":"Failure!"));
		
		//Check 3: Using hasVertex
		boolean there = true;
		for (int i = 0; i < 5; i++) {
			if (!graph.hasVertex(i)) {
				there = false;
			}
		}
		System.out.println("Check 3: "+((there)?"Success!":"Failure!"));
		
		//Check 4: Using addEdge and getToVertices
		//Graph: 1--4, 3--0, 2
		boolean conn = true;
		graph.addEdge(1, 4);
		graph.addEdge(3, 0);
		if (graph.getToVertices(1).size() != graph.getToVertices(4).size()) {
			conn = false;
		} else if (graph.getToVertices(3).size() != graph.getToVertices(0).size()) {
			conn = false;
		} else if (graph.getToVertices(2).size() != 0) {
			conn = false;
		}
		System.out.println("Check 4: "+((conn)?"Success!":"Failure!"));
		
		//Check 5: Using edgeExists and removeEdge
		//Graph same as Check 4
		boolean ex = true, rem = true;
		ex = graph.edgeExists(0, 2)?false:ex;
		ex = graph.edgeExists(3, 0)?ex:false;
		ex = graph.edgeExists(0, 3)?ex:false;
		rem = graph.removeEdge(0, 2)?false:rem;
		rem = graph.removeEdge(3, 0)?rem:false;
		ex = graph.edgeExists(0, 3)?false:ex;
		System.out.println("Check 5: "+((ex && rem)?"Success!":"Failure!"));
		
		//Check 6: Using the mark methods
		//Graph after Check 5: 1--4, 3, 0, 2
		boolean lastC = true;
		for (int i = 0; i < 5; i++) {
			lastC = graph.isMarked(i)?false:lastC;
			graph.markVertex(i);
			lastC = graph.isMarked(i)?lastC:false;
		}
		graph.clearMarks();
		for (int i = 0; i < 5; i++) {
			lastC = i==graph.getUnmarked()?lastC:false;
			graph.markVertex(i);
		}
		lastC = null==graph.getUnmarked()?lastC:false;
		System.out.println("Check 6: "+((lastC)?"Success!":"Failure!"));
	}
}