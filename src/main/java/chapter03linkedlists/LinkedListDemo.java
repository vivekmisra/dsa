/*Copyright (c) Dec 21, 2014 CareerMonk Publications and others.
 * E-Mail           	: info@careermonk.com 
 * Creation Date    	: 2015-01-10 06:15:46 
 * Last modification	: 2006-05-31 
               by		: Narasimha Karumanchi 
 * File Name			: LinkedList.java
 * Book Title			: Data Structures And Algorithms Made In Java
 * Warranty         	: This software is provided "as is" without any 
 * 							warranty; without even the implied warranty of 
 * 							merchantability or fitness for a particular purpose. 
 * 
 */

package chapter03linkedlists;

public class LinkedListDemo {

	// holds the head &tail of the list
	protected ListNode head;
	protected ListNode tail;
	// Length of the linked list
	private int length = 0;

	// This class has a default constructor:
	public LinkedListDemo() {
		length = 0;
		head = new ListNode();
	
	}

	public LinkedListDemo(ListNode head) {
		length = 0;
		this.head = head;
	}

	public LinkedListDemo(ListNode head, ListNode tail) {
		length = 0;
		this.head = head;
		this.tail = tail;
	}

	// Return the first node-head in the list
	public synchronized ListNode getHead() {
		return head;
	}

	// Return the last node-tail in the list
	public synchronized ListNode getTail() {
		return tail;
	}

	// purge
	public void purge() {
		this.head = null;
		this.tail = null;
	}

	public void prepend(Integer data) {

		// Construct a node tmp and make head as the next pointer:Step1
		ListNode tmp = new ListNode(data, head);

		if (null != this.head) {
			// asign new head:make tmp the new head:Step2
			this.head = tmp;
		} else {
			// but if list is empty then the temp is the only element and is new
			// tail as wells as head[see next statement executed]
			this.tail = tmp;// tmp is new tail
		}
		this.head = tmp;
		length++;
	}

	// Insert a node at the beginning of the list
	public synchronized void insertAtBegin(ListNode tmp) {
		tmp.setNext(head);
		if (null != this.head) {
			// asign new head:make tmp the new head:Step2
			this.head = tmp;
		} else {
			// but if list is empty then the temp is the only element and is new
			// tail as wells as head[see next statement executed]
			this.tail = tmp;// tmp is new tail
		}
		this.head = tmp;
		length++;
	}

	// Insert a node at the end of the list
	public void append(Integer data) {
		// Construct a node tmp and make null as the next pointer:Step1
		ListNode tmp = new ListNode(data, null);

		if (!isEmpty()) {
			// make next pointer of tail as tmp :Step2
			 tail.next = tmp;// tmp is new tail
			
		} else {
			// but if list is empty then the temp is the only element 
			//and is new tail as wells as head[see next statement executed]	
			this.head = tmp;
		}
		this.tail = tmp; // now make tmp the new tail:Step2
	
		length++;
	}

	// Insert a node at the end of the list
	public synchronized void insertAtEnd(ListNode tmp) {
		if (head == null)
			head = tmp;
		else {
			ListNode p, q;
			for (p = head; (q = p.getNext()) != null; p = q)
				;
			p.setNext(tmp);
		}
		length++;
	}

	public ListNode find(Integer x) {
		ListNode lnode = getHead();// runner
		while (lnode != null && !lnode.data.equals(x)) {

			lnode = lnode.next;
		}

		return lnode;
	}

	public ListNode findPrevious(Integer x) {
		ListNode lnode = getHead();// runner
		while (lnode != null && !lnode.next.data.equals(x)) {

			lnode = lnode.next;
		}

		return lnode;
	}

	// Add a new value to the list at a given position.
	// All values at that position to the end move over to make room.
	public void insert(Integer data, int position) {
		// fix the position
		if (position < 0) {
			position = 0;
		}
		if (position > length) {
			position = length;
		}

		// if the list is empty, make it be the only element
		if (head == null) {
			head = new ListNode(data);
		}
		// if adding at the front of the list...
		else if (position == 0) {
			ListNode temp = new ListNode(data);
			temp.next = head;
			head = temp;
		}
		// else find the correct position and insert
		else {
			ListNode previousNode = findPrevious(data);// find node before this
														// one
			ListNode newNode = new ListNode(data);//// Create a required node
													//// with the specified data
													//// and pointing to null
			newNode.next = previousNode.next;// assign next pointer of newly
												// created newNode to Node to
												// which previous node was
												// connected
			previousNode.setNext(newNode);// now update pointer of previous node
											// to point to newNode
		}
		// the list is now one value longer
		length += 1;
	}

	// Remove and return the node at the head of the list
	public synchronized ListNode removeFromBegin() {
		ListNode node = head;
		if (node != null) {
			head = node.getNext();
			node.setNext(null);
		}
		return node;
	}

	// Remove and return the node at the end of the list
	public synchronized ListNode getLast() {
		if (head == null)
			return null;
		if (head.getNext() == null) {
			return head;
		}
		ListNode p = head.getNext();
		while (p.getNext() != null) {
			p = p.getNext();
		}
		return p;
	}

