
public class TestStepIterator {

	public static void main(String[] args) {
		ArrayStack<Integer> stack = new ArrayStack<>();
		
		for (int i = 1; i <= 9; i++) {
			stack.push(i);
		}
		
		System.out.println(stack.size());
		System.out.println(stack);
		
		StepIterator<Integer> iter = stack.iterator();
		//iter.setStep(2);
		
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		
		ArrayStack<Integer> emptyStack = new ArrayStack<>();
		StepIterator<Integer> iter2 = emptyStack.iterator();
		
		while (iter2.hasNext()) {
			System.out.print(iter2.next() + " ");
		}
		
		System.out.print("\n");
		StepIterator<Integer> iter3 = stack.iterator();
		
		while (iter3.hasNext()) {
			int k = iter3.next();
			if (k == 4) {
				iter3.remove();
			}
		}
		
		System.out.print(stack);
	}

}
