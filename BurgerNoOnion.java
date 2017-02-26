package lab3;

import homework3.VectorList;

/**
 * this class creates a BurgerNoOnion object
 * @author liang dong
 *
 */
public class BurgerNoOnion extends VectorList<Integer> {
	
	/**
	 * Constructor creates a BurgerNoOnion object. 
	 */
	public BurgerNoOnion() {
		super(6);
		addToEnd(1);// number of bun
		addToEnd(1);// number of patty
		addToEnd(1);// number of lettuce
		addToEnd(1);// number of Tomato
		addToEnd(0);// number of Onion
		addToEnd(0);// number of cheese
	}
		
}
