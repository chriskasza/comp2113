package assignment11;

import ch04.queues.*;
import ch04.stacks.StackInterface;
import ch05.queues.*;
import ch05.stacks.LinkedStack;

/**
 * @author:      Chris Kasza
 * Student #:    100133723
 * Course:       COMP 2113 N1
 * Assignment #: 11
 * Version:      1.0
 * File:         WeightedGraph.java
 *
 * Implements a directed graph with weighted edges.
 * Vertices are Objects.
 * Edge weights are integers
 * 
 */

public class WeightedGraph implements WeightedGraphInterface

{
	public static int NULL_EDGE = 0;
	private int numVertices;
	private int maxVertices;
	private Object[] vertices;
	private int[][] edges;
	private boolean[] marks;  // marks[i] is mark for vertices[i]

	public WeightedGraph()
	// Post: Arrays of size 50 are dynamically allocated for
	//       marks and vertices, and of size 50 X 50 for edges
	//       numVertices is set to 0; maxVertices is set to 50
	{
		numVertices = 0;
		maxVertices = 50;
		vertices = new Object[50];
		marks = new boolean[50];
		edges = new int[50][50];
	}
 
	public WeightedGraph(int maxV)
	// Post: Arrays of size maxV are dynamically allocated for
	//       marks and vertices, and of size maxV X maxV for edges
	//       numVertices is set to 0; maxVertices is set to maxV
	{
		numVertices = 0;
		maxVertices = maxV;
		vertices = new Object[maxV];
		marks = new boolean[maxV];
		edges = new int[maxV][maxV];
	}

	public boolean isEmpty()
	// Determines whether this graph is empty.
	{
		if(numVertices == 0)
			return true;
		return false;
	}

	public boolean isFull()
	// Determines whether this graph is full.
	{
		if(numVertices == maxVertices)
			return true;
		return false;
	}

	public void addVertex(Object vertex)
	// Post: vertex has been stored in vertices.
	//       Corresponding row and column of edges has been set to NULL_EDGE.
	//       numVertices has been incremented
	{
		vertices[numVertices] = vertex;
		for (int index = 0; index < numVertices; index++)
		{
			edges[numVertices][index] = NULL_EDGE;
			edges[index][numVertices] = NULL_EDGE;
		}
		numVertices++;
	}

	private int indexIs(Object vertex)
	// Post: Returns the index of vertex in vertices
	{
		int index = 0;
		while (vertex != vertices[index])
			index++;
		return index;
	}

	public void addEdge(Object fromVertex, Object toVertex, int weight)
	// Post: Edge (fromVertex, toVertex) is stored in edges
	{
		int row;
		int column;
 
		row = indexIs(fromVertex);
		column = indexIs(toVertex);
		edges[row][column] = weight;
	}

	public int weightIs(Object fromVertex, Object toVertex)
	// Post: Returns the weight associated with the edge
	//       (fromVertex, toVertex)
	{
		int row;
		int column;
 
		row = indexIs(fromVertex);
		column = indexIs(toVertex);
		return edges[row][column];
	}

	public QueueInterface getToVertices(Object vertex)
	// Returns a queue of the vertices that are adjacent from vertex.
	{
		QueueInterface adjVertices = new LinkedQueue();
		int fromIndex;
		int toIndex;
		fromIndex = indexIs(vertex);
		for (toIndex = 0; toIndex < numVertices; toIndex++)
			if (edges[fromIndex][toIndex] != NULL_EDGE)
				adjVertices.enqueue(vertices[toIndex]);
		return adjVertices;
	}

	public void clearMarks()
	// Sets marks for all vertices to false.
	{
		for (int index = 0; index < numVertices; index++)
			marks[index] = false;
	}

	public void markVertex(Object vertex)
	// Sets mark for vertex to true.
	{
		for (int index = 0; index < numVertices; index++)
			if (vertices[index].equals(vertex)) 
				marks[index] = true;
	}

	public boolean isMarked(Object vertex)
	// Determines if vertex has been marked.
	{
		for (int index = 0; index < numVertices; index++)
			if (vertices[index].equals(vertex)) 
				return marks[index];
		return false;
	}

	public static boolean depthFirstSearch(WeightedGraph graph, Object startVertex, Object endVertex)
	// Returns true if a path exists on graph, from startVertex to endVertex;
	// otherwise, returns false
	{
		StackInterface stack = new LinkedStack();
		QueueInterface vertexQueue = new LinkedQueue();
		boolean found = false;
		Object vertex;
		Object item;
		graph.clearMarks();
		stack.push(startVertex);

		do
		{
			vertex = stack.top();
			stack.pop();
			if (vertex == endVertex)
				found = true;
			else
			{
				if (!graph.isMarked(vertex))
				{
					graph.markVertex(vertex);
					vertexQueue = graph.getToVertices(vertex);
					while (!vertexQueue.isEmpty())
					{
						item = vertexQueue.dequeue();
						if (!graph.isMarked(item))
							stack.push(item);
					}
				}
			}
		} while (!stack.isEmpty() && !found);
		
		return found;
	}
}
