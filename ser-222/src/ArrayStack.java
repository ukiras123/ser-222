import java.util.Arrays;
import java.util.NoSuchElementException;

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
	
	@Override
	public String toString() {
		if (isEmpty()) {
			return "empty";
		}
		
		String result = "";
		
		for (int i = size()-1; i >= 0; i--) {
			result += stack[i] + " ";
		}
		
		return result;
	}
	
	public StepIterator<T> iterator() {
		return new ReverseArrayIterator();
	}
	
	private class ReverseArrayIterator implements StepIterator<T> {
		int i;
		int step;
		
		public ReverseArrayIterator() {
			i = top;
			step = 1;
		}
		
		@Override
		public void setStep(int s) {
			step = s;
		}

		@Override
		public boolean hasNext() {
			if (i == top && i > 0) {
				return true;
			} else if (i - step >= 0) {
				return true;
			}
			
			return false;
		}

		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			
			if (i == top) {
				return stack[--i];
			}
			
			i -= step;
			
			return stack[i];
		}

		@Override
		public void remove() {
			if (i == top) {
				throw new IllegalStateException("Cannot call remove() before calling next()");
			}
			
			top--;

			for (int j = i; j < top; j++) {
				stack[j] = stack[j+1];
			}
			stack[top] = null;
		}
	}
}
