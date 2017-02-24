package lab3;

public class Bun {
	
	private int expirationDate;

	public Bun(int arrivalDate) {
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
