import java.util.LinkedList;
import java.util.Queue;

/**
 * A map-like ADT implemented using a hashtable and the Linear Probing approach
 * for collision resolution.
 * 
 * @author Robert Beerman
 */

public class LinearProbingMap<Key, Value> implements Map<Key, Value> {
	
	private class Entry<Key, Value> {
        public Key key;
        public Value value;
        
        public Entry(Key k, Value v) {
            key = k;
            value = v;
        }
    }
    
    private int N; // number of key-value pairs
    private int M; // hash table size

    private Entry<Key, Value>[] entries;
    
    public LinearProbingMap() {
        this(997);
    }
    
    public LinearProbingMap(int M) {
        this.N = 0;
        this.M = M;
        entries = new Entry[M];
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
		int hash = hash(key, i);
		
		Entry<Key, Value> current = entries[hash];
		
		/* In the real world, we should resize and rehash if we've circled
		back to the original hash without finding an open position. */
		
		while (current != null) {
			if (current.key.hashCode() == key.hashCode()) {
				current.value = val;
				added = true;
				break;
			}
			
			i++;
			hash = hash(key, i);
			current = entries[hash];
		}

		if (!added) {
			entries[hash] = new Entry<Key, Value>(key, val);
			N++;
		}
	}

	@Override
	public Value get(Key key) {
		int i = 0;
		
		Entry<Key, Value> result = entries[hash(key, i)];
		
		if (result != null) {
			if (result.key.hashCode() == key.hashCode()) {
				return result.value;
			}
			
			while (result.key.hashCode() != key.hashCode()) {
				i++;

				result = entries[hash(key, i)];
				
				if (result != null) {
					if (result.key.hashCode() == key.hashCode()) {
						return result.value;
					}
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

			while (entries[hash].key.hashCode() != key.hashCode()) {
				i++;
				hash = hash(key, i);
			}

			entries[hash] = null;
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
			if (entries[i] != null) {
				queue.add(entries[i].key);
			}
		}
		
		return queue;
	}

}
