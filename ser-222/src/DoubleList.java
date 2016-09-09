import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class DoubleList<T> implements ListADT<T>, Iterable<T> {
	protected int count;
	protected int modCount;
	protected DoubleNode<T> first, last;
	
	public DoubleList() {
		count = 0;
		modCount = 0;
		first = last = null;
	}

	@Override
	public Iterator<T> iterator() {
		return new DoubleIterator();
	}
		
	@Override
	public T removeFirst() {
		if (isEmpty()) {
			throw new EmptyCollectionException("DoubleList");
		}
		
		T element = first.getElement();
		
		if (size() > 1) {
			first = first.getNext();
			first.setPrev(null);
		} else {
			first = last = null;
		}
		
		count--;
		modCount++;
		
		return element;
	}

	@Override
	public T removeLast() {
		if (isEmpty()) {
			throw new EmptyCollectionException("DoubleList");
		}
		
		T element = last.getElement();
		
		if (size() > 1) {
			last = last.getPrev();
			last.setNext(null);
		} else {
			first = last = null;
		}
		
		count--;
		modCount++;
		
		return element;
	}

	@Override
	public T remove(T element) {
		if (isEmpty()) {
			throw new EmptyCollectionException("DoubleList");
		}
		
		if (!(element instanceof Comparable)) {
			throw new NonComparableElementException("Element not of type Comparable");
		}
		
		@SuppressWarnings("unchecked")
		Comparable<T> comparableElement = (Comparable<T>)element;
		Iterator<T> iter = iterator();
		DoubleNode<T> current = first;
		boolean found = false;
		boolean isFirst = true;
		
		while (iter.hasNext()) {
			T currElem = iter.next();
			if (comparableElement.compareTo(currElem) == 0) {
				found = true;
				
				if (size() == 1) {
					first = last = null;
				} else {
					if (isFirst) {
						first = first.getNext();
						first.setPrev(null);
					} else {
						if(current.equals(last)) {
							last = current.getPrev();
							last.setNext(null);
						} else {
							current.getPrev().setNext(current.getNext());
							current.getNext().setPrev(current.getPrev());
						}
					}
				}
				
				break;
			}
			
			isFirst = false;
			current = current.getNext();
		}
		
		if (!found) {
			throw new ElementNotFoundException("DoubleList");
		}
		
		count--;
		modCount++;
		
		return element;
	}

	@Override
	public T first() {
		if (isEmpty()) {
			throw new EmptyCollectionException("DoubleList");
		}
		
		return first.getElement();
	}

	@Override
	public T last() {
		if (isEmpty()) {
			throw new EmptyCollectionException("DoubleList");
		}
		
		return last.getElement();
	}

	@Override
	public boolean contains(T target) {
		if (isEmpty()) {
			throw new EmptyCollectionException("DoubleList");
		}
		
		if (!(target instanceof Comparable)) {
			throw new NonComparableElementException("Element not of type Comparable");
		}
		
		@SuppressWarnings("unchecked")
		Comparable<T> comparableElement = (Comparable<T>)target;
		Iterator<T> iter = iterator();
		boolean found = false;
		
		while (iter.hasNext()) {
			if (comparableElement.compareTo(iter.next()) == 0) {
				found = true;
				break;
			}
		}
		
		return found;
	}

	@Override
	public boolean isEmpty() {
		return count == 0;
	}

	@Override
	public int size() {
		return count;
	}
	
	@Override
	public String toString() {
		if (isEmpty()) {
			return "empty";
		}
		
		String result = "";
		Iterator<T> iter = iterator();
		boolean first = true;
		
		while (iter.hasNext()) {
			if (!first) {
				result += " ";
			}
			
			first = false;
			T elem = iter.next();
			result += elem;
		}
		
		return result;
	}
	
	private class DoubleIterator implements Iterator<T> {
		private int iteratorModCount;
		private DoubleNode<T> current;
		
		public DoubleIterator() {
			current = first;
			iteratorModCount = modCount;
		}
		
		@Override
		public boolean hasNext() {
			if (iteratorModCount != modCount) {
				throw new ConcurrentModificationException();
			}
			return current != null;
		}

		@Override
		public T next() {
			if (!hasNext()) {
				throw new EmptyCollectionException("DoubleIterator");
			}
			
			T result = current.getElement();
			current = current.getNext();
			return result;
		}
		
		@Override
		public void remove() {
			//throw new UnsupportedOperationException();	
		}
	}

}
