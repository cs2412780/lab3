package lab3;

public class Tomato {
	private int expirationDate;

	public Tomato(int arrivalDate) {
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
