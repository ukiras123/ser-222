public class IntNode {
	private int value;
    private IntNode next;

    public IntNode(int i) {
    	value = i;
    	next = null;
    }
    
    public IntNode() {
    	value = 0;
    	next = null;
    }
    
    public int getInt() {
    	return value;
    }

    public void setInt(int v) {
    	value = v;
    }

    public IntNode getNext() {
    	return next;
    }

    public void setNext(IntNode n) {
    	next = n;
    }
}