import java.util.Iterator;

public class DoubleOrderedList<T> extends DoubleList<T> implements OrderedListADT<T> {
	
	
	public DoubleOrderedList() {
		count = 0;
		modCount = 0;
		first = last = null;
	}
	
	@Override
	public void add(T element) {
		if (!(element instanceof Comparable)) {
			throw new NonComparableElementException("Element not of type Comparable");
		}
		
		DoubleNode<T> newNode = new DoubleNode<>(element);
		@SuppressWarnings("unchecked")
		Comparable<T> comparableElement = (Comparable<T>)element;
		
		if (isEmpty()) {
			first = newNode;
			last = newNode;
		} else if (size() == 1) {
			if (comparableElement.compareTo(first.getElement()) <= 0) {
				first = newNode;
				first.setNext(last);
				last.setPrev(first);
			} else {
				newNode.setPrev(first);
				first.setNext(newNode);
				last = newNode;
			}
		} else {
			Iterator<T> iter = iterator();
			DoubleNode<T> current = first;
			boolean isFirst = true;
						
			while (iter.hasNext()) {
				T elem = iter.next();
				
				if (comparableElement.compareTo(elem) <= 0) {
					if (isFirst) {
						newNode.setNext(first);
						first.setPrev(newNode);
						first = newNode;
					} else {
						DoubleNode<T> tmp = current;
						newNode.setPrev(tmp.getPrev());
						newNode.setNext(tmp);
						tmp.getPrev().setNext(newNode);
						tmp.setPrev(newNode);
					}
					
					break;
				}
				
				if(!iter.hasNext()) {
					newNode.setPrev(last);
					last.setNext(newNode);
					last = newNode;
				}
				
				current = current.getNext();
				isFirst = false;
			}
		}
		
		count++;
		modCount++;		
	}

}
