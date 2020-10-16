package kolesnick.SummaryTask.db;


/**
 * Status entity.
 */
public enum Status {
	WAITING_FOR_PAYMENT, DECLINED, PAID, CLOSED, DAMAGE;
	
	
	private String descriptioin;
	
	public String getName() {
		return name().toLowerCase();
	}
	
	public void setDescription(String description) {
		this.descriptioin = description;
	}
	
	public String getDescription() {
		return descriptioin;
	}
}