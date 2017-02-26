package lab3;

import homework3.VectorList;


/**
 * this class creates a CheeseBurgerNoOnion object
 * @author liang dong
 *
 */
public class CheeseBurgerNoOnion extends VectorList<Integer> {
	
	/**
	 * Constructor creates a CheeseBurgerNoOnion object. 
	 */
	public CheeseBurgerNoOnion() {
		super(6);
		addToEnd(1);// number of bun
		addToEnd(1);// number of patty
		addToEnd(1);// number of lettuce
		addToEnd(1);// number of Tomato
		addToEnd(0);// number of Onion
		addToEnd(1);// number of cheese
	}
		
}