import java.util.Iterator;

public class DoubleList<T> implements ListADT<T>, Iterable<T> {
	private int count;
	private DoubleNode<T> first, last;
	
	public DoubleList() {
		count = 0;
		first = last = null;
	}

	@Override
	public Iterator<T> iterator() {
		return null;
	}
	
	public DoubleIterator<T> doubleIterator() {
		DoubleIterator<T> iter = new DoubleIterator<T>();
		return iter;
	}
	
	@Override
	public T removeFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T removeLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T remove(T element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T first() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T last() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(T target) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private class DoubleIterator<T> implements Iterator<T> {
		private T next;
		private T prev;
		
		@Override
		public boolean hasNext() {
			return next != null;
		}
		
		public boolean hasPrev() {
			return prev != null;
		}

		@Override
		public T next() {
			return next;
		}
		
		public T prev() {
			return prev;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("");
			
		}

	}

}
