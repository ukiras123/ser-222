import java.util.NoSuchElementException;

/**
 * DoubleOrderedList testing area.
 * 
 * @author (your name), Acuna
 * @version (version)
 */
public class DriverDoubleOrderedList {
    public static void main(String [] args) {
    	DoubleOrderedList<Integer> list = new DoubleOrderedList<>();
        
        //RA: These are _extremely_ simple tests - do not use them when doing
        //    your writeup.
        
    	list.add(23);
        list.add(24);	
        list.add(16);
        list.add(3);	
        list.add(7);
        list.add(17);	
        list.add(9);	
        list.add(13);	
        list.add(14);	
        list.add(1);

        System.out.println(list);
        
        list.remove(7);
        list.removeFirst();
        list.remove(17);
        list.removeLast();
        list.remove(14);
        list.removeLast();
        
        System.out.println(list);
        
        /* Test Results:
            1 3 7 9 13 14 16 17 23 24 
            3 9 13 16 
        */
        
        //Everything below is additional
        
        System.out.println("\nBegin additional test cases...\n------------------------------");
        DoubleOrderedList<Integer> testRemoveFirst = new DoubleOrderedList<>();
        int testElem1;
        
        try {
        	testElem1 = testRemoveFirst.removeFirst(); // uncomment to test exception
        } catch (EmptyCollectionException e) {
        	System.out.println("No first element to remove");
        }
        testRemoveFirst.add(5);
        // Test removeFirst from list of 1 element
        System.out.println("List before removeFirst: " + testRemoveFirst);
        testElem1 = testRemoveFirst.removeFirst();
        System.out.println("Removed element: " + testElem1);
        System.out.println("List after removeFirst: " + testRemoveFirst);
        
        // Test removeFirst from list of 3 elements
        testRemoveFirst.add(42);
        testRemoveFirst.add(35);
        testRemoveFirst.add(65);
        System.out.println("List before removeFirst (3 elements): " + testRemoveFirst);
        testElem1 = testRemoveFirst.removeFirst();
        System.out.println("Removed element: " + testElem1);
        System.out.println("List after removeFirst: " + testRemoveFirst);
        
        DoubleOrderedList<Integer> testRemoveLast = new DoubleOrderedList<>();
        int testElem2;
        //testElem2 = testRemoveLast.removeLast();
        testRemoveLast.add(13);
        // Test removeLast from list of 1 element
        System.out.println("List before removeLast: " + testRemoveLast);
        testElem2 = testRemoveLast.removeLast();
        System.out.println("Removed element: " + testElem2);
        System.out.println("List after removeLast: " + testRemoveLast);
        
        // Test removeLast from list of 2 elements
        testRemoveLast.add(102);
        testRemoveLast.add(12);
        System.out.println("List before removeLast (2 elements): " + testRemoveLast);
        testElem2 = testRemoveLast.removeLast();
        System.out.println("Removed element: " + testElem2);
        System.out.println("List after removeLast: " + testRemoveLast);
        
        // Test remove()
        DoubleOrderedList<Integer> testRemove = new DoubleOrderedList<>();
        testRemove.add(25);
        testRemove.add(12);
        testRemove.add(3);
        
        // Test matching on first entry
        System.out.println("List before remove(3): " + testRemove);
        int testElem3 = testRemove.remove(3);
        System.out.println("Removed element: " + testElem3);
        System.out.println("List after remove(3): " + testRemove);
        testRemove.add(3);
        System.out.println("List before remove(25): " + testRemove);
        testElem3 = testRemove.remove(25);
        System.out.println("Removed element: " + testElem3);
        System.out.println("List after remove(25): " + testRemove);
        
        System.out.println("List contains 12: " + testRemove.contains(12));
        System.out.println("List contains 3: " + testRemove.contains(3));
        System.out.println("List contains 25: " + testRemove.contains(25));
        System.out.println("List contains 7: " + testRemove.contains(7)); 
    }
}
