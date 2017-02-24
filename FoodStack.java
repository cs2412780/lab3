package lab3;

import homework2.VectorStack;
import quickSort.QuickSort;

/**
 *  The FoodStack class stores food and organizes the food.
 * @author liang dong
 *
 */
public class FoodStack {
	
	
	private VectorStack<Integer> stack;
	
	/**
	 * constructor that creates an empty stack with default 100 spaces
	 */
	public FoodStack() {
		stack = new VectorStack<>(100);
	}
	
	/** Adds a new entry to the top of this stack.
    @param newEntry  An object to be added to the stack. */
	public void push(int newItem) {
		stack.push(newItem);
	}
	
	/** Removes and returns this stack's top entry.
    @return  The object at the top of the stack. 
    @throws  EmptyStackException if the stack is empty before the operation. */
	public int pop() {
		return stack.pop();
	}
	
	/** Detects whether this food stack is empty.
    @return  True if the food stack is empty. */
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	/**
	 * This method re-orders the stack by expiration date,
	 * and throws expired food
	 * @param currentDate The date of today
	 */
	public void organizeFoodStack(int currentDate) {
		int[] arr = new int[stack.currentSize()];
		int indexOfLastEntry = -1;
		while(!stack.isEmpty()) {
			if(stack.peek() > currentDate) {
				indexOfLastEntry++;
				arr[indexOfLastEntry] = stack.pop();
			}
			else {
				stack.pop();
			}
		}
		QuickSort.quickSortByRecursion(arr, 0, indexOfLastEntry);
		while(indexOfLastEntry >= 0) {
			stack.push(arr[indexOfLastEntry]);
			indexOfLastEntry--;
		}
	}

	/**
	 * this method
	 * @return the size of the stack
	 */
	public int getSize() {
		return stack.currentSize();
	}
	
}
