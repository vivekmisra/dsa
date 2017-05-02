/*Copyright (c) Mar 23, 2017 CareerMonk Publications and others.
 * E-Mail           	: info@careermonk.com 
 * Creation Date    	: 2015-01-10 06:15:46 
 * Last modification	: 2006-05-31 
               by		: Narasimha Karumanchi 
 * File Name			: StackAsLinkedList.java
 * Book Title			: Data Structures And Algorithms Made In Java
 * Warranty         	: This software is provided "as is" without any 
 * 							warranty; without even the implied warranty of 
 * 							merchantability or fitness for a particular purpose. 
 * 
 */


package chapter04stacks;

import java.util.EmptyStackException;

import chapter03linkedlists.LinkedListDemo;

public class StackAsLinkedList {
	
	protected LinkedListDemo list;
	private int length;  		// indicates the size of the linked list
	public StackAsLinkedList() {
		length = 0;
		list = new LinkedListDemo();
	}
	
	public void push (int data)  {
		list.prepend(data);
		length++;
	}
	
	public Integer pop() throws EmptyStackException{
		if(length ==0){
			throw new  EmptyStackException();
		}
		Integer data = list.getHead().getData();
		list.removeByMatchedData(data);
		length--;
		return data;
	}
	
	public boolean isEmpty(){
		return (length == 0);
		
	}

	public static void main(String[] args) {
		StackAsLinkedList stack =  new StackAsLinkedList();
		stack.push(4);
		stack.push(7);
		stack.push(40);
		Integer d1 = stack.pop();
		System.out.println(" d1="+d1);
		stack.push(5);
		Integer d2 = stack.pop();
		System.out.println(" d2="+d2);
	}

}
