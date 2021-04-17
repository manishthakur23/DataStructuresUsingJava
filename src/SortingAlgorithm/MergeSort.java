package SortingAlgorithm;

public class MergeSort {
	
	public void mergeSort(int [] listToSort) {
		if(listToSort.length == 1) {
			
			return;
		}
		
		int midIndex = (listToSort.length/2) + (listToSort.length % 2);
		int [] firstHalf = new  int[midIndex];
		int [] secondHalf = new int[listToSort.length - midIndex];
		split(listToSort, firstHalf, secondHalf);
		mergeSort(firstHalf);
		mergeSort(secondHalf);
		merge(listToSort, firstHalf, secondHalf);
		
	}
	
	public void split(int [] listToSplit , int [] firstHalf , int [] secondHalf ) {
		
		int index = 0;
		int secondHalfFirstIndex = firstHalf.length;
		for(int element : listToSplit) {
			
			if(index < secondHalfFirstIndex) {
				
				firstHalf[index] = listToSplit[index];
			}else {
				
				secondHalf[index-secondHalfFirstIndex]=listToSplit[index];
			}
			index ++;
		}
	}
	
	public void merge(int [] listToMerge , int [] firstHalf , int [] secondHalf) {
		int index = 0;
		int firstHalfIndex = 0;
		int secondHalfIndex = 0;
		while( firstHalfIndex < firstHalf.length && secondHalfIndex < secondHalf.length) {
			
			if(firstHalf[firstHalfIndex]<secondHalf[secondHalfIndex]) {
				listToMerge[index] = firstHalf[firstHalfIndex];
				firstHalfIndex++;
			}else if(secondHalfIndex < secondHalf.length) {
				listToMerge[index] = secondHalf[secondHalfIndex];
				secondHalfIndex++;
			}
			index++;
		}
		
		if(firstHalfIndex < firstHalf.length) {
			while(index < listToMerge.length) {
				listToMerge[index ++] = firstHalf[firstHalfIndex ++];
			}		
		}
		
		if(secondHalfIndex < secondHalf.length) {
			while(index < listToMerge.length) {
				listToMerge[index ++] = secondHalf[secondHalfIndex ++];
			}		
		}
				
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SelectionSort ss = new SelectionSort();
		MergeSort ms = new MergeSort();
		int [] listToSort = ss.listToSort();
		long startTime = System.currentTimeMillis();
		ms.mergeSort(listToSort);
		System.out.println("Time Taken to Sort :: "+(System.currentTimeMillis()-startTime)+"ms");
		ss.printList(listToSort);

	}

}
