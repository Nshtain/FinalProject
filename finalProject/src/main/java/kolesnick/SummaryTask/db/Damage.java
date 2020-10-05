package kolesnick.SummaryTask.db;

import kolesnick.SummaryTask.db.entity.Car;

public enum Damage {
	NO_DAMAGE, LOW, MEDIUM, HARD;
	
	private double price = 100;
	
	public static Damage getDamage(Car car) {
		int damageId = car.getDamageId();
		return Damage.values()[damageId];
	}
	
	public String getName() {
		return name().toLowerCase();
	}

	public double getPrice() {
		return price * this.ordinal();
	}

}
