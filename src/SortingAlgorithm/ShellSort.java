package SortingAlgorithm;

public class ShellSort {
	public void shellSort(int [] listToSort) {
		int increment = listToSort.length/2;
		while (increment >= 1) {
			
			for(int startIndex = 0 ; startIndex < increment ; startIndex++) {
				
				insertionSort(listToSort, startIndex, increment);
			}
			increment = increment/2;
		}			
	}
	
	public void insertionSort(int [] listToSort , int startIndex, int increment) {
		
		
		for (int i = startIndex ; i < listToSort.length ; i = i+increment) {
			for(int j = Math.min( i+increment, listToSort.length - 1);
					j - increment >= 0; 
					j = j - increment) {
				
				if(listToSort[j] < listToSort[j-increment]) {
					swap(listToSort, j, j-increment);
					
				}
				else {
					break;
				}
			}
		}
	}
	
	public void swap(int [] listToSort , int j , int lastJthElement) {
		int temp = listToSort[j];
		listToSort[j] = listToSort[lastJthElement];
		listToSort[lastJthElement] = temp;
	}

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		SelectionSort ss = new SelectionSort();
		ShellSort shs = new ShellSort();
		int [] listToSort = ss.listToSort();
		long startTime = System.currentTimeMillis();
		shs.shellSort(listToSort);
		System.out.println("Time Taken to Sort :: "+(System.currentTimeMillis()-startTime)+"ms");
		ss.printList(listToSort);

	}

}
