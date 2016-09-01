import unit4.Node;

public class DoubleNode<T> {
	private T elem;
	Node<T> next;
	Node<T> prev;
	
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
	
	public Node<T> getNext() {
		return next;
	}
	
	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	public Node<T> getPrev() {
		return prev;
	}
	
	public void setPrev(Node<T> prev) {
		this.prev = prev;
	}
}
