import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestArrayUnorderedList {
	ArrayUnorderedList<Integer> testList;
	ArrayUnorderedList<Integer> loadedList;
	
	@Before
	public void setUp() throws Exception {
		testList = new ArrayUnorderedList<>();
		loadedList = new ArrayUnorderedList<>();
		
		for (Integer i = 0; i < 100; i++) {
			loadedList.addToRear(i);
		}
	}

	@After
	public void tearDown() throws Exception {
		testList = null;
	}

	@Test
	public void testAddToFront() {
		testList.addToFront(3);
		assertEquals("", new Integer(3), testList.first());
		assertEquals("", new Integer(3), testList.last());
		assertEquals("", 1, testList.size());
		assertEquals("", 1, testList.modCount);
		
		testList.addToFront(7);
		assertEquals("", new Integer(7), testList.first());
		assertEquals("", new Integer(3), testList.last());
		assertEquals("", 2, testList.size());
		assertEquals("", 2, testList.modCount);
		
		testList.addToFront(20);
		assertEquals("", new Integer(20), testList.first());
		assertEquals("", new Integer(3), testList.last());
		assertEquals("", 3, testList.size());
		assertEquals("", 3, testList.modCount);
		
		assertTrue(testList.contains(7));
		
		loadedList.addToFront(25);
		assertEquals("", 101, loadedList.size());
		
		loadedList.addToFront(50);
		assertEquals("", 102, loadedList.size());
	}

	@Test
	public void testAddToRear() {
		testList.addToRear(3);
		assertEquals("", new Integer(3), testList.first());
		assertEquals("", new Integer(3), testList.last());
		assertEquals("", 1, testList.size());
		assertEquals("", 1, testList.modCount);
		
		testList.addToRear(10);
		assertEquals("", new Integer(3), testList.first());
		assertEquals("", new Integer(10), testList.last());
		assertEquals("", 2, testList.size());
		assertEquals("", 2, testList.modCount);
		
		testList.addToRear(30);
		assertEquals("", new Integer(3), testList.first());
		assertEquals("", new Integer(30), testList.last());
		assertEquals("", 3, testList.size());
		assertEquals("", 3, testList.modCount);
		
		assertTrue(testList.contains(10));
		
		loadedList.addToRear(25);
		assertEquals("", 101, loadedList.size());
		
		loadedList.addToRear(50);
		assertEquals("", 102, loadedList.size());
	}

	@Test
	public void testRemoveLast() {
		testList.addToFront(new Integer(1));
		assertEquals("", new Integer(1), testList.removeLast());
		assertEquals("", 0, testList.size());
		assertEquals("", 2, testList.modCount);
		assertTrue(testList.isEmpty());
		
		testList.addToFront(new Integer(1));
		testList.addToFront(new Integer(2));
		assertEquals("", new Integer(1), testList.removeLast());
		assertEquals("", 1, testList.size());
		assertEquals("", 5, testList.modCount);
		assertFalse(testList.isEmpty());
		
		testList.addToFront(new Integer(3));
		testList.addToFront(new Integer(4));
		assertEquals("", new Integer(2), testList.removeLast());
		assertEquals("", new Integer(4), testList.first());
		assertEquals("", new Integer(3), testList.last());
		assertEquals("", 2, testList.size());
		assertEquals("", 8, testList.modCount);
		assertFalse(testList.isEmpty());
	}

	@Test
	public void testRemoveFirst() {
		testList.addToFront(new Integer(1));
		assertEquals("", new Integer(1), testList.removeFirst());
		assertEquals("", 0, testList.size());
		assertEquals("", 2, testList.modCount);
		assertTrue(testList.isEmpty());
		
		testList.addToFront(new Integer(1));
		testList.addToFront(new Integer(2));
		assertEquals("", new Integer(2), testList.removeFirst());
		assertEquals("", 1, testList.size());
		assertEquals("", 5, testList.modCount);
		assertFalse(testList.isEmpty());
		
		testList.addToFront(new Integer(3));
		testList.addToFront(new Integer(4));
		assertEquals("", new Integer(4), testList.removeFirst());
		assertEquals("", new Integer(3), testList.first());
		assertEquals("", new Integer(1), testList.last());
		assertEquals("", 2, testList.size());
		assertEquals("", 8, testList.modCount);
		assertFalse(testList.isEmpty());
	}

}
