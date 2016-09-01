import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Palindrome {
	public static boolean isPalindrome(String str) {
		boolean result = true;
		
		Stack<Character> stack = new Stack<>();
		Queue<Character> queue = new LinkedList<>();
		
		for (int i = 0; i < str.length(); i++) {
			stack.push(str.charAt(i));
			queue.add(str.charAt(i));
		}
		
		for (int i = 0; i < str.length(); i++) {
			if (!stack.pop().equals(queue.remove())) {
				result = false;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		System.out.print(isPalindrome(""));
	}
}
