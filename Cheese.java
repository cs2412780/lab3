package lab3;

public class Cheese {

	private int expirationDate;

	public Cheese(int arrivalDate) {
		this.expirationDate = arrivalDate + 2;
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
