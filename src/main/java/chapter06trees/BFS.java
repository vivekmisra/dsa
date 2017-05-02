/*Copyright (c) Mar 24, 2017 CareerMonk Publications and others.
 * E-Mail           	: info@careermonk.com 
 * Creation Date    	: 2015-01-10 06:15:46 
 * Last modification	: 2006-05-31 
               by		: Narasimha Karumanchi 
 * File Name			: BFS.java
 * Book Title			: Data Structures And Algorithms Made In Java
 * Warranty         	: This software is provided "as is" without any 
 * 							warranty; without even the implied warranty of 
 * 							merchantability or fitness for a particular purpose. 
 * 
 */

package chapter06trees;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	public static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
		}
	}

	// prints in level order
	public static void levelOrderTraversal(TreeNode startNode) {
		Queue queue = new LinkedList();
		queue.add(startNode);
		while (!queue.isEmpty()) {
			TreeNode tempNode = (TreeNode) queue.poll();
			System.out.printf("%d ", tempNode.data);
			if (tempNode.left != null)
				queue.add(tempNode.left);
			if (tempNode.right != null)
				queue.add(tempNode.right);
		}
	}
	
	
	public static int maxBylevelOrderTraversal(TreeNode startNode) {
		   int max = Integer.MIN_VALUE;
		Queue queue = new LinkedList();
		queue.add(startNode);
		while (!queue.isEmpty()) {
			TreeNode tempNode = (TreeNode) queue.poll();
			
			if (tempNode.data > max){
        		max = tempNode.data;
        	}
			if (tempNode.left != null)
				queue.add(tempNode.left);
			if (tempNode.right != null)
				queue.add(tempNode.right);
		}
		 return max;
	}


	public static void main(String[] args) {
		BFS bi = new BFS();
		// Creating a binary tree
		TreeNode rootNode = createBinaryTree();
		System.out.println("Level Order traversal of binary tree will be:");
		levelOrderTraversal(rootNode);
		int max= maxBylevelOrderTraversal(rootNode);
		System.out.print(" ,where max= " + max);;
	}

	public static TreeNode createBinaryTree() {

		TreeNode rootNode = new TreeNode(40);
		TreeNode node20 = new TreeNode(20);
		TreeNode node10 = new TreeNode(10);
		TreeNode node30 = new TreeNode(30);
		TreeNode node60 = new TreeNode(60);
		TreeNode node50 = new TreeNode(50);
		TreeNode node70 = new TreeNode(70);

		rootNode.left = node20;
		rootNode.right = node60;

		node20.left = node10;
		node20.right = node30;

		node60.left = node50;
		node60.right = node70;

		return rootNode;
	}
}
