import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestLinkedBinarySearchTree {
	LinkedBinarySearchTree lbst;
	LinkedBinarySearchTree emptyTree;

	@Before
	public void setUp() throws Exception {
		emptyTree = new LinkedBinarySearchTree<>();
		lbst = new LinkedBinarySearchTree<>();
		lbst.addElement(5);
		lbst.addElement(1);
		lbst.addElement(20);
		lbst.addElement(17);
		lbst.addElement(3);
		lbst.addElement(65);
	}

	@After
	public void tearDown() throws Exception {
		emptyTree = null;
		lbst = null;
	}

	@Test(expected=EmptyCollectionException.class)
	public void testMinEmptyException() {
		System.out.print(emptyTree.findMin());
	}
	
	@Test(expected=EmptyCollectionException.class)
	public void testMaxEmptyException() {
		System.out.print(emptyTree.findMax());
	}
	
	@Test(expected=EmptyCollectionException.class)
	public void testRemoveMinEmptyException() {
		System.out.print(emptyTree.removeMin());
	}
	
	@Test(expected=EmptyCollectionException.class)
	public void testRemoveMaxEmptyException() {
		System.out.print(emptyTree.removeMax());
	}
	
	@Test
	public void testRemoveMin() {
		assertEquals("", 1, lbst.removeMin());
		System.out.println("After removeMin: " + lbst.toString());
	}

	@Test
	public void testRemoveMax() {
		assertEquals("", 65, lbst.removeMax());
		System.out.println("After removeMax: " + lbst.toString());
	}

	@Test
	public void testFindMin() {
		assertEquals("", 1, lbst.findMin());
	}

	@Test
	public void testFindMax() {
		assertEquals("", 65, lbst.findMax());
	}
	
	@Test
	public void testFind() {
		assertEquals("", 17, lbst.find(17));
		assertEquals("", 1, lbst.find(1));
		assertEquals("", 65, lbst.find(65));
	}
	
	@Test
	public void testContains() {
		assertTrue(lbst.contains(5));
		assertTrue(lbst.contains(1));
		assertTrue(lbst.contains(20));
		assertTrue(lbst.contains(17));
		assertTrue(lbst.contains(3));
		assertTrue(lbst.contains(65));
		assertFalse(lbst.contains(100));
	}

}
