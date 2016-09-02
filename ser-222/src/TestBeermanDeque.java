import static org.junit.Assert.*;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestBeermanDeque {
	BeermanDeque<Integer> emptyIntDeque;
	BeermanDeque<String> stringDeque;
	BeermanDeque<Integer> nonEmptyDeque;
	BeermanDeque<Integer> singularDeque;

	@Before
	public void setUp() throws Exception {
		emptyIntDeque = new BeermanDeque<>();
		stringDeque = new BeermanDeque<>();
		nonEmptyDeque = new BeermanDeque<>();
		
		nonEmptyDeque.enqueueBack(1);
		nonEmptyDeque.enqueueBack(2);
		nonEmptyDeque.enqueueBack(3);
		
		singularDeque = new BeermanDeque<>();
		singularDeque.enqueueBack(5);
	}

	@After
	public void tearDown() throws Exception {
		emptyIntDeque = null;
		stringDeque = null;
	}

	@Test(expected=NoSuchElementException.class)
	public void testNoSuchElementExceptionDequeueFront() {
		//dequeueFront from empty deque
		emptyIntDeque.dequeueFront();
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testNoSuchElementExceptionFirst() {
		//call first() on empty deque
		int testInt = emptyIntDeque.first();
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testNoSuchElementExceptionLast() {
		//call last() on empty deque
		int testInt = emptyIntDeque.last();
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testNoSuchElementExceptionDequeueBack() {
		//dequeueBack from empty deque
		emptyIntDeque.dequeueBack();
	}
	
	@Test
	public void testSize() {
		//call size() on empty deque
		assertEquals("Should return 0", 0, emptyIntDeque.size());
		//call size() on deque of size = 1
		emptyIntDeque.enqueueBack(6);
		assertEquals("Should return 1", 1, emptyIntDeque.size());
		//call size() on deque of size = 3
		emptyIntDeque.enqueueBack(15);
		emptyIntDeque.enqueueBack(42);
		assertEquals("Should return 3", 3, emptyIntDeque.size());

	}
	
	@Test
	public void testIsEmpty() {
		//call isEmpty() on empty deque
		assertTrue("Empty deque should return true", emptyIntDeque.isEmpty());
		//call isEmpty() on non-empty deque
		emptyIntDeque.enqueueBack(50);
		assertFalse("Non-empty deque should return false", emptyIntDeque.isEmpty());
	}
	
	@Test
	public void testEnqueueBack() {
		//enqueueBack to empty deque
		emptyIntDeque.enqueueBack(10);
		//call first() and last() on deque of size = 1
		assertEquals("Should return 10", 10, (int)emptyIntDeque.first());
		assertEquals("Should return 10", 10, (int)emptyIntDeque.last());
		//enqueueBack to deque with 1 element
		emptyIntDeque.enqueueBack(3);
		//call toString() on deque of size > 1
		assertEquals("Should return 3 10", "3 10", emptyIntDeque.toString());
		//enqueueBack to deque with >1 element
		emptyIntDeque.enqueueBack(57);
		assertEquals("Should return 57 3 10", "57 3 10", emptyIntDeque.toString());
	}
	
	@Test
	public void testEnqueueFront() {
		//enqueueFront to empty deque
		emptyIntDeque.enqueueFront(5);
		//call first() and last() on deque of size = 1
		assertEquals("Should return 5", 5, (int)emptyIntDeque.first());
		assertEquals("Should return 5", 5, (int)emptyIntDeque.last());
		//enqueueFront to deque with 1 element
		emptyIntDeque.enqueueFront(13);
		assertEquals("Should return 5 13", "5 13", emptyIntDeque.toString());
		//enqueueFront to deque with >1 element
		emptyIntDeque.enqueueFront(20);
		assertEquals("Should return 5 13 20", "5 13 20", emptyIntDeque.toString());
	}
	
	@Test
	public void testDequeueFront() {
		//dequeueFront from deque with >1 element
		assertEquals("Should return 1", 1, (int)nonEmptyDeque.dequeueFront());
		assertEquals("Should return 2", 2, (int)nonEmptyDeque.dequeueFront());
		//dequeueFront from deque with 1 element
		assertEquals("Should return 3", 3, (int)nonEmptyDeque.dequeueFront());
	}
	
	@Test
	public void testDequeueBack() {
		//dequeueBack from deque with >1 element
		assertEquals("Should return 3", 3, (int)nonEmptyDeque.dequeueBack());
		assertEquals("Should return 2", 2, (int)nonEmptyDeque.dequeueBack());
		//dequeueBack from deque with 1 element
		assertEquals("Should return 1", 1, (int)nonEmptyDeque.dequeueBack());
		
	}
	
	@Test
	public void testFirst() {
		//call first() on deque of size > 1
		assertEquals("Should return 1", 1, (int)nonEmptyDeque.first());
	}
	
	@Test
	public void testLast() {
		//call last() on deque of size > 1
		assertEquals("Should return 3", 3, (int)nonEmptyDeque.last());
	}
	
	@Test
	public void testToStringOnEmpty() {
		//call toString() on empty deque
		assertEquals("Should return 'empty'", "empty", emptyIntDeque.toString());
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testDequeueBackAfterDequeueBack() {
		int elem = singularDeque.dequeueBack();
		//dequeueBack from deque with 1 element, then dequeueBack from the deque
		elem = singularDeque.dequeueBack();
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testDequeueFrontAfterDequeueFront() {
		int elem = singularDeque.dequeueFront();
		//dequeueFront from deque with 1 element, then dequeueFront from the deque
		elem = singularDeque.dequeueFront();
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testDequeueFrontAfterDequeuBack() {
		int elem = singularDeque.dequeueBack();
		//dequeueBack from deque with 1 element, then dequeueFront from the deque
		elem = singularDeque.dequeueFront();
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testDequeueBackAfterDequeueFront() {
		int elem = singularDeque.dequeueFront();
		//dequeueFront from deque with 1 element, then dequeueBack from the deque
		elem = singularDeque.dequeueBack();
	}

	@Test
	public void testStringDeque() {
		//test with other element types, such as String
		stringDeque.enqueueBack("Howdy");
		//call toString() on deque of size = 1
		assertEquals("Should return 'Howdy'", "Howdy", stringDeque.toString());
		assertEquals("Should return 'Howdy'", "Howdy", stringDeque.dequeueBack());
	}
}
