package BinaryHeap;

public class MinimumHeap<T extends Comparable> extends Heap<T>{
	

	public MinimumHeap(Class<T> clazz) {
		super(clazz);
		// TODO Auto-generated constructor stub
	}

	public MinimumHeap(Class<T> clazz, int size) {
		super(clazz, size);
	}
	
	protected void siftDown(int index) {
		int leftChidIndex = getLeftChildIndex(index);
		int rightChildIndex = getRightChildIndex(index);
		int smallerIndex = -1;
		if(leftChidIndex != -1 && rightChildIndex != -1) {
			smallerIndex = getElementAtIndex(leftChidIndex).compareTo(getElementAtIndex(rightChildIndex))<0?leftChidIndex:rightChildIndex;
		}else if(leftChidIndex != -1) {
			smallerIndex = leftChidIndex;
		}else if(rightChildIndex != -1) {
			smallerIndex = rightChildIndex;
		}
		
		if(smallerIndex == -1) {
			return;
		}
		
		if(getElementAtIndex(smallerIndex).compareTo(getElementAtIndex(index))<0) {
			swap(smallerIndex, index);
			siftDown(index);
		}
	}
	
	protected void siftUp(int index) {
		int parentIndex = getParentIndex(index);
		
		if(parentIndex != -1 && getElementAtIndex(index).compareTo(getElementAtIndex(parentIndex))<0) {
			swap(parentIndex, index);
			siftUp(parentIndex);
		}		
	}
	
	public void insert(T value )throws Exception {
		
		if(count >= array.length) {
			throw new Exception();
		}	
		array[count] = value;
		siftUp(count);
		count++;
		
	}
	
	public T getHighPriorityElement() throws Exception {
		if(count == 0) {
			throw new Exception();
		}
		
		return array[0];
	}
	
	public T removeHighPriorityElement() throws Exception {
		T min = getHighPriorityElement();
		
		array[0]=array[count-1];
		siftDown(0);
		
		return min;
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
		
		System.out.println("Removed highest priority element ::"+minHeap.removeHighPriorityElement());

	}

}
