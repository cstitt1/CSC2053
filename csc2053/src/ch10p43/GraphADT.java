//----------------------------------------------------------------------------
// GraphADT.java            by Chris Stitt                For Chapter 10.43a
//
// Creates an ADT for an undirected and unweighted graph.
//----------------------------------------------------------------------------
package ch10p43;

import ch04.queues.*;

public class GraphADT<T> {
	private static final int DEFCAP = 50;  // default capacity
	private int numVertices, maxVertices;
	private T[] vertices;
	private boolean[][] edges;
	private boolean[] marks;  // marks[i] is mark for vertices[i]
	
	public GraphADT()
	// Instantiates a graph with capacity DEFCAP vertices.
	{
		this(DEFCAP);
	}
	
	public GraphADT(int maxV)
	// Instantiates a graph with capacity maxV.
	{
		numVertices = 0;
		maxVertices = maxV;
	    vertices = (T[]) new Object[maxV];
	    marks = new boolean[maxV];
	    edges = new boolean[maxV][maxV];
	}

	public boolean isEmpty()
	// Returns true if this graph is empty; otherwise, returns false.
	{
		return numVertices == 0;
	}

	public boolean isFull()
	// Returns true if this graph is full; otherwise, returns false.
	{
		return numVertices == maxVertices;
	}

	public void addVertex(T vertex)
	// Preconditions:   This graph is not full.
	//                  vertex is not already in this graph.
	//                  vertex is not null.
	//
	// Adds vertex to this graph.
	{
		vertices[numVertices] = vertex;
	    for (int index = 0; index < numVertices; index++)
	    {
	    	edges[numVertices][index] = false;
	    	edges[index][numVertices] = false;
	    }
	    numVertices++;
	}

	public boolean hasVertex(T vertex)
	// Returns true if this graph contains vertex; otherwise, returns false.
	{
		for (int i = 0; i < numVertices; i++) {
			if (vertex.equals(vertices[i])) {
				return true;
			}
		}
		  
		return false;
	}
	  
	private int indexIs(T vertex)
	// Returns the index of vertex in vertices.
	{
		int index = 0;
		while (!vertex.equals(vertices[index]))
			index++;
		return index;
	}

	public void addEdge(T fromVertex, T toVertex)
	// Adds an edge connecting fromVertex to toVertex.
	{
		int row;
	    int column;
	 
	    row = indexIs(fromVertex);
	    column = indexIs(toVertex);
	    edges[row][column] = true;
	    edges[column][row] = true;
	}

	public QueueInterface<T> getToVertices(T vertex)
	// Returns a queue of the vertices that vertex is adjacent to.
	{
		QueueInterface<T> adjVertices = new LinkedQueue<T>();
	    int fromIndex;
	    int toIndex;
	    fromIndex = indexIs(vertex);
	    for (toIndex = 0; toIndex < numVertices; toIndex++)
	    	if (edges[fromIndex][toIndex])
	    		adjVertices.enqueue(vertices[toIndex]);
	    return adjVertices;
	}

	public void clearMarks()
	// Unmarks all vertices.
	{
		for (int i = 0; i < numVertices; i++) {
			marks[i] = false;
		}
	}

	public void markVertex(T vertex)
	// Marks vertex.
	{
		for (int i = 0; i < numVertices; i++) {
			if (vertex.equals(vertices[i])) {
				marks[i] = true;
				return;
			}
		}
	}

	public boolean isMarked(T vertex)
	// Returns true if vertex is marked; otherwise, returns false.
	{
		for (int i = 0; i < numVertices; i++) {
			if (vertex.equals(vertices[i])) {
				return marks[i];
			}
		}
		  
		return false;
	}
	  
	public T getUnmarked()
	// Returns an unmarked vertex if any exist; otherwise, returns null.
	{
		for (int i = 0; i < numVertices; i++) {
			if (marks[i] == false) {
				return vertices[i];
			}
		}
		  
		return null;
	}
	  
	public boolean edgeExists(T vertex1, T vertex2)
	// Preconditions:  vertex1 and vertex2 are in the set of vertices
	//
	// Return value = (vertex1, vertex2) is in the set of edges
	{
		return (edges[indexIs(vertex1)][indexIs(vertex2)]);
	}

	public boolean removeEdge(T vertex1, T vertex2)
	// Preconditions:  vertex1 and vertex2 are in the set of vertices
	//
	// Return value = true if edge was in the graph (and has been removed)
	//              = false if edge was not in the graph
	{
		boolean existed = edgeExists(vertex1, vertex2);
		int iv1 = indexIs(vertex1);
		int iv2 = indexIs(vertex2);
	    edges[iv1][iv2] = false;
	    edges[iv2][iv1] = false;
	    return existed;
	}
}