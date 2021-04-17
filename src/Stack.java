
public class Stack<T> {
	
	private int MAX_SIZE = 10;
	private Element<T> top;
	private int size = 0;
	
	public void push(T data) throws StackOverFlowException{
		if(size == MAX_SIZE) {
			throw new StackOverFlowException();
		}
		Element<T> elem = new Element<T>(data, top);
		top = elem;
		size ++;
		System.out.println("Pushed element");
	}
	
	public T pop() throws StackUnderFlowException{
		if(size == 0) {
			throw new StackUnderFlowException();
		}
		T data = top.getData();
		top = top.getNext();
		size --;
		return data;
	}
	
	public T peek() throws StackUnderFlowException{
		if(size == 0) {
			throw new StackUnderFlowException();
		}
		return top.getData();
	}
	
	public boolean isFull() {
		if(size == MAX_SIZE) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Stack<Integer> stck = new Stack<Integer>();
		stck.push(new Integer(10));
		stck.push(new Integer(20));
		stck.push(new Integer(30));
		System.out.println("Top is element :: "+stck.peek());
		stck.pop();
		System.out.println("Top is element :: "+stck.peek());
		
		
	}

}

class Element<T>{
	
	private T data;
	private Element next;
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public Element getNext() {
		return next;
	}
	public void setNext(Element next) {
		this.next = next;
	}
	public Element(T data, Element next) {
		super();
		this.data = data;
		this.next = next;
	}
}

class StackOverFlowException extends Exception{
	
}

class StackUnderFlowException extends Exception{
	
}
