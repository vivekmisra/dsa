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

package chapter06trees.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import chapter06trees.BinaryTreeNode;
import chapter06trees.SiblingBinaryTreeNode;

public class BFS {

	/*public static class BinaryTreeNode {
		int data;
		BinaryTreeNode left;
		BinaryTreeNode right;

		BinaryTreeNode(int data) {
			this.data = data;
		}
	}*/

	// prints in level order
	public static void levelOrderTraversal(BinaryTreeNode startNode) {
		Queue queue = new LinkedList();
		queue.add(startNode);
		while (!queue.isEmpty()) {
			BinaryTreeNode tempNode = (BinaryTreeNode) queue.poll();
			System.out.printf("%d ", tempNode.data);
			if (tempNode.left != null)
				queue.add(tempNode.left);
			if (tempNode.right != null)
				queue.add(tempNode.right);
		}
	}
	
	
	public static int maxBylevelOrderTraversal(BinaryTreeNode startNode) {
		   int max = Integer.MIN_VALUE;
		Queue queue = new LinkedList();
		queue.add(startNode);
		while (!queue.isEmpty()) {
			BinaryTreeNode tempNode = (BinaryTreeNode) queue.poll();
			
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
	
	public static int maxElementInBinaryTreeRecursive(BinaryTreeNode startNode) {
		   int max = Integer.MIN_VALUE;
		   
		   if(startNode !=null){
			   int leftMax = maxElementInBinaryTreeRecursive(startNode.left);
			   int rightMax = maxElementInBinaryTreeRecursive(startNode.right);
			   if(leftMax > max){
				   max = leftMax;
			   }
			   if (rightMax > max){
				   max = rightMax;
			   }
			   if (startNode.data >max){
				   max = startNode.data;
			   }
		   }
		
		 return max;
	}
	
	/* Returns the total number of nodes in this binary tree (include the root in the count).
	 * 
	 */
		public int size(BinaryTreeNode root) {
			int count = 0;
	    	if(root == null)
	            return 0;
	        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
	        q.offer(root);
	        while(!q.isEmpty()){
	        	BinaryTreeNode tmp = q.poll();
	        	count++;
	            if(tmp.getLeft() != null)
	                q.offer(tmp.getLeft());
	            if(tmp.right != null)
	                q.offer(tmp.right);
	        }
			return count;
		}
/*
 * // The last node processed from queue in level order is the deepest node in binary tree.
 */
	public BinaryTreeNode deepestNodeinBinaryTree(BinaryTreeNode root) {
		BinaryTreeNode tmp = null;
    	if(root == null)
            return null;
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
        	tmp = q.poll();
            if(tmp.getLeft() != null)
                q.offer(tmp.getLeft());
            if(tmp.right != null)
                q.offer(tmp.right);
        }
		return tmp;
	}
	
	
	public int minDepth(BinaryTreeNode root) {
        if(root == null) return 0;
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        q.offer(null);
        int count = 1;
        while(!q.isEmpty()){
            BinaryTreeNode currentNode = q.poll();
            if(currentNode != null){
                if(currentNode.getLeft() == null && currentNode.right == null){
                    return count;
                }
                if(currentNode.getLeft() != null){
                    q.offer(currentNode.getLeft());
                }
                if(currentNode.right != null){
                    q.offer(currentNode.right);
                }   
            }else{
                if(!q.isEmpty()){
                    count++;
                    q.offer(null);
                }
            }
        }
        return count;
    }
	public static int sumOfNodesInBT(BinaryTreeNode  root) {
		int sum = 0;
    	if(root == null)
            return 0;
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
        	BinaryTreeNode tmp = q.poll();
        	sum += tmp.data;
            if(tmp.getLeft() != null)
                q.offer(tmp.getLeft());
            if(tmp.right != null)
                q.offer(tmp.right);
        }
		return sum;
	}
	

