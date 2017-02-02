package assignment11;

import java.util.ArrayList;

/**
 * @author:      Chris Kasza
 * Student #:    100133723
 * Course:       COMP 2113 N1
 * Assignment #: 11
 * Version:      1.0
 * File:         WeightedGraphDriver.java
 *
 * Driver to test WeightGraph class
 * 
 */

public class WeightedGraphDriver {
	public static WeightedGraph graph;
	public static ArrayList<Integer> graphArray;
	
	public static void main(String[] args) {
		graph = new WeightedGraph(100);
		graphArray = new ArrayList<Integer>();
		
		if(graph.isEmpty())
			System.out.println("The graph is empty.");
		
		for(int i = 1; i < 12; i=i+2) {
			if(!graph.isFull()) {
				System.out.println("Adding vertex with name " + i);
				graph.addVertex(i);
				graphArray.add(i);
			}
		}

		System.out.println("Adding edge from 3 to 1");
		graph.addEdge(3, 1, 1);
		System.out.println("Adding edge from 1 to 3");
		graph.addEdge(1, 3, 1);
		System.out.println("Adding edge from 11 to 1");
		graph.addEdge(11, 1, 1);
		System.out.println("Adding edge from 9 to 11");
		graph.addEdge(9, 11, 1);
		System.out.println("Adding edge from 9 to 9");
		graph.addEdge(9, 9, 1);
		System.out.println("Adding edge from 5 to 9");
		graph.addEdge(5, 9, 1);
		System.out.println("Adding edge from 5 to 7");
		graph.addEdge(5, 7, 1);
		
		int[] vertArr = {5, 3, 11, 7};
		for(int vert : vertArr) {
			int numReachable = count(vert);
			System.out.println("The vertex, " + vert + ", can reach " + numReachable + " other vertices.");
		}
	}
	
	// returns the number of vertices reachable from the vertex v.
	public static int count(Object v) {
		int count = 0;
		for(int i = 0; i < graphArray.size(); i++) {
			if(!graphArray.get(i).equals(v)) {
				if(WeightedGraph.depthFirstSearch(graph, v, graphArray.get(i)))
					count++;
			}
		}
		
		return count;
	}
}
