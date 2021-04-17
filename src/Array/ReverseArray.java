package Array;

import SortingAlgorithm.SelectionSort;

public class ReverseArray {
	
	public void reverseArray(int [] arrayToReverse) {
		int min = 0;
		int max = arrayToReverse.length -1;
		while(min<= max) {
			int temp = arrayToReverse[min];
			arrayToReverse[min] = arrayToReverse[max];
			arrayToReverse[max] = temp;
			min ++;
			max --;
		}
	}
	public void printList(int [] listSort) {
		for(int element : listSort) {
			System.out.print(element+",");
		}
		System.out.println(" ");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseArray rs = new ReverseArray();
		int [] sortedList = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		System.out.println("Array before reversing ::");
		rs.printList(sortedList);		
		rs.reverseArray(sortedList);
		System.out.println("Array after reversing ::");
		rs.printList(sortedList);		

	}

}
