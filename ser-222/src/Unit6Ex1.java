import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Unit6Ex1 {

	public static void main(String[] args) {
		List<String> roster = new ArrayList<>();
		roster.add("Rob");
		roster.add("Shelby");
		roster.add("Sammy");
		roster.add("Bobo");

		Iterator<String> iter = roster.iterator();
		
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		
	}

}
