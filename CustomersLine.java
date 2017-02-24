package lab3;

import homework2.ArrayQueue;

/**
 * CustomersLine creates a line that can hold 50 customers.
 * @author liang dong
 *
 */
public class CustomersLine {

	private ArrayQueue<Integer> line;
	private int numberOfCustomers;
	
	/**
	 * Constructor that creates a line with given capacity
	 * @param capacity The capacity of the line
	 */
	public CustomersLine(int capacity) {
		line = new ArrayQueue<>(50);
		numberOfCustomers = 0;
	}
	
	/**
	 * Adding people' choices into the line
	 * @param order people's choice
	 * @return true if add successfully
	 */
	public boolean enqueue(int order) {
		if(numberOfCustomers < 50) {
			line.enqueue(order);
			numberOfCustomers++;
			return true;
		}
		return false;
	}
	
	/**
	 * Removing people from the queue
	 * @return This people's choice, return 0 if no people in line.
	 */
	public int dequeue() {
		if(!line.isEmpty()) {
			return line.dequeue();
		}
		return 0;
	}
	
	public static void main(String[] args) {

		
	}

}
