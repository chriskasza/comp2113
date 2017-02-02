//----------------------------------------------------------------------------
// UseGraph.java             by Dale/Joyce/Weems                     Chapter 9
//
// Uses the graph adt
//----------------------------------------------------------------------------

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import ch04.queues.*;
import ch04.stacks.*;
import ch05.queues.*;
import ch05.stacks.*;
import ch09.graphs.*;
import ch09.priorityQueues.*;

public class UseGraph
{
private static void shortestPaths(WeightedGraphInterface graph,
                                  Object startVertex  )

// Writes the shortest path from startVertex to every 
// other vertex in graph
{
  class Flights implements Comparable
  {
    private Object fromVertex;
    private Object toVertex;
    private int distance;

    public int compareTo(Object otherFlights)
    {
     Flights other = (Flights)otherFlights;
     return (other.distance - this.distance); // shorter is better 
    }
  }

  Flights item;
  Flights saveItem;         // for saving on priority queue
  int minDistance;

  Heap pq = new Heap(10);   // Assume at most 10 vertices
  Object vertex;
  QueueInterface vertexQueue = new LinkedQueue();
  
  graph.clearMarks();
  saveItem = new Flights();
  saveItem.fromVertex = startVertex;
  saveItem.toVertex = startVertex;
  saveItem.distance = 0;
  pq.enqueue(saveItem);

  System.out.println("Last Vertex  Destination   Distance");
  System.out.println("-----------------------------------");
 
  do
  {
    item = (Flights)pq.dequeue();
    if (!graph.isMarked(item.toVertex))
    {
      graph.markVertex(item.toVertex);
      System.out.print(item.fromVertex);
      System.out.print("  ");
      System.out.print(item.toVertex);
      System.out.println("  " + item.distance);
      item.fromVertex = item.toVertex;
      minDistance = item.distance;
      vertexQueue = graph.getToVertices(item.fromVertex);
      while (!vertexQueue.isEmpty())
      {
        vertex = vertexQueue.dequeue();
        if (!graph.isMarked(vertex))
        {
          saveItem = new Flights();
          saveItem.fromVertex = item.fromVertex;
          saveItem.toVertex = vertex;
          saveItem.distance = minDistance +
              graph.weightIs(item.fromVertex, vertex);
          pq.enqueue(saveItem);
        }
      }
    }
  } while (!pq.isEmpty());
}



private static boolean depthFirstSearch(WeightedGraphInterface graph,
                                        Object startVertex, 
                                        Object endVertex    )

// Returns true if a path exists on graph, from startVertex to endVertex; 
// otherwise returns false.

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

private static boolean breadthFirstSearch(WeightedGraphInterface graph,
                                          Object startVertex, 
                                          Object endVertex    )

// Returns true if a path exists on graph, from startVertex to endVertex; 
// otherwise returns false.

{
  QueueInterface queue = new LinkedQueue();
  QueueInterface vertexQueue = new LinkedQueue();
 
  boolean found = false;
  Object vertex;
  Object item;
  graph.clearMarks();
  queue.enqueue(startVertex);
  do
  {
    vertex = queue.dequeue();
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
            queue.enqueue(item);
        }
      }
    }
  } while (!queue.isEmpty() && !found);
  
  return found;
}


  public static void main(String[] args) throws IOException 
  {
    WeightedGraphInterface graph = new WeightedGraph();
    String s0 = new String("Atlanta   ");
    String s1 = new String("Austin    ");
    String s2 = new String("Chicago   ");
    String s3 = new String("Dallas    ");
    String s4 = new String("Denver    ");
    String s5 = new String("Houston   ");
    String s6 = new String("Washington");

    graph.addVertex(s0);
    graph.addVertex(s1);
    graph.addVertex(s2);
    graph.addVertex(s3);
    graph.addVertex(s4);
    graph.addVertex(s5);
    graph.addVertex(s6);

    graph.addEdge(s0, s5, 800);
    graph.addEdge(s0, s6, 600);
    graph.addEdge(s1, s3, 200);
    graph.addEdge(s1, s5, 160);
    graph.addEdge(s2, s4, 1000);
    graph.addEdge(s3, s1, 200);
    graph.addEdge(s3, s2, 900);
    graph.addEdge(s3, s4, 780);
    graph.addEdge(s4, s0, 1400);
    graph.addEdge(s4, s2, 1000);
    graph.addEdge(s5, s0, 800);
    graph.addEdge(s6, s0, 600);
    graph.addEdge(s6, s3, 1300);

    boolean result;

    System.out.println("depth first ...");
    result = depthFirstSearch(graph, s1, s2);
    System.out.println("s1 s2 " + result);
    result = depthFirstSearch(graph, s1, s6);
    System.out.println("s1 s6 " + result);
    result = depthFirstSearch(graph, s6, s5);
    System.out.println("s6 s5 " + result);
    result = depthFirstSearch(graph, s6, s3);
    System.out.println("s6 s3 " + result);
 
    System.out.println();

    System.out.println("breadth first ...");
    result = breadthFirstSearch(graph, s1, s2);
    System.out.println("s1 s2 " + result);
    result = breadthFirstSearch(graph, s1, s6);
    System.out.println("s1 s6 " + result);
    result = breadthFirstSearch(graph, s6, s5);
    System.out.println("s6 s5 " + result);
    result = breadthFirstSearch(graph, s6, s3);
    System.out.println("s6 s3 " + result);

    System.out.println();

    shortestPaths(graph, s6);

  } 
} 