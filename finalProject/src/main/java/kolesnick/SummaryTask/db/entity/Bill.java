package kolesnick.SummaryTask.db.entity;

import kolesnick.SummaryTask.db.Status;

public class Bill extends Entity{

	private static final long serialVersionUID = -764879487870131689L;
	
	private double totalPrice;
	private int contractId;
	private int carId;
	private Status status;
	private int userId;
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getContractId() {
		return contractId;
	}
	public void setContractId(int contractId) {
		this.contractId = contractId;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Bill [totalPrice=" + totalPrice + ", contractId=" + contractId + ", carId=" + carId + ", status="
				+ status + ", userId=" + userId + ", getId()=" + getId() + "]";
	}
	
}
