
public class Factorial {

	public static void main(String[] args) {
		System.out.println(factorial(11));
		System.out.println(fib(41));
		System.out.println(fib2(10));
		System.out.println(fibLoop(100));
	}
	
	public static int factorial(int n) {
		if (n == 0) {
			return 1;
		}
		
		return n * factorial(n-1);
	}
	
	public static long fib(int n) {
	  if (n < 2) return n;

	  return fib(n-1) + fib(n-2);
	}
	
	public static long fib2(int n) {
		if (n == 0) return 0;
		if (n == 1) return 1;
		
		return fib2(n-1) + fib2(n-2);
	}

	public static long fibLoop(int n) {
		long[] array = new long[101];
		array[0] = 0;
		array[1] = 1;
		
		for (int i = 2; i <= n; i++) {
			array[i] = array[i-1] + array[i-2];
		}
		
		return array[n];
	}
}
