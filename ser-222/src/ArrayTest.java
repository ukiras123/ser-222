import java.util.Arrays;

public class ArrayTest {

	public static void main(String[] args) {
		String[] test = {"A", "B", "C", "D", "E"};
		int rear = test.length;
		
		System.out.println("\nrear: " + rear);
		for (int i = 0; i < test.length; i++) {
			System.out.print(test[i] + " ");
		}
		
		/*String result = test[--rear];
		test[rear] = null;*/
		
		String result = test[0];
        
        for (int i = 0; i < rear-1; i++) {
        	test[i] = test[i+1];
        }
        
        rear--;
        test[rear] = null;

        System.out.println("\nrear: " + rear);
		for (int i = 0; i < test.length; i++) {
			System.out.print(test[i] + " ");
		}
	}

}
