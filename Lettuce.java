package lab3;

public class Lettuce {

	private int expirationDate;

	public Lettuce(int arrivalDate) {
		this.expirationDate = arrivalDate + 3;
	}
	
	/**
	 * @return the expirationDate
	 */
	public int getExpirationDate() {
		return expirationDate;
	}

	/**
	 * @param expirationDate the expirationDate to set
	 */
	public void setExpirationDate(int expirationDate) {
		this.expirationDate = expirationDate;
	}
}
