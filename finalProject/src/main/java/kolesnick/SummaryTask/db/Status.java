package kolesnick.SummaryTask.db;


/**
 * Status entity.
 */
public enum Status {
	NEW, CONFIRMED, DECLINED, PAID, CLOSED, DAMAGE, PAID_DAMAGE;
	
	
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