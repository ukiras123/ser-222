import java.util.Arrays;

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
        
        //quicksortmid tests
        System.out.println("\nQUICKSORTMID TESTS");
        System.out.println("quicksortmid - high-to-low, odd # of elements...");
        Integer[] qst1 = {20, 12, 4};
        quicksortmid(qst1);
        assert isSorted(qst1);
        show(qst1);
        
        System.out.println("quicksortmid - includes negatives...");
        Integer[] qst2 = {20, 12, 20, 21, 1, -1, -15};
        quicksortmid(qst2);
        assert isSorted(qst2);
        show(qst2);
        
        System.out.println("quicksortmid - even # of elements...");
        Integer[] qst3 = {12, 20, 13, 15};
        quicksortmid(qst3);
        assert isSorted(qst3);
        show(qst3);
        
        System.out.println("quicksortmid - already sorted...");
        Integer[] qst4 = {10, 20, 30};
        quicksortmid(qst4);
        assert isSorted(qst4);
        show(qst4);
        
        System.out.println("quicksortmid - two-elements, Strings of more than one char...");
        String[] qst5 = {"yaS", "ySa"};
        quicksortmid(qst5);
        assert isSorted(qst5);
        show(qst5);

        System.out.println("quicksortmid - one element...");
        String[] qst6 = {"S"};
        quicksortmid(qst6);
        assert isSorted(qst6);
        show(qst6);

        System.out.println("quicksortmid - empty...");
        String[] qst7 = {};
        quicksortmid(qst7);
        assert isSorted(qst7);
        show(qst7);
       
        //mergesort tests
        System.out.println("MERGESORT TESTS");
        System.out.println("mergesort - high-to-low, odd # of elements...");
        Integer[] mst4 = {20, 12, 4};
        mergesort(mst4);
        assert isSorted(mst4);
        show(mst4);

        System.out.println("mergesort - includes negatives...");
        Integer[] mst5 = {20, 12, 20, 21, 1, -1, -15};
        mergesort(mst5);
        assert isSorted(mst5);
        show(mst5);

        System.out.println("mergesort - even # of elements...");
        Integer[] mst6 = {12, 20, 13, 15};
        mergesort(mst6);
        assert isSorted(mst6);
        show(mst6);

        System.out.println("mergesort - already sorted...");
        Integer[] mst7 = {10, 20, 30};
        mergesort(mst7);
        assert isSorted(mst7);
        show(mst7);
        
        System.out.println("mergesort - two-elements, Strings of more than one char...");
        String[] mst1 = {"yaS", "ySa"};
        mergesort(mst1);
        assert isSorted(mst1);
        show(mst1);
        
        System.out.println("mergesort - one element...");
        String[] mst2 = {"S"};
        mergesort(mst2);
        assert isSorted(mst2);
        show(mst2);
        
        System.out.println("mergesort - empty...");
        String[] mst3 = {};
        mergesort(mst3);
        assert isSorted(mst3);
        show(mst3);
    }
    
	/**
	 * Sorts the specified array of objects using the quick sort algorithm.
	 * 
	 * @param data the array to be sorted
	 */
    public static void quicksortmid(Comparable[] a) {
        quicksortmid(a, 0, a.length-1);
    }
    
    /**
	 * Recursively sorts a range of objects in the specified array using the
	 * quick sort algorithm. 
	 * 
	 * @param data the array to be sorted
	 * @param min  the minimum index in the range to be sorted
	 * @param max  the maximum index in the range to be sorted
	 */
    private static void quicksortmid(Comparable[] data, int minIndex, int maxIndex) {
    	if (minIndex < maxIndex) {
    		int indexOfPartition = partition(data, minIndex, maxIndex);
    		
    		// sort the left partition (lower values)
    		quicksortmid(data, minIndex, indexOfPartition - 1);
    		
    		// sort the right partition (higher values)
    		quicksortmid(data, indexOfPartition + 1, maxIndex);
    	}
    }
    
    /**
	 * Used by the quick sort algorithm to find the partition.
	 * Applies a "middle of three" approach to determine a reasonable partition.
	 * @author Robert Beerman
	 * 
	 * @param data the array to be sorted
	 * @param minIndex  the minimum index in the range to be sorted
	 * @param maxIndex  the maximum index in the range to be sorted
	 */
	private static int partition(Comparable[] data, int minIndex, int maxIndex) {
    	Comparable elemAtMin, elemAtMid, elemAtMax;
    	Comparable partitionElement;
    	int left, right;
    	// In case it's a particularly large array ;)
    	int midIndex = (maxIndex - minIndex) / 2 + minIndex;
    	int partitionIndex = midIndex; // for now
    	
    	elemAtMin = data[minIndex];
    	elemAtMid = data[midIndex];
    	elemAtMax = data[maxIndex];
    	
    	// use the middle of three data value as the partition element
    	if (elemAtMin.compareTo(elemAtMid) > 0) {
    		if (elemAtMid.compareTo(elemAtMax) > 0) {
    			partitionElement = elemAtMid;
    			partitionIndex = midIndex;
    		} else if (elemAtMin.compareTo(elemAtMax) > 0){
    			partitionElement = elemAtMax;
    			partitionIndex = maxIndex;
    		} else {
    			partitionElement = elemAtMin;
    			partitionIndex = minIndex;
    		}
    	} else {
    		if (elemAtMin.compareTo(elemAtMax) > 0) {
    			partitionElement = elemAtMin;
    			partitionIndex = minIndex;
    		} else if (elemAtMid.compareTo(elemAtMax) > 0) {
    			partitionElement = elemAtMax;
    			partitionIndex = maxIndex;
    		} else {
    			partitionElement = elemAtMid;
    			partitionIndex = midIndex;
    		}
    	}
    	
    	// move the partition element out of the way for now
    	swap(data, partitionIndex, minIndex);
    	
    	left = minIndex;
    	right = maxIndex;
    	
    	while (left < right) {
    		// search for an element that is > the partition element
			while (left < right && data[left].compareTo(partitionElement) <= 0)
			left++;
		
			// search for an element that is < the partition element
			while (data[right].compareTo(partitionElement) > 0)
				right--;
			
			// swap the elements
			if (left < right)
				swap(data, left, right);
	    }
    	
    	// move the partition element into place
    	swap(data, minIndex, right);
    	
    	return right;
    }
    
    /**
     * Sorts the specified array of objects using the merge sort
     * algorithm.
     * @author Robert Beerman
     *
     * @param a the array to be sorted
     */
    public static void mergesort(Comparable[] a) {
        Comparable[] merged = mergeSort(a);
        
        for (int i = 0; i < merged.length; i++) {
        	a[i] = merged[i];
        }
    }
    
    /**
	 * Recursively sorts a range of objects in the specified array using the
	 * merge sort algorithm.
	 * @author Robert Beerman
     *
     * @param a the array to be sorted
     */
    public static Comparable[] mergeSort(Comparable[] a) {
    	Comparable[] merged = new Comparable[a.length];

    	if (a.length <= 1) {
    		return a;
    	} else {
    		int mid = (a.length - 1) / 2;
    		Comparable[] left = mergeSort(Arrays.copyOfRange(a, 0, mid + 1));
    		Comparable[] right = mergeSort(Arrays.copyOfRange(a, mid+1, a.length));
    		    		
    		merged = merge(left, right);
    	}
    	
    	return merged;
    }
    
    /**
     * Merges two sorted subarrays of the specified array.
     * @author Robert Beerman
     *
     * @param a the "left" subarray to be merged
     * @param b the "right" subarray to be merged 
     */
    public static Comparable[] merge(Comparable[] a, Comparable[] b) {
    	Comparable[] merged = new Comparable[a.length + b.length];
    	
    	int firsta = 0, lasta = a.length - 1;
    	int firstb = 0, lastb = b.length - 1;
    	int index = 0;
    	
    	while (firsta <= lasta && firstb <= lastb) {
    		if (a[firsta].compareTo(b[firstb]) < 0) {
    			merged[index] = a[firsta];
    			firsta++;
    		} else {
    			merged[index] = b[firstb];
    			firstb++;
    		}
    		index++;
    	}
    	
    	while (firsta <= lasta) {
    		merged[index] = a[firsta];
    		firsta++;
    		index++;
    	}
    	
    	while (firstb <= lastb) {
    		merged[index] = b[firstb];
    		firstb++;
    		index++;
    	}
    	
    	return merged;
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
    @SuppressWarnings("rawtypes")
	public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1]))
                return false;
        
        return true;
    }
    
    //See previous method.
    @SuppressWarnings("rawtypes")
	private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    
    /**
	 * Swaps to elements in an array. Used by various sorting algorithms.
	 * 
	 * @param data   the array in which the elements are swapped
	 * @param index1 the index of the first element to be swapped
	 * @param index2 the index of the second element to be swapped
	 */
	@SuppressWarnings("rawtypes")
	private static void swap(Comparable[] data, int index1, int index2)
	{
		Comparable temp = data[index1];
		data[index1] = data[index2];
		data[index2] = temp;
	}
}