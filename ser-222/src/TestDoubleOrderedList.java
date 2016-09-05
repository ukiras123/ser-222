import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestDoubleOrderedList {
	DoubleOrderedList<Integer> intList;
	DoubleOrderedList<String> stringList;
	DoubleOrderedList<DoubleNode<Integer>> doubleNodeList;
	
	@Before
	public void setUp() throws Exception {
		intList = new DoubleOrderedList<>();
		stringList = new DoubleOrderedList<>();
		doubleNodeList = new DoubleOrderedList<DoubleNode<Integer>>();
	}

	@After
	public void tearDown() throws Exception {
		intList = null;
		stringList = null;
		doubleNodeList = null;
	}

	@Test(expected=EmptyCollectionException.class)
	public void testFirstOnEmpty() {
		//call first() on empty list
		int x = intList.first();
	}

	@Test(expected=EmptyCollectionException.class)
	public void testRemoveFirstFromEmpty() {
		//removeFirst() from empty list
		intList.removeFirst();
	}
	
	@Test(expected=EmptyCollectionException.class)
	public void testRemoveLastFromEmpty() {
		//removeLast() from empty list
		intList.removeLast();
	}
	
	@Test(expected=EmptyCollectionException.class)
	public void testRemoveFromEmpty() {
		//remove() from empty list
		intList.remove(5);
	}
	
	@Test(expected=EmptyCollectionException.class)
	public void testContainsOnEmpty() {
		//call contains() on empty list
		boolean x = intList.contains(10);
	}
	
	@Test(expected=NonComparableElementException.class)
	public void testAddNonComparable() {
		//attempt to add() noncomparable element
		doubleNodeList.add(new DoubleNode<Integer>(4));
	}
	
	@Test(expected=ElementNotFoundException.class)
	public void testRemoveUnmatchedFrom1() {
		//remove() non-matching element from list with 1 element
		intList.add(1);
		intList.remove(3);
	}
	
	@Test(expected=ElementNotFoundException.class)
	public void testRemoveUnmatchedFrom2() {
		//remove() non-matching element from list with > 1 element
		intList.add(10);
		intList.add(5);
		intList.remove(3);
	}
	
	@Test
	public void testSize() {
		//call size() on empty list
		assertEquals("Should be 0", 0, intList.size());
		intList.add(17);
		//call size() on non-empty list
		assertEquals("Should be 1", 1, intList.size());
		intList.add(25);
		intList.add(30);
		//call size() on non-empty list
		assertEquals("Should be 3", 3, intList.size());
		intList.removeFirst();
		intList.removeFirst();
		intList.removeFirst();
		//call size() on empty list that was previously non-empty
		assertEquals("Should be 0", 0, intList.size());
	}
	
	@Test
	public void testIsEmpty() {
		//call isEmpty() on empty list
		assertTrue(intList.isEmpty());
		intList.add(10);
		//call isEmpty() on non-empty list
		assertFalse(intList.isEmpty());
	}
	
	@Test
	public void testFirst() {
		intList.add(12);
		//call first() on list with 1 element
		int elem = intList.first();
		assertEquals("Should return 12", 12, elem);
		intList.add(5);
		intList.add(7);
		//call first() on list with > 1 element
		elem = intList.first();
		assertEquals("Should return 5", 5, elem);
	}
	
	@Test
	public void testLast() {
		intList.add(12);
		//call last() on list with 1 element
		int elem = intList.last();
		assertEquals("Should return 12", 12, elem);
		intList.add(5);
		intList.add(7);
		//call last() on list with > 1 element
		elem = intList.last();
		assertEquals("Should return 12", 12, elem);
	}
	
	@Test
	public void testToString() {
		//call toString() on empty list
		assertEquals("Should return 'empty'", "empty", intList.toString());
		intList.add(12);
		//call toString() on list with 1 element
		assertEquals("Should return '12'", "12", intList.toString());
		intList.add(3);
		intList.add(20);
		//call toString() on list with > 1 element
		assertEquals("Should return '3 12 20'", "3 12 20", intList.toString());
	}
	
	@Test
	public void testAdd() {
		//add() element to empty list
		intList.add(42);
		int first = intList.first();
		int last = intList.last();
		assertEquals("First should be 42", 42, first);
		assertEquals("Last should be 42", 42, last);
		//add() element to list with one element
		intList.add(53);
		first = intList.first();
		last = intList.last();
		assertEquals("First should be 42", 42, first);
		assertEquals("Last should be 53", 53, last);
		//add() element to middle  of list with > 1 element
		intList.add(50);
		first = intList.first();
		last = intList.last();
		assertEquals("First should be 42", 42, first);
		assertEquals("Last should be 53", 53, last);
		assertEquals("List should be '42 50 53'", "42 50 53", intList.toString());
		//add() element that should be new first
		intList.add(3);
		first = intList.first();
		last = intList.last();
		assertEquals("First should be 3", 3, first);
		assertEquals("Last should be 53", 53, last);
		assertEquals("List should be '3 42 50 53'", "3 42 50 53", intList.toString());
		//add() element that should be new last
		intList.add(60);
		first = intList.first();
		last = intList.last();
		assertEquals("First should be 3", 3, first);
		assertEquals("Last should be 60", 60, last);
		assertEquals("List should be '3 42 50 53 60'", "3 42 50 53 60", intList.toString());
	}
	
	@Test
	public void testRemoveFirst() {
		intList.add(5);
		intList.add(20);
		intList.add(30);
		//removeFirst() from list with > 1 element
		int elem = intList.removeFirst();
		int first = intList.first();
		int last = intList.last();
		assertEquals("Should return 5", 5, elem);
		assertEquals("First should be 20", 20, first);
		assertEquals("Last should be 30", 30, last);
		assertEquals("List should be '20 30'", "20 30", intList.toString());
		intList.removeFirst();
		//removeFirst() from list with 1 element
		elem = intList.removeFirst();
		assertEquals("Should return 30", 30, elem);
		assertTrue(intList.isEmpty());
	}
	
	@Test
	public void testRemoveLast() {
		intList.add(5);
		intList.add(20);
		intList.add(30);
		//removeLast() from list with > 1 element
		int elem = intList.removeLast();
		int first = intList.first();
		int last = intList.last();
		assertEquals("Should return 30", 30, elem);
		assertEquals("First should be 5", 5, first);
		assertEquals("Last should be 20", 20, last);
		assertEquals("List should be '5 20'", "5 20", intList.toString());
		intList.removeLast();
		//removeLast() from list with 1 element
		elem = intList.removeLast();
		assertEquals("Should return 5", 5, elem);
		assertTrue(intList.isEmpty());
	}
	
	@Test
	public void testRemove() {
		intList.add(1);
		intList.add(2);
		intList.add(3);
		intList.add(4);
		//remove() existing element from inner position of list with > 1 element
		int elem = intList.remove(3);
		int first = intList.first();
		int last = intList.last();
		assertEquals("Should return 3", 3, elem);
		assertEquals("First should be 1", 1, first);
		assertEquals("Last should be 4", 4, last);
		assertEquals("List should be '1 2 4'", "1 2 4", intList.toString());
		//remove() existing element from first position of list with > 1 element
		elem = intList.remove(1);
		first = intList.first();
		last = intList.last();
		assertEquals("Should return 1", 1, elem);
		assertEquals("First should be 2", 2, first);
		assertEquals("Last should be 4", 4, last);
		assertEquals("List should be '2 4'", "2 4", intList.toString());
		//remove() existing element from last postion of list with > 1 element
		elem = intList.remove(4);
		first = intList.first();
		last = intList.last();
		assertEquals("Should return 4", 4, elem);
		assertEquals("First should be 2", 2, first);
		assertEquals("Last should be 2", 2, last);
		assertEquals("List should be '2'", "2", intList.toString());
		//remove() existing element from list with 1 element
		elem = intList.remove(2);
		assertEquals("Should return 2", 2, elem);
		assertTrue(intList.isEmpty());
	}
	
	@Test
	public void testContains() {
		intList.add(19);
		intList.add(40);
		intList.add(56);
		//call matching contains() on list with > 1 element
		assertTrue(intList.contains(40));
		assertTrue(intList.contains(19));
		assertTrue(intList.contains(56));
		//call non-matching contains() on list with > 1 element
		assertFalse(intList.contains(3));
		intList.remove(19);
		intList.remove(56);
		//call matching contains() on list with 1 element
		assertTrue(intList.contains(40));
		//call non-matching contains() on list with 1 element
		assertFalse(intList.contains(19));
		assertFalse(intList.contains(56));
	}
	
	@Test
	public void testStringList() {
		stringList.add("one");
		stringList.add("two");
		stringList.add("three");
		//Test contains() on String list (matching element)
		assertTrue(stringList.contains("two"));
		//Test String list ordering
		assertEquals("Should print 'one three two'", "one three two", stringList.toString());
		//Test contains() on String list (non-matching element)
		assertFalse(stringList.contains("Open the pod bay doors, Hal."));
		//Test remove() on String list (matching element)
		String elem = stringList.remove("three");
		assertEquals("Should return 'three'", "three", elem);
		assertEquals("Should print 'one two'", "one two", stringList.toString());
	}
	
	@Test(expected=ElementNotFoundException.class)
	public void testStringUnmatchedRemove() {
		//Test remove() on String list (non-matching element)
		stringList.add("one");
		stringList.add("two");
		String elem = stringList.remove("three");
	}
}
