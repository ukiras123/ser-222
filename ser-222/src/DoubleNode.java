public class DoubleNode<T> {
	private T elem;
	DoubleNode<T> next;
	DoubleNode<T> prev;
	
	public DoubleNode(T elem) {
		this.elem = elem;
		next = null;
		prev = null;
	}
	
	public T getElement() {
		return elem;
	}
	
	public void setElement(T elem) {
		this.elem = elem;
	}
	
	public DoubleNode<T> getNext() {
		return next;
	}
	
	public void setNext(DoubleNode<T> next) {
		this.next = next;
	}
	
	public DoubleNode<T> getPrev() {
		return prev;
	}
	
	public void setPrev(DoubleNode<T> prev) {
		this.prev = prev;
	}
}
