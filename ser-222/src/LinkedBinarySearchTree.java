/**
 * LinkedBinarySearchTree implements the BinarySearchTreeADT interface 
 * with links.
 * 
 * @author Lewis and Chase
 * @version 4.0
 */
public class LinkedBinarySearchTree<T> extends LinkedBinaryTree<T>
									implements BinarySearchTreeADT<T>
{
    /**
     * Creates an empty binary search tree.
     */
    public LinkedBinarySearchTree() 
    {
        super();
    }
    
    /**
     * Creates a binary search with the specified element as its root.
     *
     * @param element the element that will be the root of the new binary
     *        search tree
     */
    public LinkedBinarySearchTree(T element) 
    {
        super(element);
        
        if (!(element instanceof Comparable))
            throw new NonComparableElementException("LinkedBinarySearchTree");
    }
    
    /**
     * Adds the specified object to the binary search tree in the
     * appropriate position according to its natural order.  Note that
     * equal elements are added to the right.
     *
     * @param element the element to be added to the binary search tree
     */
    @Override
    public void addElement(T element) 
    {
        if (!(element instanceof Comparable))
            throw new NonComparableElementException("LinkedBinarySearchTree");

        Comparable<T> comparableElement = (Comparable<T>)element;

        if (isEmpty())
            root = new BinaryTreeNode<T>(element);
        else 
        {
            if (comparableElement.compareTo(root.getElement()) < 0)
            {
                if (root.getLeft() == null) 
                    this.getRootNode().setLeft(new BinaryTreeNode<T>(element));
                else
                    addElement(element, root.getLeft());
            }
            else
            {
                if (root.getRight() == null) 
                    this.getRootNode().setRight(new BinaryTreeNode<T>(element));
                else
                    addElement(element, root.getRight());
            }
        }
        
        size++;
        modCount++;
    }
    
    /**
     * Adds the specified object to the binary search tree in the
     * appropriate position according to its natural order.  Note that
     * equal elements are added to the right.
     *
     * @param element the element to be added to the binary search tree
     */
    private void addElement(T element, BinaryTreeNode<T> node) 
    {
        Comparable<T> comparableElement = (Comparable<T>)element;
        
        if (comparableElement.compareTo(node.getElement()) < 0)
        {
            if (node.getLeft() == null) 
                node.setLeft(new BinaryTreeNode<T>(element));
            else
                addElement(element, node.getLeft());
        }
        else
        {
            if (node.getRight() == null) 
                node.setRight(new BinaryTreeNode<T>(element));
            else
                addElement(element, node.getRight());
        }
    }
        
        
    /**
     * Removes the first element that matches the specified target
     * element from the binary search tree and returns a reference to
     * it.  Throws a ElementNotFoundException if the specified target
     * element is not found in the binary search tree.
     *
     * @param targetElement the element being sought in the binary search tree
     * @throws ElementNotFoundException if the target element is not found
     */
    @Override
    public T removeElement(T targetElement)
                                  throws ElementNotFoundException 
    {
        T result = null;

        if (isEmpty())
            throw new ElementNotFoundException("LinkedBinarySearchTree");
        else
        {
            BinaryTreeNode<T> parent = null;
            if (((Comparable<T>)targetElement).equals(root.element)) 
            {
                result =  root.element;
                BinaryTreeNode<T> temp = replacement(root);
                if (temp == null)
                    root = null;
                else 
                {
                    root.element = temp.element;
                    root.setRight(temp.right);
                    root.setLeft(temp.left);
                }

                size--;
                modCount--;
            }
            else 
            {                
                parent = root;
                if (((Comparable)targetElement).compareTo(root.element) < 0)
                    result = removeElement(targetElement, root.getLeft(), parent);
                else
                    result = removeElement(targetElement, root.getRight(), parent);
            }
        }
        
        return result;
    }
                
    /**
     * Removes the first element that matches the specified target
     * element from the binary search tree and returns a reference to
     * it.  Throws a ElementNotFoundException if the specified target
     * element is not found in the binary search tree.
     *
     * @param targetElement the element being sought in the binary search tree
     * @param node the node from which to search
     * @param parent the parent of the node from which to search
     * @throws ElementNotFoundException if the target element is not found
     */
    private T removeElement(T targetElement, BinaryTreeNode<T> node, BinaryTreeNode<T> parent)
    throws ElementNotFoundException 
    {
        T result = null;
        
        if (node == null)
            throw new ElementNotFoundException("LinkedBinarySearchTree");
        else
        {
            if (((Comparable<T>)targetElement).equals(node.element)) 
            {
                result =  node.element;
                BinaryTreeNode<T> temp = replacement(node);
                if (parent.right == node)
                    parent.right = temp;
                else 
                    parent.left = temp;

                size--;
                modCount--;
            }
            else 
            {                
                parent = node;
                if (((Comparable)targetElement).compareTo(node.element) < 0)
                    result = removeElement(targetElement, node.getLeft(), parent);
                else
                    result = removeElement(targetElement, node.getRight(), parent);
            }
        }
        
        return result;
    }
    
    /**
     * Returns a reference to a node that will replace the one
     * specified for removal.  In the case where the removed node has 
     * two children, the inorder successor is used as its replacement.
     *
     * @param node the node to be removed
     * @return a reference to the replacing node
     */
    private BinaryTreeNode<T> replacement(BinaryTreeNode<T> node) 
    {
        BinaryTreeNode<T> result = null;
        
        if ((node.left == null) && (node.right == null))
            result = null;
        
        else if ((node.left != null) && (node.right == null))
            result = node.left;
        
        else if ((node.left == null) && (node.right != null))
            result = node.right;
        
        else
        {
            BinaryTreeNode<T> current = node.right;
            BinaryTreeNode<T> parent = node;
            
            while (current.left != null)
            {
                parent = current;
                current = current.left;
            }
            
            current.left = node.left;
            if (node.right != current)
            {
                parent.left = current.right;
                current.right = node.right;
            }
            
            result = current;
        }
        
        return result;
    }
    
    /**
     * Removes elements that match the specified target element from 
     * the binary search tree. Throws a ElementNotFoundException if 
     * the specified target element is not found in this tree.
     *
     * @param targetElement the element being sought in the binary search tree
     * @throws ElementNotFoundException if the target element is not found
     */
    @Override
    public void removeAllOccurrences(T targetElement)
                   throws ElementNotFoundException 
    {
        removeElement(targetElement);
        
        try
        {
            while (contains((T)targetElement))
                removeElement(targetElement);
        }
        
        catch (Exception ElementNotFoundException)
        {
        }
    }

    /**
     * Removes the node with the least value from the binary search
     * tree and returns a reference to its element.  Throws an
     * EmptyCollectionException if this tree is empty. 
     *
     * @return a reference to the node with the least value
     * @throws EmptyCollectionException if the tree is empty
     */
    @Override
    public T removeMin() throws EmptyCollectionException 
    {
        T result = null;

        if (isEmpty())
            throw new EmptyCollectionException("LinkedBinarySearchTree");
        else 
        {
            if (root.left == null) 
            {
                result = root.element;
                root = root.right;
            }
            else 
            {
                BinaryTreeNode<T> parent = root;
                BinaryTreeNode<T> current = root.left;
                while (current.left != null) 
                {
                    parent = current;
                    current = current.left;
                }
                result =  current.element;
                parent.left = current.right;
            }

            size--;
            modCount--;
        }
 
        return result;
    }

    /**
     * Removes the node with the highest value from the binary
     * search tree and returns a reference to its element.  Throws an
     * EmptyCollectionException if this tree is empty. 
     *
     * @return a reference to the node with the highest value
     * @throws EmptyCollectionException if the tree is empty
     */
    @Override
    public T removeMax() throws EmptyCollectionException 
    {
    	T result = null;

        if (isEmpty())
            throw new EmptyCollectionException("LinkedBinarySearchTree");
        else 
        {
            if (root.right == null) 
            {
                result = root.element;
                root = root.left;
            }
            else 
            {
                BinaryTreeNode<T> parent = root;
                BinaryTreeNode<T> current = root.right;
                
                while (current.right != null) 
                {
                    parent = current;
                    current = current.right;
                }
                
                result =  current.element;
                parent.right = current.left;
            }

            size--;
            modCount--;
        }
 
        return result;
    }

    /**
     * Returns the element with the least value in the binary search
     * tree. It does not remove the node from the binary search tree. 
     * Throws an EmptyCollectionException if this tree is empty.
     *
     * @return the element with the least value
     * @throws EmptyCollectionException if the tree is empty
     */
    @Override
    public T findMin() throws EmptyCollectionException {
        T result = null;
        
        if (isEmpty()) {
        	throw new EmptyCollectionException("LinkedBinarySearchTree");
        } else {
        	if (root.left == null) 
            {
                result = root.element;
            } else {
                BinaryTreeNode<T> parent = root;
                BinaryTreeNode<T> current = root.left;
                
                while (current.left != null) {
                	parent = current;
                    current = current.left;
                }

                result = current.element;
            }
        }

        return result;
    }

    /**
     * Returns the element with the highest value in the binary
     * search tree.  It does not remove the node from the binary
     * search tree.  Throws an EmptyCollectionException if this 
     * tree is empty.
     *
     * @return the element with the highest value
     * @throws EmptyCollectionException if the tree is empty
     */
    @Override
    public T findMax() throws EmptyCollectionException {
    	T result = null;
        
        if (isEmpty()) {
        	throw new EmptyCollectionException("LinkedBinarySearchTree");
        } else {
        	if (root.right == null) 
            {
                result = root.element;
            } else {
                BinaryTreeNode<T> parent = root;
                BinaryTreeNode<T> current = root.right;
                
                while (current.right != null) {
                	parent = current;
                    current = current.right;
                }

                result = current.element;
            }
        }

        return result;
    }

    @Override
    public T find(T targetElement) throws ElementNotFoundException {
    	if (!(targetElement instanceof Comparable))
            throw new NonComparableElementException("LinkedBinarySearchTree");

    	BinaryTreeNode<T> current = findNode(targetElement, root);
    	
    	if (current == null) {
    		throw new ElementNotFoundException("LinkedBinarySearchTree");
    	}
    	
    	return (current.getElement());
    }
    
    @Override
    public boolean contains(T targetElement) {
    	boolean result = false;
    	
    	try {
	    	if (find(targetElement) != null) {
	    		result = true;
	    	}
    	} catch(ElementNotFoundException e) {
    		result = false;
    	}
    	
    	return result;
    }
    
    /**
     * Returns the left subtree of the root of this tree.
     *
     * @return a link to the left subtree fo the tree
     */
    /*@Override
    public LinkedBinarySearchTree<T> getLeft()
    { 
        // TODO: May need to implement.
    }*/
    
    /**
     * Returns the right subtree of the root of this tree.
     *
     * @return a link to the right subtree of the tree
     */
    /*@Override
    public LinkedBinarySearchTree<T> getRight()
    {
        // TODO: May need to implement.
    }*/
    
    /**
     * Returns a reference to the specified target element if it is
     * found in this tree.
     *
     * @param targetElement the element being sought in the tree
     * @param next the tree node to begin searching on
     */
    private BinaryTreeNode<T> findNode(T targetElement, BinaryTreeNode<T> next) {
        if (next == null) {
        	return null;
        }
        
        if (!(targetElement instanceof Comparable)) {
        	throw new NonComparableElementException("LinkedBinarySearchTree");
        }
        
        Comparable<T> comparableElement = (Comparable<T>)targetElement;
        
        if (comparableElement.compareTo(next.getElement()) == 0) {
        	return next;
        }
        
        BinaryTreeNode<T> temp;
        
        if (comparableElement.compareTo(next.getElement()) < 0) {
        	temp = findNode(targetElement, next.getLeft());
        } else {
        	temp = findNode(targetElement, next.getRight());
        }
        
        return temp;
    }
    
    public static void main(String[] args) {
    	// Test functions on LinkedBinarySearchTree of size 1
    	System.out.println("Testing LinkedBinarySearchTree - size = 1");
    	LinkedBinarySearchTree<Integer> searchTree = new LinkedBinarySearchTree<>();
    	
    	System.out.println("Adding element 5 to empty tree...");
    	searchTree.addElement(5);
    	System.out.println("searchTree.contains(5): " + searchTree.contains(5));
    	System.out.println("searchTree size: " + searchTree.size());
    	System.out.println("searchTree height: " + searchTree.getHeight());
    	System.out.println("searchTree rootElement: " + searchTree.getRootElement());
    	System.out.println("searchTree before removeMin: " + searchTree.toString());
    	searchTree.removeMin();
    	System.out.println("searchTree after removeMin: " + searchTree.toString());
    	System.out.println("searchTree height: " + searchTree.getHeight());
    	System.out.println("Adding element 7 to empty tree...");
    	searchTree.addElement(7);
    	System.out.println("searchTree.contains(7): " + searchTree.contains(7));
    	System.out.println("searchTree size: " + searchTree.size());
    	System.out.println("searchTree before removeMax: " + searchTree.toString());
    	searchTree.removeMax();
    	System.out.println("searchTree after removeMax: " + searchTree.toString() + "\n");
    	
    	// Test functioons on LinkedBinarySearchTree of size > 1
    	System.out.println("Testing LinkedBinarySearchTree - size > 1");
    	searchTree.addElement(7);
    	searchTree.addElement(20);
    	searchTree.addElement(15);
    	searchTree.addElement(1);
    	System.out.println("Contents of searchTree after additions: " + searchTree.toString());
    	System.out.println("searchTree size: " + searchTree.size());
    	System.out.println("searchTree height: " + searchTree.getHeight());
    	System.out.println("searchTree rootElement: " + searchTree.getRootElement());
    	System.out.println("searchTree.contains(15): " + searchTree.contains(15));
    	System.out.println("searchTree.contains(3): " + searchTree.contains(3));
    	System.out.println("Min element: " + searchTree.findMin() + "\nMax element: " + searchTree.findMax());
    	System.out.println("Contents of searchTree after findMin and findMax: " + searchTree.toString());
    	searchTree.removeMin();
    	System.out.println("Contents of searchTree after removeMin: " + searchTree.toString());
    	searchTree.removeMax();
    	System.out.println("Contents of searchTree after removeMax: " + searchTree.toString());
    	System.out.println("Min element: " + searchTree.findMin() + "\nMax element: " + searchTree.findMax());
    	System.out.println("searchTree.size(): " + searchTree.size());
    	System.out.println("searchTree height: " + searchTree.getHeight());
    	System.out.println("searchTree rootElement: " + searchTree.getRootElement());
    	System.out.println("Adding 6...");
    	searchTree.addElement(6);
    	System.out.println("Contents of searchTree after additions: " + searchTree.toString());
    	System.out.println("searchTree size: " + searchTree.size());
    	System.out.println("searchTree height: " + searchTree.getHeight());
    	System.out.println("searchTree rootElement: " + searchTree.getRootElement());
    	System.out.println("searchTree.contains(6): " + searchTree.contains(6));
    	System.out.println("searchTree.contains(3): " + searchTree.contains(3));
    	
    	System.out.print("\n");
    	// Benchmark testing
    	LinkedBinaryTree<Integer> lbtBenchMark = fillInt(1024, 0);
    	
    	long startTime = System.nanoTime();
    	long stopTime;
    	lbtBenchMark.find(39367);
    	stopTime = System.nanoTime() - startTime;
    	System.out.println("Time to find bottom-right element in LinkedBinaryTree of size 2049: " + stopTime + " ns");
    	
    	startTime = System.nanoTime();
    	lbtBenchMark.contains(39367);
    	stopTime = System.nanoTime() - startTime;
    	System.out.println("Time to run contains in LinkedBinaryTree: " + stopTime + " ns");
    	
    	LinkedBinarySearchTree<Integer> lbstBenchMark = new LinkedBinarySearchTree<>();
    	
    	boolean first = true;
    	for (int i = 1024, j = 1024; i >= 0 && j <= 2048; i--, j++) {
    		
    		if (first) {
    			lbstBenchMark.addElement(i);
    			first = false;
    		} else {
    			lbstBenchMark.addElement(i);
    			lbstBenchMark.addElement(j);
    		}
    	}
    	
    	startTime = System.nanoTime();
    	lbstBenchMark.find(2048);
    	stopTime = System.nanoTime() - startTime;
    	System.out.println("Time to find bottom-right element in LinkedBinarySearchTree of size 2049: " + stopTime + " ns");
    	startTime = System.nanoTime();
    	lbstBenchMark.contains(2048);
    	stopTime = System.nanoTime() - startTime;
    	System.out.println("Time to run contains in LinkedBinarySearchTree: " + stopTime + " ns");
    }
    
    /**
     * The fillInt utility method populates a LindedBinaryTree with integers
     * and is included here only to facilitate benchmark performance testing of
     * the LinkedBinaryTree's find method vs. the LinkedBinarySearchTree's find method.
     * The algorithm used to populate the tree is not mathematically precise.
     * @param rootVal
     * @param baseVal
     * @return
     */
    public static LinkedBinaryTree<Integer> fillInt(int rootVal, int baseVal) {
    	LinkedBinaryTree<Integer> result = new LinkedBinaryTree<Integer>();
    	
    	if (rootVal % 2 != 0) {
    		return new LinkedBinaryTree<Integer>(baseVal);
    	}
		
		return new LinkedBinaryTree<Integer>(rootVal, fillInt((int)(rootVal*.5), rootVal-1), fillInt((int)(rootVal*1.5), rootVal+1));
	}
}