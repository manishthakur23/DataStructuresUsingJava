package SortingAlgorithm;

public class InsertionSort {
	
	public void insertionSort(int [] listToSort) {
		for(int i = 0 ; i < listToSort.length-1 ; i++) {
			for(int j = i + 1;j>0;j--) {
				if(listToSort[j] < listToSort[j-1]) {
					swap(listToSort, j, j-1);
				}else {
					break;
				}
			}
		}
	}
	
	public void swap(int [] listToSort , int j , int elementBeforej) {
		int temp = listToSort[elementBeforej];
		listToSort[elementBeforej] = listToSort[j];
		listToSort[j] = temp;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SelectionSort ss = new SelectionSort();
		InsertionSort is = new InsertionSort();
		int [] listToSort = ss.listToSort();
		long startTime = System.currentTimeMillis();
		is.insertionSort(listToSort);
		System.out.println("Time Taken to Sort :: "+(System.currentTimeMillis()-startTime)+"ms");
		ss.printList(listToSort);

	}

}
