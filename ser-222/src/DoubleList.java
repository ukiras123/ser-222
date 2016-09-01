import java.util.Iterator;

public class DoubleList<T> implements ListADT<T>, Iterable<T> {

	@Override
	public Iterator<T> iterator() {
		Iterator<T> iter = this.iterator();
		return this.iterator();
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
		T next;
		
		@Override
		public boolean hasNext() {
			return next != null;
		}

		@Override
		public T next() {
			return next;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}

	}

}
