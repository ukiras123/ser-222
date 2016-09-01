package unit4;

public class Node<Item> {
	private Item elem;
	Node<Item> next;
	Node<Item> prev;
	
	public Node(Item elem) {
		this.elem = elem;
		next = null;
		prev = null;
	}
	
	public Item getElement() {
		return elem;
	}
	
	public void setElement(Item elem) {
		this.elem = elem;
	}
	
	public Node<Item> getNext() {
		return next;
	}
	
	public void setNext(Node<Item> next) {
		this.next = next;
	}
	
	public Node<Item> getPrev() {
		return prev;
	}
	
	public void setPrev(Node<Item> prev) {
		this.prev = prev;
	}
}
