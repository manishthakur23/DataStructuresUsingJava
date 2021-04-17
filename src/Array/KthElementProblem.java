package Array;

import SortingAlgorithm.QuickSort;
import SortingAlgorithm.SelectionSort;

public class KthElementProblem {
	
	public int kthelement( int [] arry , int k) {
		QuickSort qs = new QuickSort();
		int low = 0;
		int high = arry.length -1;
		qs.quickSort(arry, low, high);
	 return arry[k-1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		SelectionSort sc = new SelectionSort();
		KthElementProblem elemnt = new KthElementProblem();
		int arry [] = sc.listToSort();
		int k = 1000;
		int element = elemnt.kthelement(arry, k);
		System.out.println( " Element at "+k+"th position is "+element);
		

	}

}
