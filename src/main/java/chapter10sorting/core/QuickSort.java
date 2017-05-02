/*Copyright (c) Apr 24, 2017 CareerMonk Publications and others.
 * E-Mail           	: info@careermonk.com 
 * Creation Date    	: 2015-01-10 06:15:46 
 * Last modification	: 2006-05-31 
               by		: Narasimha Karumanchi 
 * File Name			: QuickSort.java
 * Book Title			: Data Structures And Algorithms Made In Java
 * Warranty         	: This software is provided "as is" without any 
 * 							warranty; without even the implied warranty of 
 * 							merchantability or fitness for a particular purpose. 
 * 
 */

package chapter10sorting.core;

public class QuickSort {

	static Integer[] a = new Integer[] { 11, 2, 1, 6, 8, 5, 3, 4 };

	public QuickSort() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sort(a);
		printArray(a);
	}

	public static void sort(Integer[] inputArr) {

		if (a == null || a.length == 0) {
			return;
		}
		int length = a.length;
		quickSort(0, length - 1);
	}

	private static void quickSort(int start, int end) {
		// If both cursor scanned the complete array quicksort exits
		if (start >= end) {
			return;
		}
		int partitionIndex = partition(a, start, end);
		quickSort(start, partitionIndex - 1);
		quickSort(partitionIndex + 1, end);

	}

	public static int partition(Integer a[], int leftCursor, int rightCursor) {
		int pivot = a[leftCursor];
		while (leftCursor < rightCursor) {
			System.out.println("*** start*****");
			printArray(a, leftCursor, rightCursor, pivot);

			while (a[leftCursor] < pivot) {
				leftCursor++;
				System.out.println("*** a[f] < pivot*****");
				printArray(a, leftCursor, rightCursor, pivot);
			}
			while (a[rightCursor] > pivot) {
				rightCursor--;
				System.out.println("*** a[rightCursor] > pivot*****");
				printArray(a, leftCursor, rightCursor, pivot);
			}
			System.out.println("Before swapping...");
			printArray(a, leftCursor, rightCursor, pivot);
			swap(a, leftCursor, rightCursor);
			System.out.println("After swapping...");
			printArray(a, leftCursor, rightCursor, pivot);
			System.out.println("*** end*****");
		}
		System.out.println("***returning partitionIndex for this quicksort=" + leftCursor + "*****");
		return leftCursor;
	}

	// This method is used to swap the values between the two given index
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

	public static void printArray(Integer[] a, int leftCursor, int rightCursor, int pivot) {
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
		if (leftCursor >= 0) {
			System.out.print("leftCursor=" + leftCursor + " ,a[" + leftCursor + "]=" + a[leftCursor]);
		}
		if (rightCursor >= 0) {
			System.out.print(" ,rightCursor=" + rightCursor + " ,a[" + rightCursor + "]=" + a[rightCursor]);
		}
		System.out.println(" ,pivot=" + pivot);
	}
}
