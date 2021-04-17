package SortingAlgorithm;

public class BubbleSort {
	public int[] bubbleSort(int [] listSort) {
		
		for(int i = 0 ; i< listSort.length ; i++) {
			boolean swapped = false;			
			for(int j = ((listSort.length)-1);j>i;j--) {				
				if(listSort[j]<listSort[j-1]) {
					swap(listSort, j, j-1);
					swapped = true;
				}
			}			
			if(!swapped) {
				break;
			}
		}		
		return listSort;
	}
	
	public void swap(int [] listSort , int j , int elementBeforej) {
		int temp = listSort[j];
		listSort[j] = listSort[elementBeforej];
		listSort[elementBeforej] = temp;
	}	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SelectionSort ss = new SelectionSort();
		BubbleSort bus = new BubbleSort();
		int [] listSort = ss.listToSort();
		long startTime = System.currentTimeMillis();
		listSort = bus.bubbleSort(listSort);
		System.out.println("Time Taken to Sort :: "+(System.currentTimeMillis()-startTime)+"ms");
		ss.printList(listSort);

	}

}
