/*Copyright (c) Mar 23, 2017 CareerMonk Publications and others.
 * E-Mail           	: info@careermonk.com 
 * Creation Date    	: 2015-01-10 06:15:46 
 * Last modification	: 2006-05-31 
               by		: Narasimha Karumanchi 
 * File Name			: ReverseStack.java
 * Book Title			: Data Structures And Algorithms Made In Java
 * Warranty         	: This software is provided "as is" without any 
 * 							warranty; without even the implied warranty of 
 * 							merchantability or fitness for a particular purpose. 
 * 
 */

package chapter04stacks;

import java.util.Stack;

public class ReverseStack {

	public ReverseStack() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(5);
		stack.push(4);
		stack.push(3);
		stack.push(2);
		stack.push(1);
		reverseStack(stack);
		for (int i = 0, n = stack.size(); i < n; i++) {
			System.out.println(stack.elementAt(i));
		}

	}

	public static <T> void reverseStack(Stack<T> stack) {
		if (stack.isEmpty()) {
			return;
		}
		// Remove bottom element from stack
		T bottom = popBottom(stack);

		/*
		 * Reverse everything else in stack once stack is empty come out of this
		 * statement
		 */
		reverseStack(stack);

		/*
		 * Add original bottom element to top of stack.It will be in upward order so
		 * first it will be 1, then 2 then 3... .,5
		 */

		stack.push(bottom);
	}

	private static <T> T popBottom(Stack<T> stack) {
		/*
		 * In order to return the bottom element, we must keep popping until
		 * stack is empty and then return the last top popped element -which
		 * will actually be bottom element So if stack = [1,2,3,4,5] -5 will be
		 * returned as last top element thus making stack as [1,2,3,4] . If
		 * recursively called, it will return -5 ,then 4, then 3...
		 * 
		 */
		T top = stack.pop();
		if (stack.isEmpty()) {
			// If we removed the last element, return it
			return top;
		} else {
			// We didn't remove the last element, so remove the last element
			// from what remains
			T bottom = popBottom(stack);
			// Since the element we removed in this function call isn't the
			// bottom element, add it back onto the top of the stack where it
			// came from
			stack.push(top);
			return bottom;
		}
	}

}
