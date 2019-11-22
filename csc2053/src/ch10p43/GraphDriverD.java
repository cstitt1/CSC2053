//----------------------------------------------------------------------------
// GraphDriverD.java            by Chris Stitt                For Chapter 10.43d
//
// Creates 50 different graphs of 10 different edge-number types from 4 to 40 (in increments of 4).
// Outputs the average number of connected components for each graph
//----------------------------------------------------------------------------
package ch10p43;

import ch04.queues.*;

public class GraphDriverD {

	public static void main(String[] args) {
		GraphADT<Integer> graph = new GraphADT<>(26); //Filled with vertices labeled 1 through 26
		for (int i = 1; i <= 26; i++) {
			graph.addVertex(i);
		}
		
		String edgeNums = "";
		for (int i = 4; i <= 40; i+=4) {
			int sum = 0;
			for (int j = 1; j <= 5; j++) {
				while (edgeNums.length() != i*3) {
					int v1 = (int) (Math.random()*26+1), v2 = (int) (Math.random()*26+1);
					char s1 = (char) (v1+64), s2 = (char) (v2+64);
					if (!edgeNums.contains(s1+""+s2) && !edgeNums.contains(s2+""+s1) && v1 != v2) {
						graph.addEdge(v1, v2);
						edgeNums += s1+""+s2+",";
					}
				}
				sum += connComps(graph);
				
				while (edgeNums.length() != 0) {
					int v1 = edgeNums.charAt(0) - 64, v2 = edgeNums.charAt(1) - 64;
					edgeNums = edgeNums.substring(3);
					graph.removeEdge(v1, v2);
				}
			}
			System.out.println("For "+i+" edges, the average number of connected components is "+ sum/5 + "." + (sum%5)*2 + "\n");
		}
	}
	
	private static int connComps(GraphADT<Integer> graph) {
		graph.clearMarks();
		int count = 0;
		Integer ele = graph.getUnmarked();
		while (ele != null) {
			QueueInterface<Integer> toMark = new LinkedQueue<>();
			toMark.enqueue(ele);
			while (!toMark.isEmpty()) {
				Integer mark = toMark.dequeue();
				graph.markVertex(mark);
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
		
		return count;
	}
}