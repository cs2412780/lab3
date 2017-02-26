package lab3;

import homework3.VectorList;

/**
 * this class creates a CheeseBurger object
 * @author liang dong
 *
 */
public class CheeseBurger extends VectorList<Integer> {
	
	/**
	 * Constructor creates a CheeseBurger object. 
	 */
	public CheeseBurger() {
		super(6);
		addToEnd(1);// number of bun
		addToEnd(1);// number of patty
		addToEnd(1);// number of lettuce
		addToEnd(1);// number of Tomato
		addToEnd(1);// number of Onion
		addToEnd(1);// number of cheese
	}

}
