package lab3;

import homework2.VectorStack;
import integerSortingAlgorithm.IntegerSortingAlgorithm;


/**
 * A stack to store patty.
 * @author liang dong
 *
 */
public class PattyStack implements FoodStack {

	private static int waste = 0;
	private static VectorStack<Integer> stack = new VectorStack<>(1000);
	
	/** Add the arrived date of the food to be added to the stack
    @param newEntry  An the arrived date of the food.
     */
	@Override
	public void push(int theArrivedDateOfNewItem) {
		stack.push(theArrivedDateOfNewItem + 4);
	}
	
	/** Removes and returns this stack's top entry.
    @return  The object at the top of the stack. 
    @throws  EmptyStackException if the stack is empty before the operation. */
	@Override
	public int pop() {
		return stack.pop();
	}
	
	/** Detects whether this PattyStack is empty.
    @return  True if the PattyStack is empty. */
	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	/**
	 * This method organizes the stack by expiration date,
	 * and throws expired food.
	 * @param currentDate The date of today.
	 * @return true if the stack is not empty
	 */
	@Override
	public boolean organizeFoodStack(int currentDate) {
		int[] arr = new int[stack.currentSize()];
		int sizeBeforeOrganizing = stack.currentSize();
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
		waste += sizeBeforeOrganizing - (indexOfLastEntry + 1);
		
		if(indexOfLastEntry > -1) {
			IntegerSortingAlgorithm.quickSortByRecursion(arr, 0, indexOfLastEntry);
		}
		while(indexOfLastEntry >= 0) {
			stack.push(arr[indexOfLastEntry]);
			indexOfLastEntry--;
		}
		if(stack.isEmpty()) {
			return false;
		}
		else {
			return true;
		}
	}//end organizeFoodStack

	/**
	 * this method
	 * @return the size of the stack
	 */
	@Override
	public int getSize() {
		return stack.currentSize();
	}

	/**
	 * @return the waste
	 */
	@Override
	public int getWaste() {
		return waste;
	}
	
	/**
	 * Set waste to be zero;
	 */
	@Override
	public void resetWaste() {
		waste = 0;
	}

}
