package lab3;

import homework2.ArrayQueue;

/**
 * CustomersLine creates a line that can hold 50 customers.
 * @author liang dong
 *
 */
public class CustomersLine {

	private static int lostCustomerDay = 0;
	private ArrayQueue<Integer> line;
	private int numberOfCustomers;
	
	/**
	 * Constructor that creates a line with given capacity
	 * @param capacity The capacity of the line
	 */
	public CustomersLine() {
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
			numberOfCustomers--;
			return line.dequeue();
		}
		return 0;
	}


	/**
	 * @return the lostCustomerDay
	 */
	public int getLostCustomerDay() {
		return lostCustomerDay;
	}

	/**
	 * increment the lost Customer a day
	 */
	public void incrementLostCustomerDay() {
		lostCustomerDay++;
	}
	
	/**
	 * increment the lost Customer a day
	 * @param lostCustomerDay the lostCustomerDay to set
	 */
	public void incrementLostCustomerDay(int extraPeople) {
		lostCustomerDay += extraPeople;
	}
	
	/**
	 * clear the lost Customer a day
	 */
	public void resetLostCustomerDay() {
		lostCustomerDay = 0;
	}
	
	/**
	 * isFull
	 * @return true if line is full
	 */ 
	public boolean isFull() {
		return line.isFull();
	}
	
	/**
	 * size method
	 * @return the number of people in the line
	 */
	public int size() {
		return numberOfCustomers;
	}
	
	/** Removes all entries from this queue. */
	public void clear() {
		while(numberOfCustomers > 0) {
			dequeue();
			numberOfCustomers--;
		}
	}

}
