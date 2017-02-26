package lab3;

import java.util.Random;

/**
 * This Customer creates a customer who has a choice on food.
 * @author liang dong
 *
 */
public class Customer {
	
	/**
	 * choice method
	 * @return a random number from 1 to 6.
	 */
	public int choice() {
		Random r = new Random();
		return r.nextInt(6) + 1;
	}

}
