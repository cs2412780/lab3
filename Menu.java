package lab3;

import homework3.VectorList;

/**
 * This Menu class creates a menu that contains six different food
 * @author liang dong
 *
 */
public class Menu {
	
	
	private static VectorList<Integer>[] list;
	private static int count;
	
	static{
		@SuppressWarnings("unchecked")
		VectorList<Integer>[] temp = new VectorList[7];
		list = temp;
		list[1] = new Burger();
		list[2] = new CheeseBurger();
		list[3] = new VeganLettuceWrapBurger();
		list[4] = new BurgerNoOnion();
		list[5] = new CheeseBurgerNoOnion();
		list[6] = new BurgerNoTomato();
		count = 0;
	}
	
	/**
	 * Getter method
	 * @param order The order number
	 * @param material The food material number
	 * @return The number of the needed food material for the order.
	 */
	public int getQuantity(int order, int material) {
		return list[order].look(material - 1);
	}


	/**
	 * The method increments count when a food is sold.
	 */
	public static void incrementCount() {
		count++;
	}
	
	/**
	 * The method
	 * @return the count of food sold.
	 */
	public static int getCount() {
		return count;
	}
}
