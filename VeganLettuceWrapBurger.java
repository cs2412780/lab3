package lab3;

import homework3.VectorList;

/**
 * this class creates a VeganLettuceWrapBurger object
 * @author liang dong
 *
 */
public class VeganLettuceWrapBurger extends VectorList<Integer> {

	/**
	 * Constructor creates a VeganLettuceWrapBurger object. 
	 */
	public VeganLettuceWrapBurger() {
		super(6);
		addToEnd(0);// number of bun
		addToEnd(0);// number of patty
		addToEnd(2);// number of lettuce
		addToEnd(1);// number of Tomato
		addToEnd(1);// number of Onion
		addToEnd(0);// number of cheese
	}
	
	
}
