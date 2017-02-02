package assignment9;

import java.util.ArrayList;

/**
 * @author:      Chris Kasza
 * Student #:    100133723
 * Course:       COMP 2113 N1
 * Assignment #: 09
 * Version:      1.0
 * File:         EmergWaitingList.java
 *
 * A heap ADT used for an emergency room waiting list. 
 * 
 */

public class EmergWaitingList {

	protected class Patient {
		String name;
		float priority;
	}

	private ArrayList<Patient> waitingList;
	
	public EmergWaitingList() {
		// initialize
		waitingList = new ArrayList<Patient>(); 
	}
	
	// add new node to end of heap then run siftUp to reorder
	public void addPatient(String newName, float newPriority) {
		Patient p = new Patient();
		p.name = newName;
		p.priority = newPriority;
		waitingList.add(p);
		siftUp(waitingList.size() - 1);
	}
	
	// reorder heap based on recently added last node
	public void siftUp(int nodeIndex) {
		int parentIndex;
		Patient tmp;
		
		if(nodeIndex != 0) {
			parentIndex = (nodeIndex - 1) / 2;
			if(waitingList.get(nodeIndex).priority > waitingList.get(parentIndex).priority) {
				tmp = waitingList.get(parentIndex);
				waitingList.set(parentIndex, waitingList.get(nodeIndex));
				waitingList.set(nodeIndex, tmp);
				siftUp(parentIndex);
			}			
		}
	}

	// pop root and then run siftDown to reorder
	public String getNextPatient() {
		if(waitingList.size() == 0) {
			return null;
		}
		String next = waitingList.get(0).name;
		waitingList.set(0, waitingList.get(waitingList.size() - 1));
		waitingList.remove(waitingList.size() - 1);
		if(waitingList.size() > 1) {
			siftDown(0);
		}		
		return next;		
	}
	
	// reorder the heap after removing root
	public void siftDown(int nodeIndex) {
		int leftIndex = nodeIndex * 2 + 1;
		int rightIndex = nodeIndex * 2 + 2;
		Patient node = waitingList.get(nodeIndex);
		
		
		if(leftIndex > (waitingList.size() - 1)) {
			// no child nodes
			return;
		}
		else {
			Patient leftChild = waitingList.get(leftIndex);
			if(leftIndex == (waitingList.size() - 1)) {		
				// no right child or left child priority greater than right child
				if(node.priority < leftChild.priority) {
					waitingList.set(leftIndex, node);
					waitingList.set(nodeIndex, leftChild);
					siftDown(leftIndex);
				}
			}
			else {
				Patient rightChild = waitingList.get(rightIndex);
				if(leftChild.priority >= rightChild.priority) {
					if(node.priority < leftChild.priority) {
						// left child priority larger than node's
						waitingList.set(leftIndex, node);
						waitingList.set(nodeIndex, leftChild);
						siftDown(leftIndex);
					}
				}
				else if(node.priority < rightChild.priority) {
					// right child priority larger than node's
					waitingList.set(rightIndex, node);
					waitingList.set(nodeIndex, rightChild);
					siftDown(rightIndex);				
				}
			}
		}		
	}
	
	// return size of list
	public int getNumWaiting() {
		return waitingList.size();
	}
	
	// return whole list
	public ArrayList<Patient> getList() {
		return waitingList;
	}
}
