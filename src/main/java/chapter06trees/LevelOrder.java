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

package chapter06trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class LevelOrder {
    public static ArrayList<ArrayList<Integer>> levelOrder(BinaryTreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	if (root == null)
			return res;
		// Initialization
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		q.offer(null);
		ArrayList<Integer> curr = new ArrayList<Integer>();
		while (!q.isEmpty()) {
			BinaryTreeNode tmp = q.poll();
			
			if (tmp != null) {
				curr.add(tmp.data);
				if (tmp.getLeft() != null)
					q.offer(tmp.getLeft());
				if (tmp.right != null)
					q.offer(tmp.right);
			} else {
				ArrayList<Integer> c_curr = new ArrayList<Integer>(curr);
				res.add(c_curr);
				curr.clear(); // Java will clear the reference, so have to new an new ArrayList. 
				// completion of a level;
				if (!q.isEmpty())
					q.offer(null);
			}
		}
		return res;
    }
    
    public static void main(String[] args) {
		BFS bi = new BFS();
		// 40 20 60 10 30 50 70 
		BinaryTreeNode rootNode = createBinaryTree();
		System.out.println("Level Order traversal of binary tree will be:");
		 ArrayList<ArrayList<Integer>> resl = levelOrder(rootNode);
		 
		 for( List<Integer> l  : resl ){
			 for( Integer n : l){
				 System.out.print(n +",");
			 }
		 }
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
