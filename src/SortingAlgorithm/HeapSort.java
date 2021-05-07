package SortingAlgorithm;

public class HeapSort {
	
	protected int defaultLength = 40;
	protected int [] array = null;
	
	HeapSort(int [] arry){
		array = arry;
	}
	
	
	public int getLeftChildIndex( int index , int endIndex) {
		int leftChildIndex = 2*index +1;
		if(leftChildIndex > endIndex) {
			return -1;
		}
		return leftChildIndex;
	}
	
	public int getRightChildIndex( int index , int endIndex) {
		int rightChildIndex = 2*index +2;
		if(rightChildIndex > endIndex) {
			return -1;
		}
		return rightChildIndex;
	}
	
	public int getParentIndex(int index, int endIndex) {
		
		if(index < 0 || index > endIndex) {
			return -1;
		}
		return (index - 1)/2;
	}
	
	public void swap(int index1 ,int index2 ) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;		
	}
	
	public void percolateDown(int index , int endIndex) {
		int leftChildIndex = getLeftChildIndex(index, endIndex);
		int rightChildIndex = getRightChildIndex(index, endIndex);
		
		if(leftChildIndex != -1 && array[leftChildIndex]> array[index]) {
			swap(leftChildIndex, index );
			percolateDown(leftChildIndex, endIndex);
		}
		
		if(rightChildIndex != -1 && array[rightChildIndex] > array[index]) {
			swap(rightChildIndex, index );
			percolateDown(rightChildIndex, endIndex);
		}
	}
	
	public void heapify(int endIndex) {
		int index = getParentIndex(endIndex, endIndex);
		
		while(index >= 0) {
			percolateDown(index, endIndex);
			index --;
		}
	}
	
	public void heapSort(int endIndex) {
		heapify(endIndex);
		while(endIndex > 0 ) {
			swap(0, endIndex);
			endIndex --;
			percolateDown(0, endIndex);
			
		}
		
	}
	
	public void print() {
		for (int element : array) {
			System.out.print(element+" ,");
		}	
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array = {1,2,3,4,5,6,7,34,23,11,35,67};
		HeapSort hp = new HeapSort(array);
		hp.heapSort(array.length-1);
		hp.print();
		

		
		
	}

}
