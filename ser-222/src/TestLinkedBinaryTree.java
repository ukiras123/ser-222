import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestLinkedBinaryTree {
	LinkedBinaryTree<Integer> lbtEmpty;
	LinkedBinaryTree<Integer> lbtRoot;
	LinkedBinaryTree<Integer> lbtLeft;
	LinkedBinaryTree<Integer> lbtRight;
	LinkedBinaryTree<Integer> lbtAll;
	LinkedBinaryTree<Integer> lbt5;
	
	@Before
	public void setUp() throws Exception {
		lbtEmpty = new LinkedBinaryTree<>();
		lbtRoot = new LinkedBinaryTree<>(5);
		lbtLeft = new LinkedBinaryTree<>(10);
		lbtRight = new LinkedBinaryTree<>(15);
		lbtAll = new LinkedBinaryTree<>(3, lbtLeft, lbtRight);
	}

	@After
	public void tearDown() throws Exception {
		lbtEmpty = null;
		lbtRoot = null;
		lbtLeft = null;
		lbtRight = null;
		lbtAll = null;
	}

	@Test
	public void testGetRootElement() {
		assertEquals("", new Integer(5), lbtRoot.getRootElement());
		assertEquals("", new Integer(3), lbtAll.getRootElement());
	}

	@Test
	public void testGetRootNode() {
		assertEquals("", new Integer(5), lbtRoot.getRootNode().getElement());
	}

	@Test
	public void testGetLeft() {
		assertEquals("", new Integer(10), lbtAll.getLeft().getRootElement());
	}

	@Test
	public void testGetRight() {
		assertEquals("", new Integer(15), lbtAll.getRight().getRootElement());
	}

	@Test
	public void testSize() {
		assertEquals("", 0, lbtEmpty.size());
		assertEquals("", 3, lbtAll.size());
		assertEquals("", 1, lbtLeft.size());
	}

	@Test
	public void testGetHeight() {
		assertEquals("", 0, lbtEmpty.getHeight());
		assertEquals("", 2, lbtAll.getHeight());
		assertEquals("", 1, lbtRoot.getHeight());
		
		LinkedBinaryTree<Integer> lbtBig = new LinkedBinaryTree<>(20, lbtAll, lbtRoot);
		assertEquals("", 3, lbtBig.getHeight());
	}
	
	@Test
	public void testToString() {
		assertEquals("", "5", lbtRoot.toString());
		assertEquals("", "10 3 15", lbtAll.toString());
		
		LinkedBinaryTree<Integer> lbtBig = new LinkedBinaryTree<>(20, lbtAll, lbtRoot);
		assertEquals("", "10 3 15 20 5", lbtBig.toString());
	}

}
