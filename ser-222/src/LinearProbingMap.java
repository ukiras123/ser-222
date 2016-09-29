import java.util.LinkedList;
import java.util.Queue;

/**
 * A map-like ADT implemented using a hashtable and the Linear Probing approach
 * for collision resolution.
 * 
 * @author Robert Beerman
 */

public class LinearProbingMap<Key, Value> implements Map<Key, Value> {
	
	private class Entry {
        public Key key;
        public Value value;
        
        public Entry(Key k, Value v) {
            key = k;
            value = v;
        }
    }
    
    private int N; // number of key-value pairs
    private int M; // hash table size
    
    private LinkedList<Entry>[] entries;
    
    public LinearProbingMap() {
        this(997);
    }
    
    public LinearProbingMap(int M) {
        this.N = 0;
        this.M = M;
        entries = new LinkedList[M];
        
        for (int i = 0; i < M; i++)
            entries[i] = new LinkedList<>();
    }
    
    /**
     * Hash method that increments the object's hashcode by a given value.
     * Useful for Linear Probing.
     * 
     * @param key the key being hashed
     * @param i value by which to increment the hash code
     * @return integer hash value
     */
    public int hash(Key key, int i) {
    	return ((key.hashCode() & 0x7fffffff) + i) % M;
    }
		
	@Override
	public void put(Key key, Value val) {
		boolean added = false;
		int i = 0;
		int origHash = hash(key, i);
		
		Entry current = entries[origHash].peek();
		int hash = origHash;
		
		// In the real world, we should resize and rehash if we've circled
		// back to the original hash without finding an open position.
		// So, I would add something like the following inside the while loop:
		// "if (hash == origHash) resizeRehash();" where resizeRehash() would
		// be some helper method that resizes and rehashes.
		
		while (current != null) {
			if (current.key.hashCode() == key.hashCode()) {
				current.value = val;
				added = true;
				break;
			}
			
			i++;
			hash = hash(key, i);
			current = entries[hash].peek();
		}

		if (!added) {
			entries[hash].add(new Entry(key, val));
			N++;
		}
	}

	@Override
	public Value get(Key key) {
		int i = 0;	
		Entry result = entries[hash(key, i)].peek();
		
		if (result != null) {
			if (result.key.hashCode() == key.hashCode()) {
				return result.value;
			}
			
			while (result.key.hashCode() != key.hashCode()) {
				i++;
				result = entries[hash(key, i)].peek();
				
				if (result.key.hashCode() == key.hashCode()) {
					return result.value;
				}
			}
		}
				
		return null;
	}

	@Override
	public void remove(Key key) {
		if (contains(key)) {
			int i = 0;
			int hash = hash(key, i);
			
			while (entries[hash].peek().key.hashCode() != key.hashCode()) {
				i++;
				hash = hash(key, i);
			}
			
			entries[hash].remove();
			N--;
		}

	}

	@Override
	public boolean contains(Key key) {
		return get(key) != null;
	}

	@Override
	public boolean isEmpty() {
		return N == 0;
	}

	@Override
	public int size() {
		return N;
	}

	@Override
	public Iterable<Key> keys() {
		Queue<Key> queue = new LinkedList<>();
		
		for (int i = 0; i < M; i++) {
			if (entries[i].peek() != null) {
				queue.add(entries[i].peek().key);
			}
		}
		
		return queue;
	}

}
