import java.util.Arrays;

public class ArrayTest {

	public static void main(String[] args) {
		int[] intArray = {3, 4};
		int[] copyOfZero = Arrays.copyOfRange(intArray, 0, 1);
		
		for (int z = 0; z < copyOfZero.length; z++) {
			System.out.print("copyOfZero: " + copyOfZero[z] + " ");
		}
		
		System.out.print("\n");
		
		for (int i = 0; i < intArray.length; i++) {
			System.out.print(intArray[i] + " ");
		}
		
		System.out.print("\n");
		
		int[] newArray;
		newArray = intArray;
		
		for (int i = 0; i < newArray.length; i++) {
			System.out.print(newArray[i] + " ");
		}

	}

}
