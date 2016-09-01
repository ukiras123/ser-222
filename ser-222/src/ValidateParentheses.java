import java.util.Stack;

public class ValidateParentheses {
	
	public static void main(String[] args) {
		String input = "(a+b)";

		System.out.print(isBalanced(input));
	}
	
	public static boolean isBalanced(String input) {
		Stack<Character> stack = new Stack<Character>();
		
		for (int i=0; i<input.length(); i++) {
			char token = input.charAt(i);
			
			if (token == ')') {
				if (stack.isEmpty()) {
					return false;
				} else {
					stack.pop();
				}
			} else if (token == '(') {
				stack.push(token);
			}
		}
		
		return stack.isEmpty();
	}
}
