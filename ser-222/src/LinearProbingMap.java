import java.util.LinkedList;

public class LinearProbingMap<Key, Value> implements Map<Key, Value> {
	
	private class Entry<Key, Value> {
        public Key key;
        public Value value;
        public Entry (Key k, Value v) {
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
        entries = new Entry<Key, Value>[M]);
        /*for (int i = 0; i < M; i++)
            entries[i] = new LinkedList<>();*/
    }
    
    /**
     * 
     * @param key
     * @param i
     * @return
     */
    public int hash(Key key, int i) {
    	return ((key.hashCode() & 0x7fffffff) + i) % M;
    }
		
	@Override
	public void put(Key key, Value val) {
		// TODO Auto-generated method stub

	}

	@Override
	public Value get(Key key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Key key) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean contains(Key key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterable<Key> keys() {
		// TODO Auto-generated method stub
		return null;
	}

}