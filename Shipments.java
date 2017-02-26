package lab3;

import java.util.Random;

/**
 * Shipments generates a number between 700 - 1000.
 * @author liang dong
 *
 */
public class Shipments {

	/**
	 * This method
	 * @return the radom number between 700 - 1000.
	 */
	public static int loadingShipments() {
		Random r = new Random();
		return r.nextInt(301) + 700;
	}

}
