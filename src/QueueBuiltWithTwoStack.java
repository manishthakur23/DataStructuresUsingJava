
public class QueueBuiltWithTwoStack<T> {
	
	private Stack<T> forwardStack = new Stack();
	private Stack<T> backwardStack = new Stack();
	
	public boolean isFull() {
		return forwardStack.isFull() || backwardStack.isFull();
	}
	
	public boolean isEmpty() {
		return forwardStack.isEmpty() && backwardStack.isEmpty();
	}
	
	public void enqueue(T data) throws QueueOverflowException{
		if(isFull()) {
			throw new QueueOverflowException();
		}
		try {
		if(forwardStack.isEmpty()) {
			if(!backwardStack.isEmpty()) {
				while(!backwardStack.isEmpty()) {					
						forwardStack.push(backwardStack.pop());					
				}
			}
		}
		forwardStack.push(data);
		System.out.println("Element pushed");
		} catch (StackOverFlowException | StackUnderFlowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	public T dequeue() throws QueueUnderFlowException{
		T data = null;
		if(isEmpty()) {
			throw new QueueUnderFlowException();
		}
		try {
		if(backwardStack.isEmpty()) {
			if(!forwardStack.isEmpty()) {
				while(!forwardStack.isEmpty()) {					
					backwardStack.push(forwardStack.pop());					
				}
			}
		}
		data = backwardStack.pop();
		System.out.println("Element pop :: " + data);
		return data;
		} catch (StackOverFlowException | StackUnderFlowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;		
	}
	
	
	

	public static void main(String[] args) throws QueueUnderFlowException {
		// TODO Auto-generated method stub
		QueueBuiltWithTwoStack<Integer> queStack = new QueueBuiltWithTwoStack<Integer>();
		try {
			queStack.enqueue(new Integer(10));
			queStack.enqueue(new Integer(20));
			queStack.enqueue(new Integer(30));
			queStack.enqueue(new Integer(40));
			System.out.println(queStack.dequeue());
			System.out.println(queStack.dequeue());
			
			
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

class QueueOverflowException extends Exception{
	
}

class QueueUnderFlowException extends Exception{
	
}