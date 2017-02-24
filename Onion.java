package lab3;

public class Onion {

	private int expirationDate;

	public Onion(int arrivalDate) {
		this.expirationDate = arrivalDate + 5;
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
