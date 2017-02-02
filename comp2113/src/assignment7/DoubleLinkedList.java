/**
 * 
 */

package assignment7;

import ch04.genericLists.*;

/**
 * @author:      Chris Kasza
 * Student #:    100133723
 * Course:       COMP 2113 N1
 * Assignment #: 07
 * Version:      1.0
 * File:         DoubleLinkedList.java
 *
 * An implementation of a doubly linked list. 
 * 
 */

public class DoubleLinkedList implements ListInterface {

	protected class ListNode {
		protected Listable info;  // the info in the list node
		protected ListNode prev;  // link to the previous node in the list
		protected ListNode next;  // link to the next node in the list
	}
	
	protected ListNode head;        // reference to the first node
	protected ListNode tail;        // reference to the last node
	protected int numItems;         // number of elements in the list
	protected ListNode currentPos;  // current position for iteration
	
	// constructor; initialize instance variables
	public DoubleLinkedList() {
		this.makeNull();
	}

	@Override
	public boolean isFull() {
		// never full
		return false;
	}

	@Override
	public int lengthIs() {
		return numItems;
	}

	@Override
	public boolean isThere(Listable item) {
		boolean moreToSearch;
		ListNode fwdLocation = head.next;
		ListNode bkwLocation = tail.prev;
		boolean found = false;

		moreToSearch = (fwdLocation != tail);

		while (moreToSearch && !found) {
			if(item.compareTo(fwdLocation.info) == 0) {
				currentPos = fwdLocation;
				found = true;
			}
			else if(item.compareTo(bkwLocation.info) == 0) {
				currentPos = bkwLocation;
				found = true;
			}
			else {
				fwdLocation = fwdLocation.next;
				bkwLocation = bkwLocation.prev;
				moreToSearch = ((fwdLocation.prev != bkwLocation.next) && (fwdLocation.prev != bkwLocation));
			}
		}
		
		return found;
	}

	@Override
	public Listable retrieve(Listable item) {
		boolean found = this.isThere(item);
		
		if(found) {
			return currentPos.info.copy();
		}
		
		return null;
	}

	@Override
	public void insert(Listable item) {
		boolean found = this.isThere(item);		
		
		if(!found) {
			ListNode newNode = new ListNode();
			newNode.info = (Listable)item.copy();
			newNode.prev = tail.prev;
			newNode.next = tail;
			tail.prev.next = newNode;
			tail.prev = newNode;
			numItems++;
		}
	}

	@Override
	public void delete(Listable item) {
		boolean found = this.isThere(item);
		
		if(found) {
			currentPos.prev.next = currentPos.next;
			currentPos.next.prev = currentPos.prev;
			currentPos.next = null;
			currentPos.prev = null;
		}
	}

	@Override
	public void reset() {
		currentPos = head;
		
	}

	@Override
	public Listable getNextItem() {
		if(head.next == tail) {
			return null;
		}
		
		currentPos = currentPos.next;
		
		if(currentPos == tail) {
			currentPos = tail.prev;
			return null;
		}
		return currentPos.info.copy();
	}

	public Listable getPrevItem() {
		if(tail.prev == head) {
			return null;
		}
		
		currentPos = currentPos.prev;
		
		if(currentPos == head) {
			currentPos = head.next;
			return null;
		}
		return currentPos.info.copy();		
	}
	
	public Listable getHead() {
		return head.info.copy();
	}
	
	public Listable getTail() {
		return tail.info.copy();
	}
	
	public void makeNull() {
		numItems = 0;
		head = new ListNode();
		tail = new ListNode();
		head.next = tail;
		tail.prev = head;
		currentPos = head;
	}

}
