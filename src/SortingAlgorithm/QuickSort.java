package SortingAlgorithm;

public class QuickSort {
	
	public int partition(int listToSort [], int low, int high) {
		int pivot = listToSort[low];
		int l = low;
		int h = high;
		while(l<h) {
			while(listToSort[l]<=pivot && l<h) {
				l++;
			}
			while(listToSort[h]>pivot) {
				h--;
			}
			
			if(l<h) {
				swap(listToSort, l , h);
			}
		}
		swap(listToSort, low, h);
		return h;		
	}
	
	public void quickSort( int [] listToSort , int low, int high) {
		if(low>=high) {
			return;
		}
		
		int pivotIndex = partition(listToSort, low, high);
		quickSort(listToSort, low, pivotIndex-1);
		quickSort(listToSort, pivotIndex+1, high);
		
	}
	
	public void swap( int listToSort [] , int low , int high) {
		int temp = listToSort[low];
		listToSort[low] = listToSort[high];
		listToSort[high] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SelectionSort ss = new SelectionSort();
		QuickSort qs = new QuickSort();
		int [] listSort = ss.listToSort();
		int low = 0;
		int high = listSort.length - 1 ;
		long startTime = System.currentTimeMillis();
		qs.quickSort(listSort, low , high);		
		System.out.println("Time Taken to Sort :: "+(System.currentTimeMillis()-startTime)+"ms");
		ss.printList(listSort);

	}

}
