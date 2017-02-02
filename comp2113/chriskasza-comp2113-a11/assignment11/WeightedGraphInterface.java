//----------------------------------------------------------------------------
// WeightedGraphInterface.java       by Dale/Joyce/Weems             Chapter 9
//
// Interface for a class that implements a directed graph with weighted edges.
// Vertices are Objects.
// Edge weights are integers.
//----------------------------------------------------------------------------

package assignment11;

import ch04.queues.*;

public interface WeightedGraphInterface
{
  public boolean isEmpty();
  // Effect:         Determines whether this graph is empty.
  // Postcondition:  Return value = (this graph is empty)

  public boolean isFull();
  // Effect:         Determines whether this graph is full.
  // Postcondition:  Return value = (this graph is full)

  public void addVertex(Object vertex);
  // Effect:	     Adds vertex to the graph.
  // Precondition:   Graph is not full.
  // Postcondition:  vertex is in V(graph).

  public void addEdge(Object fromVertex, Object toVertex, int weight);
  // Effect:         Adds an edge with the specified weight from fromVertex 
  //                   to toVertex.
  // Precondition:   fromVertex and toVertex are in V(graph).
  // Postcondition:  (fromVertex, toVertex) is in E(graph) with the specified weight.

  public int weightIs(Object fromVertex, Object toVertex);
  // Effect:         Determines the weight of the edge from fromVertex to toVertex.
  // Precondition:   fromVertex and toVertex are in V(graph).
  // Postcondition:  if edge exists, Return value = (weight of edge from fromVertex 
  //                   to toVertex)
  //                 otherwise return value = (special “null-edge” value)

  public QueueInterface getToVertices(Object vertex);
  // Effect:         Returns a queue of the vertices that are adjacent from vertex.
  // Precondition:   vertex is in V(graph).
  // Postcondition:  returns a queue containing all the vertices that are adjacent
  //                   from vertex.

  public void clearMarks();
  // Effect:         Sets marks for all vertices to false.
  // Postcondition:  All marks have been set to false.

  public void markVertex(Object vertex);
  // Effect:         Sets mark for vertex to true.
  // Precondition:   vertex is in V(graph).
  // Postcondition:  isMarked(vertex) is true.

  public boolean isMarked(Object vertex);
  // Effect:         Determines if vertex has been marked.
  // Precondition:   vertex is in V(graph)
  // Postcondition:  return value = (vertex is marked true)
}