	// Remove and return the node at the end of the list
	public synchronized ListNode removeFromEnd() {
		if (head == null)
			return null;
		ListNode p = head, q = null, next = head.getNext();
		if (next == null) {
			head = null;
			// reduce the length of the list
			length -= 1;
			return p;
		}
		while ((next = p.getNext()) != null) {
			q = p;
			p = next;
		}
		q.setNext(null);
		// reduce the length of the list
		length -= 1;
		return p;
	}

	// Remove a node matching the specified node from the list.
	// Use equals() instead of == to test for a matched node.
	public synchronized void removeByMatchedNode(ListNode node) {
		if (head == null)
			return;
		if (node.equals(head)) {
			head = head.getNext();
			// reduce the length of the list
			length -= 1;
			return;
		}else{
			
			ListNode previousNode = findPrevious(node.getData());
			previousNode.setNext(previousNode.getNext().getNext());
		}
		
	}

	public synchronized void removeByMatchedData(Integer data) {
		if (head == null)
			return;
		if (data.equals(head.getData())) {
			head = head.getNext();
			// reduce the length of the list
			length -= 1;
			return;
		} else {
			ListNode previousNode = findPrevious(data);
			previousNode.setNext(previousNode.getNext().getNext());
		}
	}

	// Remove the value at a given position.
	// If the position is less than 0, remove the value at position 0.
	// If the position is greater than 0, remove the value at the last position.
	public void removeByPosition(int position) {
		// fix position
		if (position < 0) {
			position = 0;
		}

		if (position >= length) {
			position = length - 1;
		}

		// if nothing in the list, do nothing
		if (head == null)
			return;

		// if removing the head element...
		if (position == 0) {
			head = head.getNext();
		}
		// else advance to the correct position and remove
		else {
			ListNode temp = head;
			for (int i = 1; i < position; i += 1) {
				temp = temp.getNext();// previous
			}
			temp.setNext(temp.getNext().getNext());
		}
		// reduce the length of the list
		length -= 1;
	}

	LinkedListDemo reverse() {
		// Return a new list containing the same items as the list,
		// but in the reverse order.
		ListNode rev = null; // rev will be the reversed list.
		ListNode current = getHead(); // For running through the nodes of list.
		while (current != null) {
			// construct a new node
			ListNode newNode = new ListNode();
			// copy the data to new node from runner
			newNode.data = current.data;
			// "Push" the next node of list onto the front of rev.
			newNode.next = rev;
			rev = newNode;
			// Move on to the next node in the list.
			current = current.next;
		}
		return new LinkedListDemo(rev);
	} // end reverse()

	// Return a string representation of this collection, in the form
	// ["str1","str2",...].
	public String toString() {
		String result = "[";
		if (head == null) {
			return result + "]";
		}
		result = result + head.getData();
		ListNode temp = head.getNext();
		while (temp != null) {
			result = result + "," + temp.getData();
			temp = temp.getNext();
		}
		return result + "]";
	}

	// Return the current length of the list.
	public int length() {
		return length;
	}

	// Find the position of the first value that is equal to a given value.
	// The equals method us used to determine equality.
	public int getPosition(int data) {
		// go looking for the data
		ListNode temp = head;
		int pos = 0;
		while (temp != null) {
			if (temp.getData() == data) {
				// return the position if found
				return pos;
			}
			pos += 1;
			temp = temp.getNext();
		}
		// else return -1
		return Integer.MIN_VALUE;
	}

	// Size of the list.
	public boolean isEmpty() {
		return length == 0;
	}

	// Remove everything from the list.
	public void clearList() {
		this.head = null;
		this.tail = null;
		length = 0;
	}
	

	public static void main(String[] args) {
		ListNode a = new ListNode(4);
		ListNode b = new ListNode(6);
		ListNode c = new ListNode(1);
		ListNode d = new ListNode(9);
		ListNode e = new ListNode(5);
		ListNode f = new ListNode(3);
		ListNode g = new ListNode(7);
		ListNode h = new ListNode(2);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		f.next = g;
		g.next = h;
		a.printLinkedList();

		LinkedListDemo lnode = new LinkedListDemo(a, h);
		System.out.println("Finding item=3...");
		ListNode foundLnode = lnode.find(3);
		System.out.println("Found foundLnode.item=" + foundLnode.data);

		System.out.println("Finding previous node item of item=3...");
		ListNode foundPreviousLnode = lnode.findPrevious(3);
		System.out.println("Found foundPreviousLnode of item=3 ...=" + foundPreviousLnode.data);

		System.out.println("Prepending 8...");
		lnode.prepend(8);
		lnode.getHead().printLinkedList();

		System.out.println("Removing 9...");
		lnode.removeByMatchedData(9);
		lnode.getHead().printLinkedList();

		System.out.println("Removing at postiopn 2...");
		lnode.removeByPosition(2);
		lnode.getHead().printLinkedList();

		System.out.println("Reversing1...");
		LinkedListDemo reversed = lnode.reverse();
		reversed.getHead().printLinkedList();

	}
}