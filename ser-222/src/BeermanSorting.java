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
        
        //Q2a
        Integer[] b2 = {20, 12, 4};
        quicksortmid(b2);
        assert isSorted(b2);
        show(b2);
        
        //quicksortTest3
        Integer[] qst3 = {12, 20, 15};
        quicksortmid(qst3);
        assert isSorted(qst3);
        show(qst3);
        
        //quicksortTest4
        Integer[] qst4 = {10, 20, 30};
        quicksortmid(qst4);
        assert isSorted(qst4);
        show(qst4);
       
        //Q3
        String[] c = {"S", "O"};
        mergesort(c);
        assert isSorted(c);
        show(c);
        
        //Q4
        String[] d = {"S"};
        mergesort(d);
        assert isSorted(d);
        show(d);
        
        //Q5
        String[] e = {};
        mergesort(e);
        assert isSorted(e);
        show(e);
        
        // isSorted baseline
        Integer[] is = {2, 1};
        boolean baseline = isSorted(is);        
    }
    
    public static void quicksortmid(Comparable[] a) {
        quicksortmid(a, 0, a.length-1);
    }
    
    private static void quicksortmid(Comparable[] data, int minIndex, int maxIndex) {
    	if (minIndex < maxIndex) {
    		int indexOfPartition = partition(data, minIndex, maxIndex);
    		
    		quicksortmid(data, minIndex, indexOfPartition - 1);
    		
    		quicksortmid(data, indexOfPartition + 1, maxIndex);
    	}
    }
    
	private static int partition(Comparable[] data, int minIndex, int maxIndex) {
    	Comparable elemAtMin, elemAtMid, elemAtMax;
    	Comparable partitionElement;
    	int left, right;
    	int midIndex = (minIndex + maxIndex) / 2;
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
    
    public static void mergesort(Comparable[] a) {
        Comparable[] merged = mergeSort(a);
        
        for (int i = 0; i < merged.length; i++) {
        	a[i] = merged[i];
        }
    }
    
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