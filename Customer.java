package lab3;

import java.util.Random;

/**
 * This Customer creates a customer who has ID and choice on food.
 * @author liang dong
 *
 */
public class Customer {

	private int iD;
	
	/**
	 * Constructor creates a Customer object with an ID number.
	 * @param iD A ID number of this customer.
	 */
	public Customer(int iD) {
		this.iD = iD;
	}
	
	/**
	 * choice method
	 * @return a random number from 1 to 6.
	 */
	public int choice() {
		Random r = new Random();
		return r.nextInt(6) + 1;
	}


	/**
	 * @return the iD
	 */
	public int getiD() {
		return iD;
	}


	/**
	 * @param iD the iD to set
	 */
	public void setiD(int iD) {
		this.iD = iD;
	}
}
