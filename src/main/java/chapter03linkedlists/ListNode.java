/*Copyright (c) Dec 21, 2014 CareerMonk Publications and others.
 * E-Mail           	: info@careermonk.com 
 * Creation Date    	: 2015-01-10 06:15:46 
 * Last modification	: 2006-05-31 
               by		: Narasimha Karumanchi 
 * Book Title			: Data Structures And Algorithms Made In Java
 * Warranty         	: This software is provided "as is" without any 
 * 							warranty; without even the implied warranty of 
 * 							merchantability or fitness for a particular purpose. 
 * 
 */

package chapter03linkedlists;


public class ListNode {	
	public Integer data;
	public ListNode next;
	
	
	// Creates an empty node.
	public ListNode() {
		this.data = null;
		this.next = null;
	}

	// Creates a single node storing the specified data.
	public ListNode(Integer data) {
		this(data, null);
	}

	//constructor to represent any node in a Linked List
	public ListNode(Integer data, ListNode next) {
		this.data = data;
		this.next = next;
	}

	
	
	
	// Returns the node that follows this one.
	public ListNode getNext() {
		return next;
	}

	// Sets the node that follows this one.
	public void setNext(ListNode next) {
		this.next =next;
	}

	// Returns the data stored in this node.
	public int getData() {
		return data;
	}

	// Sets the data stored in this node.
	public void setdata(Integer data) {
		this.data = data;
	}

	// Sets the data stored in this node.
	public String toString() {
		return Integer.toString(data);
	}
	
	public void printLinkedList() {
		ListNode head = this;
		while (head != null) {
			System.out.print(head.data + "->");
			head = head.next;
		}
		System.out.println();
	}
}
