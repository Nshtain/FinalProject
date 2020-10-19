package kolesnick.SummaryTask.db.entity;

/**
 * Car entity
 *
 */
public class Car extends Entity {

	private static final long serialVersionUID = 4851569582203129092L;

	private String brand;
	private String model;
	private String type;
	private String image;
	private int earOfIssue;
	private String qualityClass;
	private double price;
	private boolean rentered;
	private int damage;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getEarOfIssue() {
		return earOfIssue;
	}

	public void setEarOfIssue(int date) {
		this.earOfIssue = date;
	}

	public String getQualityClass() {
		return qualityClass;
	}

	public void setQualityClass(String qualityClass) {
		this.qualityClass = qualityClass;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isRentered() {
		return rentered;
	}

	public void setRentered(boolean rentered) {
		this.rentered = rentered;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + ", model=" + model + ", type=" + type + ", img=" + image + ", earOfIssue="
				+ earOfIssue + ", qualityClass=" + qualityClass + ", price=" + price + ", rentered=" + rentered
				+ ", id=" + getId() + ", damage=" + damage + "]";
	}

}
