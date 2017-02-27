package lab3;

import java.util.Random;

/**
 * Test the lab3 program
 * @author liang dong
 *
 */
public class Test {
	private static CustomersLine line;// A line that holds up to 50 customers
	private static Inventory inventory;
	private static int[] customersChoices = new int[7];// Count the choices on the 6 orders
	
	/**
	 * Fill the line and generate their choices.
	 */
	public void fillLine() {
		line = new CustomersLine();
		Random r = new Random();
		Customer customer = new Customer();
		int[] choices = new int[r.nextInt(100) + 1];
		for(int i = 0; i < choices.length; i++) {
			choices[i] = customer.choice();
		}
		int numberOfPeople = 0; 
		while((!line.isFull()) && (numberOfPeople < choices.length)) {
			line.enqueue(choices[numberOfPeople]);
			numberOfPeople++;
		}
		

		if(50 < choices.length) {
			line.incrementLostCustomerDay(choices.length - 50);
		}
		
	}//end fillLine
	
	/**
	 * getter method
	 * @return The lost customers a day
	 */
	public int getLost() {
		return line.getLostCustomerDay();
	}
	
	/**
	 * Set the LostCustomerDay to be zero.
	 */
	public void resetLost() {
		line.resetLostCustomerDay();
	}
	/**
	 * Serve food for all people in line if the food is available
	 */
	public void serveFood() {
		while(line.size() > 0) {
			int order = line.dequeue();
			if(inventory.placeOrders(order)) {
				customersChoices[order]++;
			}
			else {
				line.incrementLostCustomerDay();
			}
		}
	}//end serveFood
	
	/**
	 * Do one hour of filling the line and serving food.
	 */
	private void doForOneHour() {
		fillLine();
		serveFood();
	}
	
	
	/**
	 * Do one day of filling the line and serving food.
	 * @param currentDate
	 */
	public void doForOneDay(int currentDate) {
		inventory = new Inventory(currentDate);
		customersChoices = new int[7];// clear the people's choices
		for(int i = 10; i <= 19; i++) {
			doForOneHour();
		}
		inventory.organize(currentDate);
	}
	
	/**
	 * Getter method
	 * @return The number of waste of each material.
	 */
	public int[] getWaste() {
		int[] wasteArr = inventory.getWaste();
		return wasteArr;
	}
	
	/**
	 * Getter method
	 * @return The number of orders of each food.
	 */
	public int[] getOrdersOfEachFood() {
		int[] ordersOfEachFood = new int[7];
		for(int i = 1; i <= 6; i++) {
			ordersOfEachFood[i] = customersChoices[i];
		}
		return ordersOfEachFood;
	}// end getOrdersOfEachFood

	/**
	 * Test this program for one month
	 */
	public static void main(String[] args) {

		Test test = new Test();
		for(int i = 1; i <= 31; i++) {
			test.doForOneDay(i);
			System.out.println("*********************");
			System.out.println("Day: 3/" +i);
			if(i % 3 == 1) {
				System.out.println("shipments arrives..");
			}
			System.out.println("customers lost: " + test.getLost());
			int[] wasteArr = test.getWaste();
			int[] ordersOfEachFood = test.getOrdersOfEachFood();
			System.out.println("order 1: " + ordersOfEachFood[1]);
			System.out.println("order 2: " + ordersOfEachFood[2]);
			System.out.println("order 3: " + ordersOfEachFood[3]);
			System.out.println("order 4: " + ordersOfEachFood[4]);
			System.out.println("order 5: " + ordersOfEachFood[5]);
			System.out.println("order 6: " + ordersOfEachFood[6]);
			System.out.println("waste bun: " + wasteArr[1]);
			System.out.println("waste patty: " + wasteArr[2]);
			System.out.println("waste lettuce: " + wasteArr[3]);
			System.out.println("waste tomato: " + wasteArr[4]);
			System.out.println("waste onion: " + wasteArr[5]);
			System.out.println("waste cheese: " + wasteArr[6]);
			System.out.println("*********************\n");
			test.resetLost();
		}
	}

}
