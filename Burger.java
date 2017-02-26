package lab3;

import homework3.VectorList;

/**
 * this class creates a burger object
 * @author liang dong
 *
 */
public class Burger extends VectorList<Integer> {

	/**
	 * Constructor creates a Burger object. 
	 */
	public Burger() {
		super(6);
		addToEnd(1);// number of bun
		addToEnd(1);// number of patty
		addToEnd(1);// number of lettuce
		addToEnd(1);// number of Tomato
		addToEnd(1);// number of Onion
		addToEnd(0);// number of cheese
	}

	
	
}
