
public class Sum {
	public static void main(String[] args) {
       IntNode a = new IntNode(10);
       IntNode b = new IntNode(5);
       a.setNext(b);
       IntNode c = new IntNode(3);
       b.setNext(c);

       //omitted: code appending more new elements to the list.
	   
       int sum = sumList(a);
       System.out.println("The sum is " + sum);
	}
	
	public static int sumList(IntNode head) {
		if (head.getNext() == null) {
			return head.getInt();
		}
		
		return head.getInt() + sumList(head.getNext());
	}
}
