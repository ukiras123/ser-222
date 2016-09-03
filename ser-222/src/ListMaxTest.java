
public class ListMaxTest {

	public static void main(String[] args) {
		IntNode first = new IntNode();
		IntNode second = new IntNode();
		IntNode third = new IntNode();
		first.setInt(5);
		second.setInt(10);
		third.setInt(3);
		first.setNext(second);
		second.setNext(third);
		
		System.out.println(listMax(first));

	}
	
	public static int listMax(IntNode node) {
		int max = 0;
		
		max = node.getInt();
		
		while (node.getNext() != null) {
			node = node.getNext();
			if (node.getInt() > max) {
				max = node.getInt();
			}
		}
		
		return max;
	}

}
