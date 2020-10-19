package kolesnick.SummaryTask.db.entity;

/**
 * Contract entity.
 */

import kolesnick.SummaryTask.db.Status;

public class Contract extends Entity {

	private static final long serialVersionUID = -2540413639148097071L;

	private int rentalTerm;
	private boolean withDriver;
	private int carId;
	private int userId;
	private Status status;

	public int getRentalTerm() {
		return rentalTerm;
	}

	public void setRentalTerm(int rentalTerm) {
		this.rentalTerm = rentalTerm;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public boolean isWithDriver() {
		return withDriver;
	}

	public void setWithDriver(boolean withDriver) {
		this.withDriver = withDriver;
	}

	@Override
	public String toString() {
		return "Contract [rentalTerm=" + rentalTerm + ", withDriver=" + withDriver + ", carId=" + carId + ", userId="
				+ userId + ", status=" + status + ", getId()=" + getId() + "]";
	}

}
