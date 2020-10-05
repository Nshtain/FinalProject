package kolesnick.SummaryTask.db;

import kolesnick.SummaryTask.db.entity.Contract;
import kolesnick.SummaryTask.db.entity.User;

/**
 * Status entity.
 */
public enum Status {
	WAITING_FOR_PAYMENT, DECLINED, PAID, CLOSED;
	
	
	private String descriptioin;
	public static Status getStatus(Contract contract) {
		int statusId = contract.getStatusId();
		return Status.values()[statusId];
	}
	
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