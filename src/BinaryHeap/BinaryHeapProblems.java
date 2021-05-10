package BinaryHeap;

public class BinaryHeapProblems {
	
	//To find maxmimum in Heap
	public int getMaximumElement( MinimumHeap<Integer> minHeap) {
		int endIndex = minHeap.getCount() - 1;
		int parentIndex = minHeap.getParentIndex(endIndex);
		int firstElementToCheck = parentIndex + 1;
		int maxElement = minHeap.getElementAtIndex(firstElementToCheck);		
		for(int i = firstElementToCheck ; i<minHeap.getCount() ; i++ ) {
			if(maxElement<minHeap.getElementAtIndex(i)) {
				maxElement = minHeap.getElementAtIndex(i);
			}
		}
		return maxElement;
	}
	
	//To first k largest element in array
	public void kLargestElement(int [] randomNumberArray , int k ) throws Exception{
		MinimumHeap<Integer> minHeap1 = new MinimumHeap<>(Integer.class, k );
		for (int element : randomNumberArray) {
			if(minHeap1.isEmpty()) {
				
				minHeap1.insert(element);
			}else if(!minHeap1.isFull() || minHeap1.getHighPriorityElement()<element) {				
				if(minHeap1.isFull()){					
					minHeap1.removeHighPriorityElement();
				}
				minHeap1.insert(element);
			}
			
		}
		System.out.print("Maximum "+k+" Elements :: ");
		minHeap1.printHeap();
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		MinimumHeap<Integer> minHeap =  new MinimumHeap<Integer>(Integer.class);
		minHeap.insert(new Integer(10));
		minHeap.insert(new Integer(7));
		minHeap.insert(new Integer(12));
		minHeap.insert(new Integer(3));
		minHeap.insert(new Integer(4));
		minHeap.insert(new Integer(5));
		minHeap.insert(new Integer(9));
		minHeap.insert(new Integer(19));
		
		BinaryHeapProblems bhp = new BinaryHeapProblems();
		
		System.out.println("Maximum Element :: "+bhp.getMaximumElement(minHeap));
		
		int [] array = {1,2,3,4,5,6,23,21,22,44,56,67,121,222};
		bhp.kLargestElement(array, 5);
		
		

	}

}
