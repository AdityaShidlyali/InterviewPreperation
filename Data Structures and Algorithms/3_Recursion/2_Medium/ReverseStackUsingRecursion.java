import java.util.Scanner;
import java.util.Stack;

public class ReverseStackUsingRecursion {

	private final static void insertAtBottom(Stack<Integer> stack, int elementToInsertAtBottom) {

		// after making the stack empty insert the element at the bottom
		if (stack.isEmpty()) {
			stack.push(elementToInsertAtBottom);
		} else {

			// keep the track of the reversed element of the stack
			int topElement = stack.peek();

			// then pop the tracked element from the stack
			stack.pop();

			// recursively do the operations till the passed elementToInsertAtBottom is
			// inserted at bottom
			insertAtBottom(stack, elementToInsertAtBottom);

			// after inserting the elementToInsertAtBottom at bottom insert the reversed
			// element as it is
			stack.push(topElement);
		}
	}

	private final static void reverseStack(Stack<Integer> stack) {

		if (stack.size() > 0) {

			// keep track of all the top elements recursively
			int topElement = stack.peek();

			// after keeping track of the top element, pop the top element until
			// stack is empty
			stack.pop();

			// recursively hold all the elements of the stack
			reverseStack(stack);

			// then insert the elements at the bottom again recursively
			insertAtBottom(stack, topElement);
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Enter the number of elements: ");
		int n = input.nextInt();

		System.out.println("Enter the elements one by one: ");
		int element;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < n; i++) {
			element = input.nextInt();
			stack.push(element);
		}

		System.out.println("Before reversing stack: " + stack);

		reverseStack(stack);

		System.out.println("After reversing stack: " + stack);

		input.close();
	}
}
