package lab3;

/**
 * A stack to store food materials.
 * @author liang dong
 *
 */
public interface FoodStack {

	/** Add the arrived date of the food to be added to the stack
    @param newEntry  An the arrived date of the food.
     */
	public void push(int theArrivedDateOfNewItem);
	
	/** Removes and returns this stack's top entry.
    @return  The object at the top of the stack. 
    @throws  EmptyStackException if the stack is empty before the operation. */
	public int pop();
	
	/** Detects whether this BunStack is empty.
    @return  True if the BunStack is empty. */
	public boolean isEmpty();

	/**
	 * This method organizes the stack by expiration date,
	 * and throws expired food.
	 * @param currentDate The date of today.
	 * @return true if the stack is not empty
	 */
	public boolean organizeFoodStack(int currentDate);

	/**
	 * this method
	 * @return the size of the stack
	 */
	public int getSize();

	/**
	 * @return the waste
	 */
	public int getWaste();
	
	/**
	 * Set waste to be zero;
	 */
	public void resetWaste();
}
