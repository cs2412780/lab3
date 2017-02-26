package lab3;


/**
 * Inventory class keeps track of all of the food, in addition to orders placed and items and customer lost. 
 * @author liang dong
 */
public class Inventory {
	private static int shippingDate = 0;// equal to zero if it is the shipping day
	public static FoodStack[] arr = new FoodStack[7];
	private static int[] markIfEmpty = new int[7];//Non-zero if the material is unavailable
	private static int[] foodSoldOutIndicator = new int[7];//Non-zero if the order is unavailable, [0] has nothing
	
	/**
	 * Constructor initializes all FoodStacks and reset availability marks
	 * @param currentDate The date of the current day
	 */
	public Inventory(int currentDate) {
		arr[1] = new BunStack();
		arr[2] = new PattyStack();
		arr[3] = new LettuceStack();
		arr[4] = new TomatoStack();
		arr[5] = new OnionStack();
		arr[6] = new CheeseStack();
		for(int i = 1; i <= 6; i++) {
			arr[i].resetWaste();
		}
		
		if(shippingDate == 0) // do addShipments and reset availability marks when equal to zero.
		{
			addShipments(currentDate);
			markIfEmpty = new int[7];
			foodSoldOutIndicator = new int[7];
			shippingDate++;
		}
		else if(shippingDate == 2) {
			shippingDate = 0;
		}
		else {
			shippingDate++;
		}
	}//end constructor
	
	/**
	 * Add shipments into all food stacks.
	 */
	private void addShipments(int currentDate) {
		int numberOfItems = Shipments.loadingShipments();
		for(int i = 0; i < numberOfItems; i++) {
			arr[1].push(currentDate);
		}
		numberOfItems = Shipments.loadingShipments();
		for(int i = 0; i < numberOfItems; i++) {
			arr[2].push(currentDate);
		}
		numberOfItems = Shipments.loadingShipments();
		for(int i = 0; i < numberOfItems; i++) {
			arr[3].push(currentDate);
		}
		numberOfItems = Shipments.loadingShipments();
		for(int i = 0; i < numberOfItems; i++) {
			arr[4].push(currentDate);
		}
		numberOfItems = Shipments.loadingShipments();
		for(int i = 0; i < numberOfItems; i++) {
			arr[5].push(currentDate);
		}
		numberOfItems = Shipments.loadingShipments();
		for(int i = 0; i < numberOfItems; i++) {
			arr[6].push(currentDate);
		}
	}//end addShipments
	
	/**
	 * Organize the food stacks by expiration date and throws out of date food, 
	 * and mark if any stack is empty.
	 */
	public void organize(int currentDate) {
		boolean hasChanged = false;
		if(!arr[1].organizeFoodStack(currentDate)) {
			markIfEmpty[1] = 1;
			hasChanged = true;
		}
		if(!arr[2].organizeFoodStack(currentDate)) {
			markIfEmpty[2] = 2;
			hasChanged = true;
		}
		if(!arr[3].organizeFoodStack(currentDate)) {
			markIfEmpty[3] = 3;
			hasChanged = true;
		}
		if(!arr[4].organizeFoodStack(currentDate)) {
			markIfEmpty[4] = 4;
			hasChanged = true;
		}
		if(!arr[5].organizeFoodStack(currentDate)) {
			markIfEmpty[5] = 5;
			hasChanged = true;
		}
		if(!arr[6].organizeFoodStack(currentDate)) {
			markIfEmpty[6] = 6;
			hasChanged = true;
		}
		if(arr[3].getSize() == 1) // number of lettuce is one.
		{
			markIfEmpty[0] = 9;
			hasChanged = true;
		}
		if(hasChanged) {
			updateIndicator();
		}

	}// end organize
	
	/**
	 * Decrement the used items, and return an non-zero array if any order cannot be served any more.
	 * @param order The order number
	 */
	private void decrementItems(int order) {
		Menu menu = new Menu();
		for(int i = 1; i<= 6; i++) // from BunStack to CheeseStack
		{
			int quantity = menu.getQuantity(order,i);// number of a material are needed in particular order
			for(int j = 0; j < quantity; j++) {
				if(quantity == 2 && (arr[3].getSize() == 2||arr[3].getSize() == 3)) {
					if(arr[3].getSize() == 3) {
						markIfEmpty[0] = 9;
					}
					if(arr[3].getSize() == 2) {
						markIfEmpty[i] = i;
					}
					arr[i].pop();
					arr[i].pop();
					break;
				}
				else if(arr[i].getSize() == 1) {
					arr[i].pop();
					markIfEmpty[i] = i;
				}
				else {
					arr[i].pop();
				}
			}
		}
		if(arr[3].getSize() == 1) {
			markIfEmpty[0] = 9;
		}
	}// end decrementItems
	
	/**
	 * Place an order
	 * @param order The order from a customer
	 * @return True if order is places successfully.
	 */
	public boolean placeOrders(int order) {
		return isAbleTosell(order);
	}//end placeOrders
	
	/**
	 * Check if able to sell the food.
	 * @param order The order from a customer
	 * @return True if food is available.
	 */
	private boolean isAbleTosell(int order) {
		if(foodSoldOutIndicator[order] == 0) {
			decrementItems(order);
			updateIndicator();
			return true;
		}
		else {
			return false;
		}
	}//end isAbleTosell
	
	
	/**
	 * Update the food sold out indicator to be non-zero if that food is unavailable.
	 */
	private void updateIndicator() {
		if(markIfEmpty[0] == 9)// number of Lettuce is 1.
		{
			foodSoldOutIndicator[3] = 1;
		}
		if(markIfEmpty[1] != 0 || markIfEmpty[2] != 0)// bun or patty sold out 
		{
			foodSoldOutIndicator[1] = 1;
			foodSoldOutIndicator[2] = 1;
			foodSoldOutIndicator[4] = 1;
			foodSoldOutIndicator[5] = 1;
			foodSoldOutIndicator[6] = 1;
		}
		if(markIfEmpty[3] != 0)// Lettuce sold out 
		{
			foodSoldOutIndicator[1] = 1;
			foodSoldOutIndicator[2] = 1;
			foodSoldOutIndicator[3] = 1;
			foodSoldOutIndicator[4] = 1;
			foodSoldOutIndicator[5] = 1;
			foodSoldOutIndicator[6] = 1;
		}
		if(markIfEmpty[4] != 0)// Tomato sold out 
		{
			foodSoldOutIndicator[1] = 1;
			foodSoldOutIndicator[2] = 1;
			foodSoldOutIndicator[3] = 1;
			foodSoldOutIndicator[4] = 1;
			foodSoldOutIndicator[5] = 1;
		}
		if(markIfEmpty[5] != 0)// Onion sold out 
		{
			foodSoldOutIndicator[1] = 1;
			foodSoldOutIndicator[2] = 1;
			foodSoldOutIndicator[3] = 1;
			foodSoldOutIndicator[6] = 1;
		}
		if(markIfEmpty[6] != 0)// Cheese sold out 
		{
			foodSoldOutIndicator[2] = 1;
			foodSoldOutIndicator[5] = 1;

		}
	}//end updateIndicator
	
	
	/**
	 * generate an array of waste
	 * @return Array of waste
	 */
	public int[] getWaste() {
		int[] wasteArr = new int[7];
		for(int i = 1; i <= 6; i++) {
			wasteArr[i] = arr[i].getWaste();
		}
		return wasteArr;
	}//end getWaste
	
}// end Inventory