	public int numberOfFullNodesInBTusingLevelOrder(BinaryTreeNode root) {
		int count = 0;
    	if(root == null)
            return 0;
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
        	BinaryTreeNode tmp = q.poll();
        	if(tmp.getLeft() != null && tmp.getRight() != null)
    			count++;
            if(tmp.getLeft() != null)
                q.offer(tmp.getLeft());
            if(tmp.right != null)
                q.offer(tmp.right);
        }
		return count;
	}
	
	public int numberOfHalfNodesInBTusingLevelOrder(BinaryTreeNode root) {
		int count = 0;
    	if(root == null)
            return 0;
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
        	BinaryTreeNode tmp = q.poll();
        	if((tmp.getLeft() == null && tmp.getRight() != null) || 
        			(tmp.getLeft() != null && tmp.getRight() != null))
    			count++;		
            if(tmp.getLeft() != null)
                q.offer(tmp.getLeft());
            if(tmp.right != null)
                q.offer(tmp.right);
        }
		return count;
	}
	public int numberOfLeavesInBTusingLevelOrder(BinaryTreeNode root) {
		int count = 0;
    	if(root == null)
            return 0;
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
        	BinaryTreeNode tmp = q.poll();
        	if(tmp.getLeft()== null && tmp.getRight()== null)
    			count++;
            if(tmp.getLeft() != null)
                q.offer(tmp.getLeft());
            if(tmp.right != null)
                q.offer(tmp.right);
        }
		return count;
	}
	
	public int findLevelwithMaxSum(BinaryTreeNode root) {
		int maxSum = 0, currentSum = 0;
		if (root == null)
			return 0;
		// Initialization
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		q.offer(null);
		while (!q.isEmpty()) {
			BinaryTreeNode tmp = q.poll();
			if (tmp != null) {
				if (tmp.getLeft() != null)
					q.offer(tmp.getLeft());
				if (tmp.right != null)
					q.offer(tmp.right);
			} else {
				if (currentSum > maxSum){
					maxSum =  currentSum;
				}
				currentSum = 0;
				// completion of a level;
				if (!q.isEmpty())
					q.offer(null);
			}
		}
		return maxSum;
	}
	
	public static void levelOrderTraversalInReverse(BinaryTreeNode root) {
        if(root == null) 
        	return;
        Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
        	BinaryTreeNode tmp = q.poll();
            if(tmp.getLeft() != null)
                q.offer(tmp.getLeft());
            if(tmp.right != null)
                q.offer(tmp.right);
            s.push(tmp);
        }
        while(!s.isEmpty())
    		System.out.println(s.pop().getData()+ " ");
	}
	
	  public ArrayList<ArrayList<Integer>> zigzagLevelOrder(BinaryTreeNode root) {
	        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	        if(root == null)
	            return res;
	        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
	        q.offer(root);
	        q.offer(null);
	        boolean leftToRight = true;
	        ArrayList<Integer> curr = new ArrayList<Integer>();
	        while(!q.isEmpty()){
	        	BinaryTreeNode tmp = q.poll();
	            if(tmp != null){
	                curr.add(tmp.data);
	                if(tmp.getLeft() != null)
	                    q.offer(tmp.getLeft());
	                if(tmp.right != null)
	                    q.offer(tmp.right);
	            }else{
	                if(leftToRight){
	                    ArrayList<Integer> c_curr = new ArrayList<Integer>(curr);
	        			res.add(c_curr);
	    				curr.clear();
	                }else{
	                    Stack<Integer> s = new Stack<Integer>();
	                    s.addAll(curr);
	                    ArrayList<Integer> c_curr = new ArrayList<Integer>();
	                    while(!s.isEmpty()){
	                        c_curr.add(s.pop());
	                    }
	                    res.add(c_curr);
	                    curr.clear();
	                }
	                if(!q.isEmpty()){
	                    q.offer(null);
	                    leftToRight = !leftToRight;
	                }
	            }
	        }
	        return res;
	    }
	  
	  public BinaryTreeNode insertInBinaryTreeLevelOrder(BinaryTreeNode root, int data){
	    	if(root == null)
	            return null;
	        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
	        q.offer(root);
	        while(!q.isEmpty()){
	        	BinaryTreeNode tmp = q.poll();
	            if(tmp != null){
	                if(tmp.getLeft() != null)
	                    q.offer(tmp.getLeft());
	                else{
	                	tmp.left = new BinaryTreeNode(data);
	                	return root;
	                }
	                if(tmp.right != null)
	                    q.offer(tmp.right);
	                else{
	                	tmp.right = new BinaryTreeNode(data);
	                	return root;
	                }
	            }
	        }
			return root;
	    }
	  
	  public boolean findInBT(BinaryTreeNode root, int data){
	    	if(root == null)
	            return false;
	        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
	        q.offer(root);
	        while(!q.isEmpty()){
	        	BinaryTreeNode tmp = q.poll();
	        	if (tmp.getData() == data){
	        		return true;
	        	}
	            if(tmp != null){
	                if(tmp.getLeft() != null)
	                    q.offer(tmp.getLeft());
	                if(tmp.right != null)
	                    q.offer(tmp.right);
	            }
	        }
	        return false;
	    }
	  
	  public static void fillNextSiblings(SiblingBinaryTreeNode root) {
	    	SiblingBinaryTreeNode tmp = null;
	    	if (root == null)
				return;
			// Initialization
			Queue<SiblingBinaryTreeNode> q = new LinkedList<SiblingBinaryTreeNode>();
			q.offer(root);
			q.offer(null);
			while (!q.isEmpty()) {
				tmp = q.poll();
				if (tmp != null) {
					tmp.setNextSibling(q.peek());
					if (tmp.getLeft() != null)
						q.offer(tmp.getLeft());
					if (tmp.right != null)
						q.offer(tmp.right);
				} else {
					// completion of a level;
					if (!q.isEmpty())
						q.offer(null);
				}
			}
	    }
	

	public static void main(String[] args) {
		BFS bi = new BFS();
		// Creating a binary tree
		BinaryTreeNode rootNode = createBinaryTree();
		System.out.println("Level Order traversal of binary tree will be:");
		levelOrderTraversal(rootNode);
		int max= maxBylevelOrderTraversal(rootNode);
		System.out.print(" ,where max= " + max);
		System.out.println();
		System.out.println(" maxElementInBinaryTreeRecursive="+maxElementInBinaryTreeRecursive(rootNode));
		System.out.println(" sumOfNodesInBT="+sumOfNodesInBT(rootNode));
	}

	public static BinaryTreeNode createBinaryTree() {

		BinaryTreeNode rootNode = new BinaryTreeNode(40);
		BinaryTreeNode node20 = new BinaryTreeNode(20);
		BinaryTreeNode node10 = new BinaryTreeNode(10);
		BinaryTreeNode node30 = new BinaryTreeNode(30);
		BinaryTreeNode node60 = new BinaryTreeNode(60);
		BinaryTreeNode node50 = new BinaryTreeNode(50);
		BinaryTreeNode node70 = new BinaryTreeNode(70);

		rootNode.left = node20;
		rootNode.right = node60;

		node20.left = node10;
		node20.right = node30;

		node60.left = node50;
		node60.right = node70;

		return rootNode;
	}
}
