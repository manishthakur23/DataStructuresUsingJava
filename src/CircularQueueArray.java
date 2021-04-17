import java.lang.reflect.Array;

public class CircularQueueArray {
	private static final int SPECIAL_EMPTY_VALUE = -1;
	private static int MAX_SIZE = 3;
	private int [] elements ;
	
	private int headIndex = SPECIAL_EMPTY_VALUE;
	private int tailIndex = SPECIAL_EMPTY_VALUE;
	
	public CircularQueueArray() {
		//elements  =  (T[])Array.newInstance(clazz, MAX_SIZE);
		elements = new int[MAX_SIZE];
	}
	
	public boolean isEmpty() {
		return headIndex == SPECIAL_EMPTY_VALUE;		
	}
	
	public boolean isFull() {
		int nextIndex = (tailIndex +1)%elements.length;
		return nextIndex == headIndex;
	}
	
	public void enqueue(int data) throws Exception{
		if(isFull()) {
			throw new Exception();
		}
		tailIndex = (tailIndex + 1) % elements.length;
		elements[tailIndex]=data;
		System.out.println("Data enqueued");
		
		if( headIndex == SPECIAL_EMPTY_VALUE) {
			headIndex = tailIndex;
		}
	}
	
	public int dequeue() throws Exception {
		if(isEmpty()) {
			throw new Exception();
		}
		
		int data = elements[headIndex];
		if(headIndex == tailIndex) {
			headIndex = SPECIAL_EMPTY_VALUE;
		}else {
			headIndex = (headIndex + 1) % elements.length;
		}
		System.out.println("Element Dequeued");
		return data;
	}
	
	public static void main(String [] args) {
		CircularQueueArray cq = new CircularQueueArray();
		try {
			cq.enqueue(10);
			cq.enqueue(20);
			cq.enqueue(30);
			System.out.println("Element dequeued data :: "+cq.dequeue());
			cq.enqueue(40);
			System.out.println("Element dequeued data :: "+cq.dequeue());
			System.out.println("Element dequeued data :: "+cq.dequeue());
			System.out.println("Element dequeued data :: "+cq.dequeue());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
