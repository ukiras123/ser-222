import java.util.Arrays;

public class ArrayStack<T> implements StackADT<T>, StepIterable<T> {

	private final static int DEFAULT_CAPACITY = 100;
	
	private int top;
	private T[] stack;
	
	public ArrayStack() {
		this(DEFAULT_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayStack(int initialCapacity) {
		top = 0;
		stack = (T[])(new Object[initialCapacity]);
	}
	
	@Override
	public void push(T element) {
		if (size() == stack.length) {
			expandCapacity();
		}
		
		stack[top] = element;
		top++;		
	}

	public void expandCapacity() {
		stack = Arrays.copyOf(stack,  stack.length * 2);
	}
	
	@Override
	public T pop() {
		if (isEmpty()) {
			throw new EmptyCollectionException("stack");
		}
		
		top--;
		T result = stack[top];
		stack[top] = null;
		
		return result;
	}

	@Override
	public T peek() {
		if (isEmpty()) {
			throw new EmptyCollectionException("stack");
		}
		
		return stack[top-1];
	}

	@Override
	public boolean isEmpty() {
		return top == 0;
	}

	@Override
	public int size() {
		return top;
	}
	
	public StepIterator<T> iterator() {
		return new ReverseArrayIterator();
	}
	
	private class ReverseArrayIterator implements StepIterator<T> {
		int i = top;
		int step = 1;
		
		@Override
		public void setStep(int s) {
			step = s;
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}

}
