/**
 * This program provides an implementation of the Deque interface
 * and demonstrates it.
 * 
 * @author Robert Beerman, Acuna
 * @version 1.0
 */
import java.util.NoSuchElementException;
    
public class BeermanDeque<Item> implements Deque<Item> {
	private int count;
	private Node<Item> first, last;
			
	public BeermanDeque() {
		count = 0;
		first = last = null;
	}
	
	public void enqueueFront(Item element) {
		Node<Item> newNode = new Node<>(element);
		
		if (isEmpty()) {
			first = newNode;
			last = newNode;
		} else {
			first.setNext(newNode);
			newNode.setPrev(first);
			first = newNode;
		}
		
		count++;
	}
	
	public void enqueueBack(Item element) {
		Node<Item> newNode = new Node<>(element);
		
		if (isEmpty()) {
			first = newNode;
			last = newNode;
		} else {
			last.setPrev(newNode);
			newNode.setNext(last);
			last = newNode;
		}
		
		count++;
	}
	
	public Item dequeueFront() throws NoSuchElementException {
		Item element;
		
		if (isEmpty()) {
			throw new NoSuchElementException("Deque is empty");
		} else {
			element = first.getElement();
			first = first.getPrev();
			first.setNext(null);
		}
		
		count--;
		
		return element;
	}
	
	public Item dequeueBack() throws NoSuchElementException {
		Item element;
		
		if (isEmpty()) {
			throw new NoSuchElementException("Deque is empty");
		} else {
			element = last.getElement();
			last = last.getNext();
			last.setPrev(null);
		}
		
		count--;
		
		return element;
	}
	
	public Item first() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException("Deque is empty");
		}
		
		return first.getElement();
	}
	
	public Item last() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException("Deque is empty");
		}
		
		return last.getElement();
	}
	
	public boolean isEmpty() {
		return count == 0;
	}
	
	public int size() {
		return count;
	}
	
	@Override
	public String toString() {
		String result = "";
		if (isEmpty()) {
			return "empty";
		} else {
			Node<Item> node = last;
			result += node.getElement() + " ";
			
			while (node.getNext() != null) {
				result += node.getNext().getElement() + " ";
				node = node.getNext();
			}
		}
		
		return result;
	}
	
    /**
     * Program entry point for deque. 
     * @param args command line arguments
     */    
    public static void main(String[] args) {
        BeermanDeque<Integer> deque = new BeermanDeque<>();

        //standard queue behavior
        deque.enqueueBack(3);
        deque.enqueueBack(7);
        deque.enqueueBack(4);
        deque.dequeueFront();
        deque.enqueueBack(9);
        deque.enqueueBack(8);
        deque.dequeueFront();
        System.out.println("size: " + deque.size());
        System.out.println("contents:\n" + deque.toString());   

        //deque features
        System.out.println(deque.dequeueFront());        
        deque.enqueueFront(1);
        deque.enqueueFront(11);                         
        deque.enqueueFront(3);                 
        deque.enqueueFront(5);         
        System.out.println(deque.dequeueBack());
        System.out.println(deque.dequeueBack());        
        System.out.println(deque.last());                
        deque.dequeueFront();
        deque.dequeueFront();        
        System.out.println(deque.first());        
        System.out.println("size: " + deque.size());
        System.out.println("contents:\n" + deque.toString());            
    }
} 