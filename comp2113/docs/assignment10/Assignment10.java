/**
 * @author:      Chris Kasza
 * Student #:    100133723
 * Course:       COMP 2113 N1
 * Assignment #: 10
 * File:         Assignment10.java
 */
 //----------------------------------------------------------------------------
// WeightedGraphInterface.java       by Dale/Joyce/Weems             Chapter 9
//
// Interface for a class that implements a directed graph with weighted edges.
// Vertices are Objects.
// Edge weights are integers.
//----------------------------------------------------------------------------


public interface WeightedGraphInterface
{
	public boolean isEmpty();
	// Effect:         Determines whether this graph is empty.
	// Postcondition:  Return value = (this graph is empty)
	// Big-O Adjacency Matrix: O(1) - number of vertices is maintained and immediately accessible
	// Big-O Adjacency List:   O(1) - number of vertices is maintained and immediately accessible

	public boolean isFull();
	// Effect:         Determines whether this graph is full.
	// Postcondition:  Return value = (this graph is full)
	// Big-O Adjacency Matrix: O(1) - the capacity of the array is immediately accessible and can be compared with the 
	//	  number of vertices
	// Big-O Adjacency List:   null - the list does not have a size limit defined in the program

	public void addVertex(Object vertex);
	// Effect:	     Adds vertex to the graph.
	// Precondition:   Graph is not full.
	// Postcondition:  vertex is in V(graph).
	// Big-O Adjacency Matrix: O(N) - add new vertex to column and row of matrix; loop through N vertices to set new
	//   cells in matrix to NULL
	// Big-O Adjacency List:   O(1) - new vertex is created; new vertex reference is added to last vertex in the 
	//   vertices list

	public void addEdge(Object fromVertex, Object toVertex, int weight);
	// Effect:         Adds an edge with the specified weight from fromVertex 
	//                   to toVertex.
	// Precondition:   fromVertex and toVertex are in V(graph).
	// Postcondition:  (fromVertex, toVertex) is in E(graph) with the specified weight.
	// Big-O Adjacency Matrix: O(N) x2 - calls indexIs twice to get the matrix coordinates where the edge will be added
	// Big-O Adjacency List:   O(N) - calls indexIs to find the starting vertex; adds new edge to vertex's edge list
	
	public int weightIs(Object fromVertex, Object toVertex);
	// Effect:         Determines the weight of the edge from fromVertex to toVertex.
	// Precondition:   fromVertex and toVertex are in V(graph).
	// Postcondition:  if edge exists, Return value = (weight of edge from fromVertex 
	//                   to toVertex)
	//                 otherwise return value = (special “null-edge” value)
	// Big-O Adjacency Matrix: O(N) x2 - calls indexIs twice to get the matrix intersection of the provided vertices
	// Big-O Adjacency List:   O(N) + O(n) - N is the number of vertices and n is the number of edges for a given vertex;
	//   need to iterate vertice list to find starting vertex and then need to iterate edge list to find ending vertex

	public QueueInterface getToVertices(Object vertex);
	// Effect:         Returns a queue of the vertices that are adjacent from vertex.
	// Precondition:   vertex is in V(graph).
	// Postcondition:  returns a queue containing all the vertices that are adjacent
	//                   from vertex.
	// Big-O Adjacency Matrix: O(N) x2 - calls indexIs to find starting vertex and then iterates through related matrix 
	//   column to build queue of edges
	// Big-O Adjacency List:   O(N) - calls indexIs to find starting vertex then returns edge list

	public void clearMarks();
	// Effect:         Sets marks for all vertices to false.
	// Postcondition:  All marks have been set to false.
	// Big-O Adjacency Matrix: O(N) - iterates over all vertices
	// Big-O Adjacency List:   O(N) - iterates over all vertices

	public void markVertex(Object vertex);
	// Effect:         Sets mark for vertex to true.
	// Precondition:   vertex is in V(graph).
	// Postcondition:  isMarked(vertex) is true.
	// Big-O Adjacency Matrix: O(N) - call indexIs to get vertex location 
	// Big-O Adjacency List:   O(N) - call indexIs to get vertex location 

	public boolean isMarked(Object vertex);
	// Effect:         Determines if vertex has been marked.
	// Precondition:   vertex is in V(graph)
	// Postcondition:  return value = (vertex is marked true)
	// Big-O Adjacency Matrix: O(N) - call indexIs to get vertex location 
	// Big-O Adjacency List:   O(N) - call indexIs to get vertex location 
}
