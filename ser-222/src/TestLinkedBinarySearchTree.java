import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestLinkedBinarySearchTree {
	LinkedBinarySearchTree lbst;
	LinkedBinarySearchTree emptyTree;
	LinkedBinarySearchTree singleTree;

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
		
		singleTree = new LinkedBinarySearchTree<>(10);
	}

	@After
	public void tearDown() throws Exception {
		emptyTree = null;
		lbst = null;
		singleTree = null;
	}

	@Test(expected=EmptyCollectionException.class)
	public void testMinEmptyException() {
		emptyTree.findMin();
	}
	
	@Test(expected=EmptyCollectionException.class)
	public void testMaxEmptyException() {
		emptyTree.findMax();
	}
	
	@Test(expected=EmptyCollectionException.class)
	public void testRemoveMinEmptyException() {
		emptyTree.removeMin();
	}
	
	@Test(expected=EmptyCollectionException.class)
	public void testRemoveMaxEmptyException() {
		emptyTree.removeMax();
	}
	
	@Test
	public void testRemoveMin() {
		System.out.println("lbst before removeMin: " + lbst.toString());
		assertEquals("", 1, lbst.removeMin());
		System.out.println("After removeMin: " + lbst.toString());
		assertEquals("", 3, lbst.removeMin());
		System.out.println("After removeMin: " + lbst.toString());
		assertEquals("", 5, lbst.removeMin());
		System.out.println("After removeMin: " + lbst.toString());
		assertEquals("", 17, lbst.removeMin());
		System.out.println("After removeMin: " + lbst.toString());
		assertEquals("", 20, lbst.removeMin());
		System.out.println("After removeMin: " + lbst.toString() + "\n");
		
		assertEquals("", 10, singleTree.removeMin());
	}

	@Test
	public void testRemoveMax() {
		System.out.println("lbst before removeMax: " + lbst.toString());
		assertEquals("", 65, lbst.removeMax());
		System.out.println("lbst after removeMax: " + lbst.toString());
		assertEquals("", 20, lbst.removeMax());
		System.out.println("lbst after removeMax: " + lbst.toString() + "\n");
		
		assertEquals("", 10, singleTree.removeMax());
	}

	@Test
	public void testFindMin() {
		assertEquals("", 1, lbst.findMin());
		assertEquals("", 10, singleTree.findMin());
	}

	@Test
	public void testFindMax() {
		assertEquals("", 65, lbst.findMax());
		assertEquals("", 10, singleTree.findMax());
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
		
		assertTrue(singleTree.contains(10));
	}

}
