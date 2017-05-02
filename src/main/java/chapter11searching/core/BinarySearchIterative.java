/*Copyright (c) Apr 27, 2017 CareerMonk Publications and others.
 * E-Mail           	: info@careermonk.com 
 * Creation Date    	: 2015-01-10 06:15:46 
 * Last modification	: 2006-05-31 
               by		: Narasimha Karumanchi 
 * File Name			: BinarySearchIterative.java
 * Book Title			: Data Structures And Algorithms Made In Java
 * Warranty         	: This software is provided "as is" without any 
 * 							warranty; without even the implied warranty of 
 * 							merchantability or fitness for a particular purpose. 
 * 
 */


package chapter11searching.core;

public class BinarySearchIterative {

	public BinarySearchIterative() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int[] a = new int[] { 11,15,17,19,23,30,35,41,45 };
		System.out.println("search " + search(a,19));

	}
	
	
	public static boolean search(int[] A, int data) {
        int left = 0;
        int right = A.length - 1;
      
        while(left <= right){
        	  int mid = left + (right - left) / 2;
             printArray(A,data,left,mid,right);
              if(A[mid] == data)
                  return true;
              
              if(data < A[mid]){
              	right = mid-1;
              	//left unchanged
              }
              
              if (data>A [mid]){
              	left = mid +1;
              }
              
        }
        System.out.println();
		return false;
        
    }
	
	public static void printArray(int[] a,int data, int leftCursor,int midCursor, int rightCursor) {
		System.out.println("*******");
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
		
			System.out.print(" data=" + data);
		
		if (leftCursor >= 0) {
			System.out.print(" ,leftCursor=" + leftCursor + " ,a[" + leftCursor + "]=" + a[leftCursor]);
		}
		
		if (midCursor >= 0) {
			System.out.print(" ,midCursor=" + midCursor + " ,a[" + midCursor + "]=" + a[midCursor]);
		}
		
		if (rightCursor >= 0) {
			System.out.print(" ,rightCursor=" + rightCursor + " ,a[" + rightCursor + "]=" + a[rightCursor]);
		}
		
	}

}
