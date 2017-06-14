/*Copyright (c) Apr 19, 2017 CareerMonk Publications and others.
 * E-Mail           	: info@careermonk.com 
 * Creation Date    	: 2015-01-10 06:15:46 
 * Last modification	: 2006-05-31 
               by		: Narasimha Karumanchi 
 * File Name			: MergeSort.java
 * Book Title			: Data Structures And Algorithms Made In Java
 * Warranty         	: This software is provided "as is" without any 
 * 							warranty; without even the implied warranty of 
 * 							merchantability or fitness for a particular purpose. 
 * 
 */

package chapter10sorting.core;

public class MergeSort {
	//static Integer[] a = new Integer[] { 2, 4, 1, 6, 8, 5, 3, 7 };
	static Integer[] a = new Integer[] { 3,1,4,5,9,2,6,8,7};

	public MergeSort() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println("BEFORE:");
		printArray(a);
		sort(a);
		System.out.println("AFTER:");
		printArray(a);

	}

	static void sort(Comparable[] a) {
		int alength = a.length;
		if (alength < 2) {
			return;
		}
		int mid = alength/2;
		Comparable[] left = new Comparable[mid];
		Comparable[] right = new Comparable[alength-mid];
		//populate left
		for(int i=0; i< mid;i++){
			left[i] = a[i];
		}
		//populate right
		for(int i=mid; i< a.length;i++){
			right[i-mid] = a[i];
		}
		sort(left);
		sort(right);
		 System.out.println("***begin merge***");
		merge(a,left,right);
		 System.out.println("***end merge***");
	}

	private static void merge( Comparable[] a,Comparable[] left, Comparable[] right) {
		System.out.print("*** printArray(Comparable[] left):");
		printArray(left) ;
		 System.out.println();
		System.out.print("*** printArray(Comparable[] right):");
		printArray(right) ;
		 System.out.println();
		System.out.print("*** printArray(Comparable[] a):");
		printArray(a) ;
		 System.out.println();
		int leftLength = left.length;
		int rightLength = right.length;
		int aLength = a.length;
		int i=0;
		int j=0;
		int k=0;
		while(i<leftLength && j<right.length){
			System.out.print("*** (left["+i+"].compareTo(right["+j+"])="+(left[i].compareTo(right[j]))); 
			if(left[i].compareTo(right[j]) <= 0){
				a[k++] = left[i++];
			}else{
				a[k++]= right[j++];
				
			}
			
		}
		while(i<leftLength){
			a[k++] = left[i++];
				
		}
		while(j<rightLength){
			
			a[k++]= right[j++];
		}
		System.out.println();
		 printArray(a) ;
		 System.out.println();
		
	}
	
	  private static void printArray(Comparable[] anArray) {
          StringBuilder sb = new StringBuilder();
          for (int i = 0; i < anArray.length; i++) {
             if (i > 0) {
                sb.append(", ");
             }
             sb.append(anArray[i]);
          }
          System.out.println(sb.toString());
       }


}
