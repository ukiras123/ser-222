/**
 * Implements various sorting algorithms.
 * 
 * @author Robert Beerman, Acuna, Sedgewick
 * @version 1.0
 */

public class BeermanSorting {
     
    /**
     * Entry point for sample output.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Q1
        String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        quicksortmid(a);
        
        assert isSorted(a); //requires assertions enabled.
        show(a);
        
        //Q2
        String[] b = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        mergesort(b);
        assert isSorted(b);
        show(b);
        
        String[] c = {};
        Sorting.quickSort(c);
        assert isSorted(c);
        show(c);
    }
    
    public static void quicksortmid(Comparable[] a) {
        quicksortmid(a, 0, a.length-1);
    }
    
    private static void quicksortmid(Comparable[] data, int minIndex, int maxIndex) {
    	if (minIndex < maxIndex) {
    		int indexOfPartition = partition(data, minIndex, maxIndex);
    		
    		
    	}
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	private static int partition(Comparable[] data, int minIndex, int maxIndex) {
    	Comparable elemAtMin, elemAtMid, elemAtMax;
    	Comparable partitionElement;
    	int left, right;
    	int midIndex = (minIndex + maxIndex) / 2;
    	
    	elemAtMin = data[minIndex];
    	elemAtMid = data[midIndex];
    	elemAtMax = data[maxIndex];
    	
    	if (elemAtMin.compareTo(elemAtMid) > 0) {
    		if (elemAtMid.compareTo(elemAtMax) > 0) {
    			partitionElement = elemAtMid;
    		} else if (elemAtMin.compareTo(elemAtMax) > 0){
    			partitionElement = elemAtMax;
    		} else {
    			partitionElement = elemAtMin;
    		}
    	} else {
    		if (elemAtMin.compareTo(elemAtMax) > 0) {
    			partitionElement = elemAtMin;
    		} else if (elemAtMid.compareTo(elemAtMax) > 0) {
    			partitionElement = elemAtMax;
    		} else {
    			partitionElement = elemAtMid;
    		}
    	}
    	
    	return 0;
    }
    
    public static void mergesort(Comparable[] a) {
        //TODO: implement this.
    }
    
    /**
     * Displays contents of array, space separated.
     * @author Sedgewick
     * @param a Array to display.
     */
    private static void show(Comparable[] a) {
        for (Comparable a1 : a)
            System.out.print(a1 + " ");

        System.out.println();
    }
    
    /**
     * Checks if array is in sorted order.
     * @author Sedgewick
     * @param a Array to be checked.
     * @return Returns true if array is sorted.
     */
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1]))
                return false;
        
        return true;
    }
    
    //See previous method.
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
}