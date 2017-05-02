/*Copyright (c) Apr 25, 2017 CareerMonk Publications and others.
 * E-Mail           	: info@careermonk.com 
 * Creation Date    	: 2015-01-10 06:15:46 
 * Last modification	: 2006-05-31 
               by		: Narasimha Karumanchi 
 * File Name			: SelectionSort.java
 * Book Title			: Data Structures And Algorithms Made In Java
 * Warranty         	: This software is provided "as is" without any 
 * 							warranty; without even the implied warranty of 
 * 							merchantability or fitness for a particular purpose. 
 * 
 */


package chapter10sorting.core;

public class SelectionSort {
	static Integer[] a = new Integer[] { 11, 2, 1, 6, 8, 5, 3, 4 };
	public SelectionSort() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		sort(a);
		printArray(a);
System.out.println(" 3rd smallest k=3 is="+  kthSmallest(a, a.length, 3));
	}
	
	static int kthSmallest(Integer a[], int n, int k){
	    // Sort the given array
	    sort(a);
	 
	    // Return k'th element in the sorted array
	    return a[k-1];
	}
	
	public static void sort(Integer[] a) {
		int min =0;				
		for(int i=0;i<a.length;i++){
			min =i;//default minimum to index i
			for(int j=i+1;j<a.length;j++){//loop thru index over right
				if(a[j]<a[min]){//if value a[j] is less than value  a[min],than a[j] is new min
					min =j;
					
				}
			}		
			swap(a,min,i);
			
		}
		
	}

	public static void swap(Integer[] a, int left, int right) {
		int temp = a[left];
		a[left] = a[right];
		a[right] = temp;
	}

	public static void printArray(Integer[] a) {
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}
