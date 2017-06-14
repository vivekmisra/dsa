/*Copyright (c) Mar 24, 2017 CareerMonk Publications and others.
 * E-Mail           	: info@careermonk.com 
 * Creation Date    	: 2015-01-10 06:15:46 
 * Last modification	: 2006-05-31 
               by		: Narasimha Karumanchi 
 * File Name			: QueueAsLinkedList.java
 * Book Title			: Data Structures And Algorithms Made In Java
 * Warranty         	: This software is provided "as is" without any 
 * 							warranty; without even the implied warranty of 
 * 							merchantability or fitness for a particular purpose. 
 * 
 */

package chapter05queues;

import java.util.NoSuchElementException;

import chapter03linkedlists.LinkedListDemo;
import chapter04stacks.StackAsLinkedList;

public class QueueAsLinkedList {

	protected  LinkedListDemo list;
	private int length; // indicates the size of the linked list

	public QueueAsLinkedList() {
		length = 0;
		list = new LinkedListDemo();
	}

	public void enqueue(int data) {
		
		list.append(data);
		++length;
		
	}

	public int dequeue() throws Exception {
		if (length == 0) {
			throw new NoSuchElementException();
		}
		Integer data = list.getHead().getData();
		list.removeFromBegin();
		--length;
		return data;
	}
//  Returns true if this queue is empty and false otherwise. 
	public boolean isEmpty(){
		return (length == 0);
	}




	public static void main(String[] args) throws Exception {
		QueueAsLinkedList queue =  new QueueAsLinkedList();
		queue.enqueue(4);	
		queue.enqueue(7);
		queue.enqueue(40);
		System.out.println(" queue="+queue);
		Integer d1 = queue.dequeue();
		System.out.println(" d1="+d1);
		queue.enqueue(5);
		Integer d2 = queue.dequeue();
		System.out.println(" d2="+d2);
		Integer d3 = queue.dequeue();
		System.out.println(" d3="+d3);
	}

}
