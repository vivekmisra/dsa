/*Copyright (c) Apr 27, 2017 CareerMonk Publications and others.
 * E-Mail           	: info@careermonk.com 
 * Creation Date    	: 2015-01-10 06:15:46 
 * Last modification	: 2006-05-31 
               by		: Narasimha Karumanchi 
 * File Name			: CheckDuuplicates.java
 * Book Title			: Data Structures And Algorithms Made In Java
 * Warranty         	: This software is provided "as is" without any 
 * 							warranty; without even the implied warranty of 
 * 							merchantability or fitness for a particular purpose. 
 * 
 */

package chapter11searching;

public class CheckFrequency {

	public CheckFrequency() {
		// TODO Auto-generated constructor stub
	}

	static int[]  checkfrequency(int[] a) {
		int counter = 0;
		int maxCounter = 0;
		int tempElement = a[0];
		int[] result = new int[2];
		for (int i = 0; i < a.length; i++) {
			counter =0;
			for (int j = 0; j < a.length; j++) {// loop thru index over
													// right
				if (a[i] == a[j]) {// if value a[j] is less than value
									// a[min],than a[j] is new min
					counter++;
					tempElement = a[i];
				}
			}
			if (counter > maxCounter) {
				maxCounter = counter;
				result[0] = tempElement;
				
			}
		}
		result[1] = maxCounter;
		return result;
	}
	static void printRepeating(int arr[], int size) {
		int i;
		System.out.println("The repeating elements are : ");

		for (i = 0; i < size; i++) {
			
			if (arr[Math.abs(arr[i])] >= 0){
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
			}else{
				System.out.print(Math.abs(arr[i]) + " ");
			}
		}
		 System.out.println(" ");
			
	}
	

	/* Driver program to test the above function */
	public static void main(String[] args) {

		 int a[] = {4, 2, 4, 2, 2, 2, 1};		
		int arr_size = a.length;
		printRepeating(a, arr_size);		
		 int a1[] = {4, 2, 4, 2, 2, 2, 1};		
		 System.out.println("a1:");
		 printArray(a1);
		 int[] result1= checkfrequency(a1);
		 System.out.println(result1[0] +" is repeated " + result1[1] + " times.");
		
	}

	public static void printArray(int[] a) {
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
