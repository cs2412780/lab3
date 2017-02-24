package lab3;

public class Patty {

	private int expirationDate;

	public Patty(int arrivalDate) {
		this.expirationDate = arrivalDate + 4;
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
