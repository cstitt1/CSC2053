//----------------------------------------------------------------------------
// GraphDriverC.java            by Chris Stitt                For Chapter 10.43c
//
// Uses a formula-generated graph to test counting connected components of a graph
// Outputs the edges, the number of connected components, and a list of them
//----------------------------------------------------------------------------
package ch10p43;

import java.util.ArrayList;
import ch04.queues.*;

public class GraphDriverC {
	public static void main(String[] args) {
		GraphADT<Integer> graph = new GraphADT<>();
		
		int numV = (int) (Math.random()*17 + 4); //Random integer in range of [4,20]
		for (int i = 2; i <= numV; i++) { //Each index i in the range [2, numV] is related to all numbers that it is divisible by other than itself.
			graph.addVertex(i);
			for (int j = 2; j < i; j++) {
				if (i%j == 0 && !graph.edgeExists(i, j)) {
					graph.addEdge(i, j);
					System.out.print(i+"--"+j+", ");
				}
			}
		}
		System.out.println();
		
		ArrayList<String> conn = new ArrayList<>();
		graph.clearMarks();
		int count = 0;
		Integer ele = graph.getUnmarked();
		while (ele != null) {
			QueueInterface<Integer> toMark = new LinkedQueue<>();
			conn.add("");
			toMark.enqueue(ele);
			while (!toMark.isEmpty()) {
				Integer mark = toMark.dequeue();
				graph.markVertex(mark);
				
				if (!conn.get(count).contains("--"+mark)) {
					conn.set(count, conn.get(count)+mark+"--");
				}
				
				QueueInterface<Integer> adjVert = graph.getToVertices(mark);
				while (!adjVert.isEmpty()) {
					Integer adj = adjVert.dequeue();
					if (!graph.isMarked(adj)) {
						toMark.enqueue(adj);
					}
				}
			}
			count++;
			ele = graph.getUnmarked();
		}
		
		System.out.println("The number of connected components is "+count);
		System.out.println("Connected componenents: ");
		for (String comp : conn) {
			System.out.println(comp.substring(0, comp.length()-2));
		}
	}
}